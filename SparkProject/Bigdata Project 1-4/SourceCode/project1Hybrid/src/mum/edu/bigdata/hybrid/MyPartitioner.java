package mum.edu.bigdata.hybrid;

import org.apache.hadoop.mapreduce.Partitioner;

import org.apache.hadoop.io.IntWritable;


public class MyPartitioner extends Partitioner<WordPair, IntWritable> {

	@Override
	public int getPartition(WordPair key, IntWritable value, int numberOfReducers) {
		
		Integer i = Integer.parseInt(key.key.toString());
		
		if(i<30)
			return 0;
		else if(i>30 && i<60)
			return 1%numberOfReducers;
		else
			return 2%numberOfReducers;
		
		 
	}

}
