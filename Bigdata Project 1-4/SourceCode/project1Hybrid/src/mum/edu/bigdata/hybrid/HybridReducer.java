package mum.edu.bigdata.hybrid;

import java.io.IOException;
import java.util.HashMap;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class HybridReducer extends Reducer<WordPair, IntWritable, Text, Text> {
	
	private String prevValue;
	
	private HashMap<String,Integer> ds;
	
	public HybridReducer()
	{
		prevValue = null;
		
		ds = new HashMap<String,Integer>();
		
	}
	
  @Override
  public void reduce(WordPair key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {
	  
		  Integer sum = 0;
		  
		  //1. Sum all values
		  for(IntWritable value : values)
		  {
			  sum = sum + value.get();
		  }
		  
		  if(key.key.toString().equals(prevValue) || prevValue==null)
		  {
			 //Keep building hashmap
			  upsert(key,sum);
		  }
		  else
		  {
			  context.write(new Text(prevValue), format(ds));
			  ds = new HashMap<String,Integer>();
			  upsert(key,sum);
		  }
		  prevValue = key.key.toString();
		  
  }
  
  @Override
protected void cleanup(Context context) throws IOException,
		InterruptedException {
	  context.write(new Text(prevValue), format(ds));
}

private void upsert(WordPair p, Integer value)
  {
  	if(ds.keySet().contains(p.neighbor.toString()))
  	{
  		ds.put(p.neighbor.toString(),(Integer)ds.get(p.neighbor.toString()) + value);
  	}
  	else
  	{
  		ds.put(p.neighbor.toString(),1);
  	}
  }
  private Text format(HashMap<String,Integer> m)
  {
	  double sum =  0;
	  for(String s : m.keySet())
	   {
		  sum = sum + m.get(s);
	   }
	  StringBuilder obj = new StringBuilder();
	  obj.append("[");
	  for(String s : m.keySet())
	   {
		  double frequency =   (m.get(s) / sum); 
		  DoubleWritable result = new DoubleWritable(frequency);
		  obj.append("("+s+","+result.get()+")");		  
	   }
	  obj.append("]");
	  return new Text(obj.toString());
  }
}