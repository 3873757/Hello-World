package edu.michael.crystalball.hybrid;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

import edu.michael.crystalball.common.Utilities;
import edu.michael.crystalball.hybrid.Pair;

public class HybridReducer extends Reducer<Pair, IntWritable, Text, Text> {
	
	private static String separator = "\\s";
	public static String marker = "*";
	private static final Logger LOG = Logger.getLogger(HybridMapper.class.getName());
	
	int marginal;
	String currentTerm;
	private Map<String, Double> H;
	
	@Override
	protected void setup(Context context) throws IOException, InterruptedException {
		marginal = 0;
		H = new HashMap<String, Double>();
		currentTerm = null;
	}
	
	@Override
	protected void reduce(Pair pair, Iterable<IntWritable> values, Context context)  throws IOException, InterruptedException {
		
		LOG.info("Pair: ("+pair.getFirstValue().toString()+", "+pair.getSecondValue().toString()+")");
		LOG.info("Current: "+currentTerm);
		
		if (currentTerm == null){
			currentTerm = pair.getFirstValue().toString();
			LOG.info("============================================");
			LOG.info("Current: "+currentTerm);
		}
		else if( !currentTerm.equals(pair.getFirstValue().toString()) ){
			
			LOG.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			StringBuilder sb1 = Utilities.StripeToString(H);
			LOG.info("Intermediate>>> ("+currentTerm+", "+sb1.toString()+" )");
			
			for ( String key : H.keySet()){
				
				if(H.get(key) != null && marginal != 0){
					
					double freq = H.get(key).doubleValue() /(double) marginal;
					H.put(key, Double.valueOf(freq));
				}
			}
			
			StringBuilder sb = Utilities.StripeToString(H);
			context.write(new Text(currentTerm), new Text(sb.toString()) );
			
			LOG.info("Emit>>> ("+currentTerm+", "+sb.toString()+" )");
			
			//Reset for new term
			marginal = 0;
			H.clear();
			currentTerm = pair.getFirstValue().toString();
			
		}
		LOG.info("Marginal: "+marginal);
		LOG.info("----------------------------------------------------");
		
		for(IntWritable value : values){
			
			LOG.info("Pair: ("+pair.getFirstValue()+", "+pair.getSecondValue()+") >> Value = "+value.toString());
			//LOG.info("Value: "+value.toString());
		
			
			if(H.containsKey(pair.getSecondValue().toString()) && H.get(pair.getSecondValue().toString()) != null){
				
				H.put(pair.getSecondValue().toString(), Double.valueOf(H.get(pair.getSecondValue().toString()).doubleValue() + (double)value.get()));
			}
			else{
				H.put(pair.getSecondValue().toString(), Double.valueOf((double)value.get()));
			}
			
			marginal = marginal + value.get();
		}
		
		LOG.info("marginal: "+marginal);
		LOG.info("############################################################");

	}
	
	
	@Override
	protected void cleanup(Context context) throws IOException, InterruptedException {
		
		for ( String key : H.keySet()){
			
			if(H.get(key) != null && marginal != 0){
				
				double freq = H.get(key).doubleValue() / (double)marginal;
				H.put(key, Double.valueOf(freq));
			}
		}
		
		StringBuilder sb = Utilities.StripeToString(H);
		context.write(new Text(currentTerm), new Text(sb.toString()) );
		
	}

}
