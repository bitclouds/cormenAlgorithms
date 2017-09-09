package br.com.bitclouds.cormen.chapter2;

public class cormenMergeSort {
	public static void main(String[] args) {
		int[] A = {1,3,5,7,2,4,6};
		int p = 0;
		int q = 3;
		int r = 6;
		System.out.println(sortingUtil.toString(A));
		System.out.println(sortingUtil.toString(merge(A, p, q, r)));
	}
	
	public static int[] merge(int[] A, int p, int q, int r){
		int n1 = q-p+1; // last index of the first virtual array
		System.out.println("last index of the first virtual array "+n1);
		int n2 = r-q; // last index of the second virtual array
		System.out.println("last index of the second virtual array "+n2);
		int[] L = new int[n1+1]; // creates a concrete array based on the first virtual array plus one slot
		System.out.println("size of the first concrete array "+Integer.sum(n1,2));
		int[] R = new int[n2+1]; // creates a concrete array based on the second virtual array plus one slot
		System.out.println("size of the second concrete array "+Integer.sum(n2,2));
		for(int i = 0; i < n1; i++){
			L[i] = A[p+i]; // populates first concrete array except by the additional slot
			System.out.println("Populates L "+sortingUtil.toString(L)+" with "+A[p+i]);
		}
		for(int j = 0; j < n2; j++){
			R[j] = A[q+j+1];   // populates second concrete array except by the additional slot
			System.out.println("Populates R "+sortingUtil.toString(R)+" with "+A[q+j+1]);
		}
		L[n1]=99999999; // fills first additional slot with a big number
		System.out.println("Populates "+sortingUtil.toString(L)+" with "+99999999);
		R[n2]=99999999; // fills second additional slot with a big number
		System.out.println("Populates "+sortingUtil.toString(R)+" with "+99999999);
		int i = 0; //reset i pointer
		int j = 0; //reset j pointer
		for(int k = p; k <= r; k++){
			if(L[i]<=R[j]){
				A[k] = L[i]; // if the position in the first array is bigger, move it to the final array
				i = i+1;
			}else{
				A[k] = R[j]; // if the position in the second array is bigger, move it to the final array
				j = j+1;
			}
		}
		return(A); // return the final array
	}

}
