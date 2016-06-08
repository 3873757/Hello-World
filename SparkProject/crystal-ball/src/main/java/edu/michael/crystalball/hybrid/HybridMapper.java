package edu.michael.crystalball.hybrid;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.mortbay.log.Log;

public class HybridMapper extends Mapper<LongWritable, Text, Pair, IntWritable>{
	
	private Map<Pair, Integer> H;
	private static String separator = "\\s";
	public static String marker = "*";
	private static final Logger LOG = Logger.getLogger(HybridMapper.class.getName());
	
	@Override
	public void setup(Context context) throws IOException, InterruptedException {
		H = new HashMap<Pair, Integer>();
	}

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		//super.map(key, value, context);
		LOG.info("Reading line: " + value.toString());
		
		List<String> lineData = Arrays.asList(value.toString().split(separator));
		
		for (int i = 0; i < lineData.size() - 1; i ++) {
			
			for (int j = i + 1; j < lineData.size(); j++){
				
				if (lineData.get(j).equals(lineData.get(i))) break;
				
				Pair mapKey = new Pair(lineData.get(i), lineData.get(j));
				
				if(!H.containsKey(mapKey)){
					H.put(mapKey, 1);
				}
				else{				
					H.put(mapKey, H.get(mapKey).intValue() + 1);
				}
				
			}
		}		
		
	}

	@Override
	protected void cleanup(Context context) throws IOException, InterruptedException {
		
		//super.cleanup(context);
		
		for (Map.Entry<Pair, Integer> entry : H.entrySet()){
			
			context.write(entry.getKey(), new IntWritable(entry.getValue().intValue()));
			
			LOG.info("Emit: ("+entry.getKey().getFirstValue().toString()+", "+entry.getKey().getSecondValue().toString()+"), "+entry.getValue().toString());
			
		}
		
		
	}

}
