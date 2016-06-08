package edu.michael.crystalball.stripes;

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
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.mortbay.log.Log;

public class StripesMapper extends
		Mapper<LongWritable, Text, Text, MapWritable> {

	// private Map<Pair, Integer> H;
	private static String separator = "\\s";
	public static String marker = "*";
	private static final Logger LOG = Logger.getLogger(StripesMapper.class.getName());

	@Override
	public void setup(Context context) throws IOException, InterruptedException {
		// H = new HashMap<Pair, Integer>();
	}

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		// super.map(key, value, context);
		LOG.info("Reading line: " + value.toString());

		List<String> lineData = Arrays.asList(value.toString().split(separator));

		for (int i = 0; i < lineData.size() - 1; i++) {
			
			MapWritable H = new MapWritable();

			for (int j = i + 1; j < lineData.size(); j++) {
				
				if (lineData.get(j).equals(lineData.get(i)))
					break;

				Text mapKey = new Text(lineData.get(j));
				
				if (!H.containsKey(mapKey)) {
					H.put(mapKey, new IntWritable(1));
				}
				else {

					IntWritable count = (IntWritable) H.get(mapKey);

					H.put(mapKey, new IntWritable(count.get() + 1));
				}
			}
			
			context.write(new Text(lineData.get(i)), H);
		}

	}


}
