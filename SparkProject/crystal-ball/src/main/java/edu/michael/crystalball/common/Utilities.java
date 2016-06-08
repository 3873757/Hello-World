package edu.michael.crystalball.common;

import java.util.Map;

import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class Utilities {
	
	public static StringBuilder MapWritableToString(MapWritable Hf) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		for(Map.Entry<Writable, Writable> entry : Hf.entrySet())
		{			
			sb.append("(");
			sb.append(entry.getKey().toString());
			sb.append(", ");
			sb.append(entry.getValue().toString());
			sb.append(")");
		}
		
		sb.append("]");
		return sb;
	}
	
	public static StringBuilder StripeToString(Map<String, Double> Hf) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		for(Map.Entry<String, Double> entry : Hf.entrySet())
		{			
			sb.append("(");
			sb.append(entry.getKey().toString());
			sb.append(", ");
			sb.append(entry.getValue().toString());
			sb.append(")");
		}
		
		sb.append("]");
		return sb;
	}
}
