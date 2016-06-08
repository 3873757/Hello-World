package edu.michael.crystalball.stripes;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Hello world!
 *
 */
public class StripesDriver 
{
	  public static void main(String[] args) throws Exception {
		  
	    Configuration conf = new Configuration();
	    
	    Job job = Job.getInstance(conf, "relative_frequency_stripes");
	    
	    job.setJarByClass(StripesDriver.class);
	    job.setMapperClass(StripesMapper.class);
	    //job.setCombinerClass(StubMapper.class);
	    job.setReducerClass(StripesReducer.class);
	    
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(MapWritable.class);
	    
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}
