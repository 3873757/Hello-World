package mum.edu.bigdata.stripes;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;


public class Pair implements WritableComparable
{
	public Text Word;
	public Text neighbor;
	
	public Pair()
	{
		this.Word = new Text();
		this.neighbor = new Text();
	}
	public Pair(Text k,Text v)
	{
		this.Word = k;
		this.neighbor = v;
	}
	public Pair(String k,String v)
	{
		this.Word = new Text(k);
		this.neighbor = new Text(v);
	}
	
	@Override
	public boolean equals(Object b)
	{
		Pair p = (Pair)b;
		return p.Word.equals(this.Word) && p.neighbor.equals(this.neighbor);
	}
	
	@Override
	public int hashCode()
	{
		return Word.hashCode() * 10 + neighbor.hashCode();
	}
	
	@Override
	public String toString()
	{
		return Word+","+neighbor;
	}


	@Override
	public void readFields(DataInput arg0) throws IOException {
		 
		this.Word.readFields(arg0);
		this.neighbor.readFields(arg0);
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		this.Word.write(arg0);
		this.neighbor.write(arg0);
	}

	@Override
	public int compareTo(Object o) {
			
		Pair p1 = (Pair)o;
		int k = this.Word.compareTo(p1.Word); 
		
		if(k!=0)
			return k;
		else
			return this.neighbor.compareTo(p1.neighbor); 
	}
	
	
}

