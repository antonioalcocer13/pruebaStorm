import backtype.storm.Config;
import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.utils.Utils;
import backtype.storm.tuple.Values;
import backtype.storm.tuple.Fields;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Created by antonio on 27/03/16.
 */
public class TestWordSpoutUtad  extends BaseRichSpout {
    boolean _isDistributed;
    SpoutOutputCollector _collector;

    public TestWordSpoutUtad() {
        this(true);
    }

    public TestWordSpoutUtad(boolean isDistributed) {
        _isDistributed = isDistributed;
    }

    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        _collector = collector;
    }

    public void close() {

    }

    public void nextTuple() {
        Utils.sleep(100);
        final String[] words = new String[] {"Antonio", "Jorge", "Marta", "Belen", "Nacho",
                "Elia", "Johanna", "Raul", "Manuel", "Guillermo", "Tamara"};
        final Random rand = new Random();
        final String word = words[rand.nextInt(words.length)];
        _collector.emit(new Values(word));
    }

    public void ack(Object msgId) {

    }

    public void fail(Object msgId) {

    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("word"));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        if(!_isDistributed) {
            Map<String, Object> ret = new HashMap<String, Object>();
            ret.put(Config.TOPOLOGY_MAX_TASK_PARALLELISM, 1);
            return ret;
        } else {
            return null;
        }
    }
}