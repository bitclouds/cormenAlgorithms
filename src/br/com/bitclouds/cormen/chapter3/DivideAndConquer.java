package br.com.bitclouds.cormen.chapter3;

import br.com.bitclouds.cormen.utils.sortingUtil;

public class DivideAndConquer {
	public static void main(String[] args) {
		int[] A = {-1,1,1,3,2,-1};
		int low = 0;
		int high = A.length-1;
		MaxSubarray maxSubarray = findMaxSubarray(A, low, high);
	}

	public static MaxSubarray findMaxSubarray(int[] A, int low, int high){
		System.out.println("Starts findMaxSubarray with values A: "+sortingUtil.toString(A)+"; low: "+low+"; high: "+high);
		if(high == low){
				System.out.println("As there's only one element in the array." );
				System.out.println("Create subarray with only one element." );
				return new MaxSubarray(low, high, A[low]);
		}else{ 
			System.out.println("As there are more than one element in the array");
			System.out.println("Calculate the middle of the array");
			int mid = (low+high)/2;
			System.out.println("In that case, the middle of "+low+" and "+high+" is "+mid);
			System.out.println("Then we recursively call the findMaxArray() function to the left side: A: "+sortingUtil.toString(A)+"; low: "+low+"; mid: "+mid);
			MaxSubarray leftSubarray = findMaxSubarray(A, low, mid);
			System.out.println("Then we recursively call the findMaxArray() function to the right side: A: "+sortingUtil.toString(A)+"; mid+1: "+mid+1+"; high: "+high);
			MaxSubarray rightSubarray= findMaxSubarray(A, mid+1, high);
			System.out.println("Then we call findMaxCrossingSubarray(A, low, mid, high) to the following values; A: "+sortingUtil.toString(A)+"; low: "+low+"; mid: "+mid+"; high: "+high);
			MaxSubarray crossSubarray= findMaxCrossingSubarray(A, low, mid, high);
			if ((leftSubarray.sum>=rightSubarray.sum)&&(leftSubarray.sum>=crossSubarray.sum)){
				System.out.println("Since leftSubarray sum ("+leftSubarray.sum
						+") is greater than rightSubarray sum ("+rightSubarray.sum
						+") and greater than crossSubarray sum ("+crossSubarray.sum
						+") return leftSubarray");
				return(leftSubarray);
			}else{
				if ((rightSubarray.sum >= leftSubarray.sum)&&(rightSubarray.sum>=crossSubarray.sum)){
					System.out.println("Since rightSubarray sum ("+rightSubarray.sum
							+") is greater than leftSubarray sum ("+leftSubarray.sum
							+") and greater than crossSubarray sum ("+crossSubarray.sum
							+") return rightSubarray");
					return(rightSubarray); 
					}else{
						System.out.println("Since crossSubarray sum ("+crossSubarray.sum
								+") is greater than leftSubarray sum ("+leftSubarray.sum
								+") and greater than rightSubarray sum ("+rightSubarray.sum
								+") return crossSubarray");
						return(crossSubarray);
				}
			}
		}
	}
	
	public static MaxSubarray findMaxCrossingSubarray(int[] A, int low, int mid, int high){
		System.out.println("We start the findMaxCrossingSubarray function with the values A: "+sortingUtil.toString(A)
							+" low :"+low
							+" mid :"+mid
							+" high :"+high);
		int maxLeft = 0, maxRight = 0;
		int leftSum = -999999;
		System.out.println("The sum counter receives zero");
		int sum = 0;
		System.out.println("For each left interaction from "+mid+" to "+low+" the sum counter is added with A[i]");
		for (int i = mid; i >= low; i--) {
			System.out.println("For "+i+" interaction, "+sum+" is added with "+A[i]+" and compared with "+ leftSum);
			sum = sum+A[i];
			if(sum > leftSum){
				System.out.println("Since "+sum+" is greater than "+leftSum+" it substitutes leftSum and "+i+" is now the new maxLeft index");
				leftSum = sum;
				maxLeft = i;
			}
		}
		int rightSum = -999999;
		System.out.println("The sum counter receives zero");
		sum = 0;
		System.out.println("For each right interaction from "+mid+"+"+1+" to "+high+" the sum counter is added with A[i]");
		for (int i = mid+1; i <= high; i++) {
			System.out.println("For "+i+" interaction, "+sum+" is added with "+A[i]+" and compared with "+ rightSum);
			sum = sum+A[i];
			if(sum>rightSum){
				System.out.println("Since "+sum+" is greater than "+rightSum+" it substitutes rightSum and "+i+" is now the new maxRight index");
				rightSum = sum;
				maxRight = i;
			}
		}
		System.out.println("The new array is returned with maxLeft: "+maxLeft+", maxRight: "+maxRight+", sum: "+rightSum+"+"+leftSum);
		return(new MaxSubarray(maxLeft, maxRight, rightSum+leftSum));
	}
}
