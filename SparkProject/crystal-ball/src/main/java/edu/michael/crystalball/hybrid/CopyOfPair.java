package edu.michael.crystalball.hybrid;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class CopyOfPair implements WritableComparable<CopyOfPair> {
	
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

	
	public CopyOfPair(){
		this.firstValue = new Text();
		this.secondValue = new Text();
	}
	
	public CopyOfPair(Text firstValue, Text secondValue){
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}
	
	public CopyOfPair(String firstValue, String secondValue){
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

	public int compareTo(CopyOfPair o) {
		int cmp = firstValue.compareTo(o.firstValue);
		if(cmp != 0) return cmp;
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
		CopyOfPair other = (CopyOfPair) obj;
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
