package mum.edu.bigdata.hybrid;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class HybridDriver {

  @SuppressWarnings("deprecation")
public static void main(String[] args) throws Exception {

       if (args.length != 2) {
      System.out.printf("Usage: StubDriver <input dir> <output dir>\n");
      System.exit(-1);
    }

    
    Job job = new Job();
    
    
    job.setJarByClass(HybridDriver.class);
    
    
    job.setJobName("Hybrid Approach for relative frequencies - Driver");

    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    FileInputFormat.addInputPath(job, new Path(args[0]));
   
   
    job.setMapperClass(HybridMapper.class);
    job.setReducerClass(HybridReducer.class);
    job.setPartitionerClass(MyPartitioner.class);
    job.setNumReduceTasks(3);
    
   
     job.setOutputKeyClass(WordPair.class);
     job.setOutputValueClass(IntWritable.class);
    
    
    boolean success = job.waitForCompletion(true);
    System.exit(success ? 0 : 1);
  }
}

