package br.com.bitclouds.cormen.chapter3;

import br.com.bitclouds.cormen.utils.sortingUtil;

public class DivideAndConquer {
	public static void main(String[] args) {
		int[] A = {-1,1,-1,3,2,-1};
		int low = 0;
		int high = A.length-1;
		MaxSubarray maxSubarray = findMaxSubarray(A, low, high);
		System.out.println(maxSubarray.low+";"+maxSubarray.high+";"+maxSubarray.sum);
	}

	public static MaxSubarray findMaxSubarray(int[] A, int low, int high){
		System.out.println("Input: A: "+sortingUtil.toString(A)+"; low: "+low+"; high: "+high);
		if(high == low){
				System.out.println("When high==low; high: "+high+"; low: "+low+"; A[low]: "+A[low]);
				return new MaxSubarray(low, high, A[low]);
		}else{ 
			System.out.println("Calculates ; low: "+low+"; high: "+high);
			int mid = (low+high)/2;
			System.out.println("findMaxSubarray(A, low, mid); A: "+sortingUtil.toString(A)+"; low: "+low+"; mid: "+mid);
			MaxSubarray leftSubarray = findMaxSubarray(A, low, mid);
			System.out.println("findMaxSubarray(A, mid+1, high); A: "+sortingUtil.toString(A)+"; mid+1: "+mid+1+"; high: "+high);
			MaxSubarray rightSubarray= findMaxSubarray(A, mid+1, high);
			System.out.println("findMaxCrossingSubarray(A, low, mid, high); A: "+sortingUtil.toString(A)+"; low: "+low+"; mid: "+mid+"; high: "+high);
			MaxSubarray crossSubarray= findMaxCrossingSubarray(A, low, mid, high);
			if ((leftSubarray.sum>=rightSubarray.sum)&&(leftSubarray.sum>=crossSubarray.sum)){
				return(leftSubarray);
			}else{
				if ((rightSubarray.sum >= leftSubarray.sum)&&(rightSubarray.sum>=crossSubarray.sum)){
						return(rightSubarray); 
					}else{
					return(crossSubarray);
				}
			}
		}
	}
	
	public static MaxSubarray findMaxCrossingSubarray(int[] A, int low, int mid, int high){
		System.out.println("maxLeft, maxRight = 0");
		int maxLeft = 0, maxRight = 0;
		System.out.println("leftsum: -999999");
		int leftSum = -999999;
		System.out.println("sum: 0");
		int sum = 0;
		System.out.println("for i = mid; i >= low; i--");
		for (int i = mid; i >= low; i--) {
			System.out.println("index: "+i);
			System.out.println(sum+"+="+A[i]);
			sum = sum+A[i];
			System.out.println("sum="+sum);
			System.out.println("leftSum: "+leftSum);
			if(sum > leftSum){
				System.out.println("leftSum="+leftSum);
				leftSum = sum;
				System.out.println("maxRight="+i);
				maxLeft = i;
			}
		}
		System.out.println("rightSum: -999999");
		int rightSum = -999999;
		System.out.println("sum: 0");
		sum = 0;
		for (int i = mid+1; i <= high; i++) {
			System.out.println(sum+"+="+A[i]);
			sum = sum+A[i];
			System.out.println("sum="+sum);
			if(sum>rightSum){
				System.out.println("rightSum="+sum);
				rightSum = sum;
				System.out.println("maxRight="+i);
				maxRight = i;
			}
		}
		System.out.println(maxLeft+";"+maxRight+";"+rightSum+"+"+leftSum);
		return(new MaxSubarray(maxLeft, maxRight, rightSum+leftSum));
	}
}
