package edu.michael.crystalball.stripes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Reducer;

import edu.michael.crystalball.common.Utilities;

public class StripesReducer extends Reducer<Text, MapWritable, Text, Text> {
	
	private static String separator = "\\s";
	public static String marker = "*";
	
	@Override
	protected void reduce(Text text, Iterable<MapWritable> stripes, Context context)
			throws IOException, InterruptedException {
		
		//super.reduce(pair, values, context);
		//Map<Text, DoubleWritable> Hf = new HashMap<Text, DoubleWritable>();
		MapWritable Hf = new MapWritable();
		double marginal = 0.0;
		
		for(MapWritable stripe : stripes){
			for(Map.Entry<Writable, Writable> entry : stripe.entrySet()){
				Text key = (Text) entry.getKey();
				int stripeValue = ( (IntWritable) entry.getValue()).get();
				double storedValue = 0;
				if(Hf.containsKey(key)){
					storedValue =  ( (DoubleWritable) Hf.get(key) ).get();
				}
		
				//double added = stripeValue + storedValue;
				DoubleWritable value = new DoubleWritable(stripeValue + storedValue);
				
				Hf.put(key, value);
				
				marginal = marginal + stripeValue;
			}
		}
		
		for (Map.Entry<Writable, Writable> entry : Hf.entrySet()){
			DoubleWritable newValue = new DoubleWritable(((DoubleWritable) Hf.get(entry.getKey())).get() / marginal);
			Hf.put(entry.getKey(), newValue);
		}
		
		StringBuilder sb = Utilities.MapWritableToString(Hf);
		
		context.write(text, new Text(sb.toString()));
		
	}

	
}
