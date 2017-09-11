package br.com.bitclouds.cormen.chapter2;

import br.com.bitclouds.cormen.utils.sortingUtil;

public class ImprovedMergeSort {
	
	public static void main(String[] args) {
		int[] ints = {1, 7, 9, 11, 13, 2, 4, 6, 8, 10};
		int p = 0;
		int q = 5;
		int r = 9;
		int[] newArray = sort(ints, p, q, r);
		System.out.println(sortingUtil.toString(newArray));
	}
	
	public static int[] sort(int[] ints, int p, int q, int r){
		int newArrayLength = r+1;
		int[] newArray = new int[newArrayLength];
		for(int i = 0;i<=newArrayLength-1;i++){
			if(q==newArrayLength||ints[p]<=ints[q]){
				newArray[i]=ints[p];
				p++;
			}else{
				newArray[i]=ints[q];
				q++;
			}
		}
		return(newArray);
	}
	
}
