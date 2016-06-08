package mum.edu.bigdata.stripes;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class StripesDriver {

  @SuppressWarnings("deprecation")
public static void main(String[] args) throws Exception {

    
    if (args.length != 2) {
      System.out.printf("Usage: StubDriver <input dir> <output dir>\n");
      System.exit(-1);
    }
    Job job = new Job();
    job.setJarByClass(StripesDriver.class);
     job.setJobName("Word Count - Driver");

    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    FileInputFormat.addInputPath(job, new Path(args[0]));
   
   
    job.setMapperClass(StripesMapper.class);
    job.setReducerClass(StripesReducer.class);
    job.setPartitionerClass(StripesPartitioner.class);
    job.setNumReduceTasks(3);
    
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(MapWritable.class);
  
    boolean success = job.waitForCompletion(true);
    System.exit(success ? 0 : 1);
  }
}

