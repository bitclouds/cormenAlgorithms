package br.com.bitclouds.cormen.chapter2;

public class improvedMergeSort {
	
	public static void main(String[] args) {
		int[] ints = {1, 7, 9, 11, 13, 2, 4, 6, 8, 10};
		int p = 0;
		int q = 5;
		int r = 9;
		int[] novaMatriz = bsort(ints, p, q, r);
	}
	
	public static int[] bsort(int[] ints, int p, int q, int r){
		int novaMatrizLength = r+1;
		int[] novaMatriz = new int[novaMatrizLength];
		for(int i = 0;i<=novaMatrizLength-1;i++){
			if(q==novaMatrizLength||ints[p]<=ints[q]){
				novaMatriz[i]=ints[p];
				p++;
			}else{
				novaMatriz[i]=ints[q];
				q++;
			}
		}
		return(novaMatriz);
	}
	
}
