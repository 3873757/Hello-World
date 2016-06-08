package edu.michael.crystalball.pairs;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class CrystalBallReducer extends Reducer<Pair, IntWritable, Pair, DoubleWritable> {
	
	private static String separator = "\\s";
	public static String marker = "*";
	private double marginal;
	
	@Override
	protected void setup(Reducer<Pair, IntWritable, Pair, DoubleWritable>.Context context)
			throws IOException, InterruptedException {		

		//super.setup(context);
		marginal = 0.0;
	}	
	
	@Override
	protected void reduce(Pair pair, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		
		//super.reduce(pair, values, context);
		int sum = 0;
		double  relativeFrequency = 0.0;
		
	
		if (pair.getSecondValue().toString().equals(marker)){
			marginal = 0;
			for(IntWritable value : values){
				marginal = marginal + value.get();
			}
		}
		else {
			for(IntWritable value : values){
				sum = sum + value.get();
			}
			
			if (marginal != 0){
				relativeFrequency = sum / marginal;
			}
			
			context.write(pair, new DoubleWritable(relativeFrequency));
			
		}		
		
	}
	
	@Override
	protected void cleanup(Reducer<Pair, IntWritable, Pair, DoubleWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		super.cleanup(context);
	}

}
