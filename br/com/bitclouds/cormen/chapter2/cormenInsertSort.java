package br.com.bitclouds.cormen.chapter2;

public class cormenInsertSort {
	public static void main(String[] args) {
		int[] ints = {5, 2, 4, 6, 1, 3};
		print(ints);
		print(sort(ints));
	}
	
	public static int[] sort(int[] ints){
		for(int j = 0; j<ints.length;j++){
			int key = ints[j];
			int i = j-1;
			while(i>=0 && ints[i]>key){
				ints[i+1]=ints[i];
				i=i-1;
			}
			ints[i+1]=key;
		}
		return(ints);
	}
	
	
	public static void print(int[] ints){
		System.out.println("Matriz: "+sortingUtil.toString(ints));		
	}
}
