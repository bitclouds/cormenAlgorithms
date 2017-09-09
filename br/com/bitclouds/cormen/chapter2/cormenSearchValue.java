package br.com.bitclouds.cormen.chapter2;

public class cormenSearchValue {
	public static void main(String[] args) {
		int[] ints = {};
		int var = 1;
		System.out.println(var+" "+sortingUtil.toString(ints)+" "+search(ints, var));
		ints = new int[] {1};
		System.out.println(var+" "+sortingUtil.toString(ints)+" "+search(ints, var));
		ints = new int[] {2};
		System.out.println(var+" "+sortingUtil.toString(ints)+" "+search(ints, var));
		ints = new int[] {1, 2};
		System.out.println(var+" "+sortingUtil.toString(ints)+" "+search(ints, var));
		ints = new int[] {2, 3};
		System.out.println(var+" "+sortingUtil.toString(ints)+" "+search(ints, var));
		ints = new int[] {2, 3, 1};
		System.out.println(var+" "+sortingUtil.toString(ints)+" "+search(ints, var));
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
