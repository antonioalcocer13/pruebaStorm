import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

import java.util.Map;

public class ExclamationBolt extends BaseRichBolt {

    OutputCollector _collector;

    @Override
    public void prepare(Map conf, TopologyContext context, OutputCollector collector) {

        _collector = collector;
    }

    @Override
    public void execute(Tuple tuple) {
        /******************************************************************
         *
         * Código que se ejecutará en esta topología
         *
         ******************************************************************/
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

        /********************************************************************
         *
         * Descripción de la tupla de salida
         *
         *******************************************************************/
    }


}

