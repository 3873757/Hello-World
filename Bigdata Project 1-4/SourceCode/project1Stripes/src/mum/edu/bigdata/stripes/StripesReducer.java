package mum.edu.bigdata.stripes;

import java.io.IOException;
import java.util.Map.Entry;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Reducer;

public class StripesReducer extends Reducer<Text, MapWritable, Text, Text> {

  @Override
  public void reduce(Text key, Iterable<MapWritable> values, Context context)
      throws IOException, InterruptedException {
	  
	   
	  MapWritable finalList = new MapWritable();
	  
	   for(MapWritable dataset : values)
	   {
		   for(Entry<Writable, Writable> s : dataset.entrySet())
		   {
			   if(finalList.keySet().contains(s.getKey().toString()))
			   {
				   IntWritable value = (IntWritable) s.getValue();
				   IntWritable preValue = (IntWritable)finalList.get(s.getKey());
				   finalList.put(s.getKey(), new IntWritable(value.get()+preValue.get()));
			   }
			   else
			   {
				   IntWritable value = (IntWritable) s.getValue();
				   finalList.put(s.getKey(), new IntWritable(value.get()));
			   }
		   }
		   
	   }
	   context.write(key, format(finalList));

  }
  
  private Text format(MapWritable m)
  {
	  double sum =  0;
	  for(Entry<Writable, Writable> s : m.entrySet())
	   {
		  IntWritable value = (IntWritable)s.getValue();
		  sum = sum + value.get();
	   }
	  StringBuilder obj = new StringBuilder();
	  obj.append("[");
	  for(Entry<Writable, Writable> s : m.entrySet())
	   {
		  IntWritable value = (IntWritable)s.getValue();
		  double frequency =  (Double) (value.get() / sum); 
		  DoubleWritable result = new DoubleWritable(frequency);
		  obj.append("("+s.getKey().toString()+","+result.get()+")");		  
	   }
	  obj.append("]");
	  return new Text(obj.toString());
  }
  
}
