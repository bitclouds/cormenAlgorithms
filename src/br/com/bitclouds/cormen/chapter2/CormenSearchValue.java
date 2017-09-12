package br.com.bitclouds.cormen.chapter2;

public class CormenSearchValue {
	public static void main(String[] args) {
		int[] ints = {};
		int var = 1;
		ints = new int[] {2, 3, 1};
	}
	
	public static Integer search(int[] ints, int var){
		for(int i=0;i<ints.length;i++){
			if(ints[i]==var){
				return(i);
			}
		}
		return(null);
	}
}
