package mum.edu.bigdata.pairs;

/*import org.apache.hadoop.mapreduce.Job;

public class StubDriver {

  public static void main(String[] args) throws Exception {

    
     * Validate that two arguments were passed from the command line.
     
    if (args.length != 2) {
      System.out.printf("Usage: StubDriver <input dir> <output dir>\n");
      System.exit(-1);
    }

    
     * Instantiate a Job object for your job's configuration. 
     
    Job job = new Job();
    
    
     * Specify the jar file that contains your driver, mapper, and reducer.
     * Hadoop will transfer this jar file to nodes in your cluster running 
     * mapper and reducer tasks.
     
    job.setJarByClass(StubDriver.class);
    
    
     * Specify an easily-decipherable name for the job.
     * This job name will appear in reports and logs.
     
    job.setJobName("Stub Driver");

    
     * TODO implement
     
    
    
     * Start the MapReduce job and wait for it to finish.
     * If it finishes successfully, return 0. If not, return 1.
     
    boolean success = job.waitForCompletion(true);
    System.exit(success ? 0 : 1);
  }*/
import org.apache.hadoop.conf.Configuration;
	import org.apache.hadoop.fs.Path;
	import org.apache.hadoop.io.IntWritable;
	import org.apache.hadoop.mapreduce.Job;
	import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
	import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

	import java.io.IOException;

	
	public class RelativeFrequencyDriver {

	    public static void main(String[] args) throws IOException,InterruptedException,ClassNotFoundException {
	        Job job = Job.getInstance(new Configuration());
	        job.setJarByClass(RelativeFrequencyDriver.class);
	        job.setJobName("Relative_Frequencies");

	        FileInputFormat.addInputPath(job, new Path(args[0]));
	        FileOutputFormat.setOutputPath(job, new Path(args[1]));

	        job.setMapperClass(PairsRFMapper.class);
	        job.setReducerClass(PairsRFReducer.class);
	        job.setCombinerClass(PairsReducer.class);
	        job.setPartitionerClass(WordPairPartitioner.class);
	        job.setNumReduceTasks(3);

	        job.setOutputKeyClass(WordPair.class);
	        job.setOutputValueClass(IntWritable.class);
	        System.exit(job.waitForCompletion(true) ? 0 : 1);

	    }
	}
