package edu.michael.crystalball.pairs;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class Pair implements WritableComparable<Pair> {
	
	Text firstValue;
	Text secondValue;
	

	public Text getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(Text firstValue) {
		this.firstValue = firstValue;
	}

	public Text getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(Text secondValue) {
		this.secondValue = secondValue;
	}

	
	public Pair(){
		this.firstValue = new Text();
		this.secondValue = new Text();
	}
	
	public Pair(Text firstValue, Text secondValue){
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}
	
	public Pair(String firstValue, String secondValue){
		this.firstValue = new Text(firstValue);
		this.secondValue = new Text(secondValue);
	}

	public void readFields(DataInput in) throws IOException {
		firstValue.readFields(in);
		secondValue.readFields(in);
		
	}

	public void write(DataOutput out) throws IOException {
		firstValue.write(out);
		secondValue.write(out);
		
	}
	
	@Override
	public String toString() {
		return "(" + firstValue + ", " + secondValue + ")";
	}

	public int compareTo(Pair o) {
		int cmp = firstValue.compareTo(o.firstValue);
		if(cmp != 0) return cmp;
		if(this.secondValue.toString() == "*") return -1;
		else if(o.secondValue.toString() == "*") return 1;
		return secondValue.compareTo(o.secondValue);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstValue == null) ? 0 : firstValue.hashCode());
		result = prime * result
				+ ((secondValue == null) ? 0 : secondValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (firstValue == null) {
			if (other.firstValue != null)
				return false;
		} else if (!firstValue.equals(other.firstValue))
			return false;
		if (secondValue == null) {
			if (other.secondValue != null)
				return false;
		} else if (!secondValue.equals(other.secondValue))
			return false;
		return true;
	}

}
