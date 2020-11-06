package edu.nwmissouri.bigdatastorm;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.testing.TestWordSpout;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;
import java.util.HashMap;
import java.util.Map;

public class Topology {
	private static final String SENTENCE_SPOUT_ID = "sentence-spout";
	private static final String SPLIT_BOLT_ID = "split-bolt";
	private static final String COUNT_BOLT_ID = "count-bolt";
	// private static final String REPORT_BOLT_ID = "report-bolt";
	private static final String TOPOLOGY_NAME = "word-count-topology";
	public static void main(String[] args) throws Exception {
        ReadSpout spout = new ReadSpout();
		SplitBolt splitBolt = new SplitBolt();
		WordCountBolt countBolt = new WordCountBolt();
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout(SENTENCE_SPOUT_ID, spout);
        // ReadSpout --> SplitBolt
		builder.setBolt(SPLIT_BOLT_ID, splitBolt)
		.shuffleGrouping(SENTENCE_SPOUT_ID);
		// SplitBolt --> WordCountBolt
		builder.setBolt(COUNT_BOLT_ID, countBolt)
		.fieldsGrouping(SPLIT_BOLT_ID, new Fields("word"));
		// WordCountBolt --> ReportBolt
		// builder.setBolt(REPORT_BOLT_ID, reportBolt)
		// .globalGrouping(COUNT_BOLT_ID);
		Config config = new Config();
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology(TOPOLOGY_NAME, config, builder.
				createTopology());
		cluster.killTopology(TOPOLOGY_NAME);
		cluster.shutdown();
	}
}