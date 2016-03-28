import backtype.storm.topology.TopologyBuilder;
import backtype.storm.Config;
import backtype.storm.StormSubmitter;
import backtype.storm.LocalCluster;
import backtype.storm.utils.Utils;

/**
 * Created by antonio on 27/03/16.
 */

public class myTopology {



    public static void main(String[] args) throws Exception {
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("my-spout", new MySpout(), 2);
        builder.setBolt("my-bolt", new MyBolt(), 2).shuffleGrouping("my-spout");

        Config conf = new Config();
        conf.setDebug(true);

        if (args != null && args.length > 0) {
            conf.setNumWorkers(1);

            StormSubmitter.submitTopology(args[0], conf, builder.createTopology());
        }
        else {

            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("mytopology", conf, builder.createTopology());
            Utils.sleep(10000);
            cluster.killTopology("mytopology");
            cluster.shutdown();
        }
    }
}
