package mum.edu.bigdata.pairs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.collections.map.HashedMap;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PairsRFMapper extends Mapper<LongWritable, Text, WordPair, IntWritable> {
	Map moutput = new HashedMap();
	private WordPair wordPair = new WordPair();
    private IntWritable ONE = new IntWritable(1);
    private IntWritable totalCount = new IntWritable();

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException,
			InterruptedException {
		String line = value.toString();
		ArrayList<String> obj = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(line);
		while (st.hasMoreTokens()) {
			obj.add(st.nextToken());
		}
		for (int i = 0; i < obj.size() - 1; i++) {
			IntWritable totalCount = new IntWritable();
			int count = 0;
			for (int j = i + 1; j < obj.size(); j++) {
				if(obj.get(i).equals(obj.get(j)))
					break;
				wordPair.setWord(obj.get(i));
				wordPair.setNeighbor(obj.get(j));
				context.write(wordPair, ONE);
			 count++;
			}
			totalCount.set(count);
			wordPair.setNeighbor("*");
			context.write(wordPair, totalCount);
		}
		
	}
}
