package mum.edu.bigdata.hybrid;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;


public class WordPair implements WritableComparable
{
	public Text key;
	public Text neighbor;
	
	public WordPair()
	{
		this.key = new Text();
		this.neighbor = new Text();
	}
	public WordPair(Text k,Text v)
	{
		this.key = k;
		this.neighbor = v;
	}
	public WordPair(String k,String v)
	{
		this.key = new Text(k);
		this.neighbor = new Text(v);
	}
	
	@Override
	public boolean equals(Object b)
	{
		WordPair p = (WordPair)b;
		return p.key.equals(this.key) && p.neighbor.equals(this.neighbor);
	}
	
	@Override
	public int hashCode()
	{
		return key.hashCode() * 10 + neighbor.hashCode();
	}
	
	@Override
	public String toString()
	{
		return key+","+neighbor;
	}


	@Override
	public void readFields(DataInput arg0) throws IOException {
		 
		this.key.readFields(arg0);
		this.neighbor.readFields(arg0);
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		this.key.write(arg0);
		this.neighbor.write(arg0);
	}

	@Override
	public int compareTo(Object o) {
			
		WordPair p1 = (WordPair)o;
		int k = this.key.compareTo(p1.key); 
		
		if(k!=0)
			return k;
		else
			return this.neighbor.compareTo(p1.neighbor); 
	}
	
	
}
