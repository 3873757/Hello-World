package mum.edu.bigdata.stripes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StripesMapper extends Mapper<LongWritable, Text, Text, MapWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	  String line = value.toString();
		ArrayList<String> obj = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(line);
		while (st.hasMoreTokens()) {
			obj.add(st.nextToken());
		}
		HashMap<String,Integer> dataset;
		for (int i = 0; i < obj.size() - 1; i++) {
			dataset = new HashMap<String,Integer>();
			for (int j = i + 1; j < obj.size(); j++) {
				if(obj.get(i).equals(obj.get(j)))
					break;
	  
    		else 
    		{
    			if(dataset.keySet().contains(obj.get(j)))
    			{
    				dataset.put(obj.get(j),(Integer)dataset.get(obj.get(j)) + 1); 
    			}
    			else
    				dataset.put(obj.get(j),1); 
    		}    		
    	}
    	
    	context.write(new Text(obj.get(i)),format(dataset));
    }

  }
  
  private MapWritable format(HashMap<String,Integer> ds)
  {
	  MapWritable obj = new MapWritable();
	  
	  for(String s: ds.keySet())
	  {
		  obj.put(new Text(s), new IntWritable(ds.get(s)));
	  }
	  return obj;
  }
  
 
  
}
