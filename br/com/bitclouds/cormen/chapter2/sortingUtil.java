package br.com.bitclouds.cormen.chapter2;

public class sortingUtil {
	public static String toString(int[] ints){
		StringBuffer buffer = new StringBuffer();
		for(int i:ints){
			buffer.append(i+",");
		}
		if(buffer.length()!=0){
			buffer.deleteCharAt(buffer.length()-1);
		}
		return("["+buffer.toString()+"]");
	}

}
