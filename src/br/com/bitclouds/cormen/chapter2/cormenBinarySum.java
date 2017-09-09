package br.com.bitclouds.cormen.chapter2;

public class cormenBinarySum {
	public static void main(String[] args) {
		int[] A = {1,1,0,0,0,1,0,1,1,0};
		int[] B = {1,0,0,1,0,1,0,1,1,0};
		int[] C = new int[A.length+1];
		sum(A, B, C);
	}
	
	public static int[] sum(int[] A, int[] B, int[] C){
		int[] D = new int[A.length+1];
		D[D.length-1]=0;
		for(int i = A.length-1; i >= 0; i--){
			int value = A[i]+B[i]+D[i+1];
			if(value%2==1){
				C[i+1]=1;
			}
			if(value>=2){
				D[i]=1;
			}
		}
		C[0]=D[0];
		return(C);
	}

}
