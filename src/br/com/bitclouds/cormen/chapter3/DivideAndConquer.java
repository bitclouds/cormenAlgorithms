package br.com.bitclouds.cormen.chapter3;

public class DivideAndConquer {
	public static void main(String[] args) {
		int[] A = {-1,1,-1,-1,2,-1};
		int low = 0;
		int high = A.length-1;
		MaxSubarray maxSubarray = findMaxSubarray(A, low, high);
		System.out.println(maxSubarray.low+";"+maxSubarray.high+";"+maxSubarray.sum);
	}

	public static MaxSubarray findMaxSubarray(int[] A, int low, int high){
		if(high == low){
				return new MaxSubarray(low, high, A[low]);
		}else{ 
			int mid = (low+high)/2;
			MaxSubarray leftSubarray = findMaxSubarray(A, low, mid);
			MaxSubarray rightSubarray= findMaxSubarray(A, mid+1, high);
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
		int maxLeft = 0, maxRight = 0;
		int leftSum = -999999;
		System.out.println("leftsum: "+leftSum);
		int sum = 0;
		System.out.println("sum: 0");
		for (int i = mid; i >= low; i--) {
			System.out.println(sum+"+="+A[i]);
			sum = sum+A[i];
			System.out.println("sum="+sum);
			if(sum > leftSum){
				System.out.println("leftSum="+leftSum);
				leftSum = sum;
				System.out.println("maxRight="+i);
				maxLeft = i;
			}
		}
		int rightSum = -999999;
		System.out.println("rightSum: "+rightSum);
		sum = 0;
		System.out.println("sum: 0");
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
