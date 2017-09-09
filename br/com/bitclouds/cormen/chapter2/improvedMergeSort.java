package br.com.bitclouds.cormen.chapter2;

public class improvedMergeSort {
	
	public static void main(String[] args) {
		int[] ints = {1, 7, 9, 11, 13, 2, 4, 6, 8, 10};
		int p = 0;
		int q = 5;
		int r = 9;
		print(ints, p, q, r);
		int[] novaMatriz = bsort(ints, p, q, r);
		print(novaMatriz, p, q, r);
	}
	
	public static void print(int[] ints, int p, int q, int r){
		System.out.println("Matriz: "+sortingUtil.toString(ints)
		+"; Início do Primeiro Arranjo: "+p
		+"; Fim do Primeiro Arranjo: "+q
		+"; Início do Segundo Arranjo: "+ Integer.sum(q,1) 
		+"; Fim do Segundo Arranjo: "+r);		
	}
	
	public static int[] revert(int[] ints, int q, int r){
		while(q+1<=r-1){
			int swap = ints[q];
			ints[q] = ints[r];
			ints[r] = swap;
			q++;
			r--;
		}
		return(ints);
	}
	
	public static int[] sort(int[] ints, int p, int q, int r){
		ints = revert(ints, q, r);
		int novaMatrizLength = r+1;
		int[] novaMatriz = new int[novaMatrizLength];
		for(int i = 0;i<=novaMatrizLength-1;i++){
			if(ints[p]<=ints[r]){
				novaMatriz[i]=ints[p];
				p++;
			}else{
				novaMatriz[i]=ints[r];
				r--;
			}
		}
		return(novaMatriz);
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