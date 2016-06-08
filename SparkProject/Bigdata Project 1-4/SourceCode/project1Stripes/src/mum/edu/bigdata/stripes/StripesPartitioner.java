package mum.edu.bigdata.stripes;
import org.apache.hadoop.mapreduce.Partitioner;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;


public class StripesPartitioner extends Partitioner<Text, MapWritable> {

	@Override
	public int getPartition(Text key, MapWritable value, int numberOfReducers) {
		
		Integer i = Integer.parseInt(key.toString());
		
		if(i<30)
			return 0;
		else if(i>30 && i<60)
			return 1%numberOfReducers;
		else
			return 2%numberOfReducers;
		
		 
	}

}