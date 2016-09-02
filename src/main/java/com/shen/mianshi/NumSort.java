package com.shen.mianshi;

public class NumSort {
	
	private static final int num = 50;
	
	public void trysort(int tmp, int min, int max) {
		System.out.println(tmp + ", "+ min + ", "+ max);
		if(tmp < num){
			System.out.println("小");
			min = tmp;
		}else if(tmp > num){
			System.out.println("大");
			max = tmp;
		}else{
			System.out.println("ok");
			return;
		}
		tmp = (min + max) / 2;
		//尾递归
		trysort(tmp,min,max);
	}
	
	public static void main(String[] args) {
		NumSort s = new NumSort();
		int tmp = Integer.MAX_VALUE - 1;
		s.trysort(tmp ,0,Integer.MAX_VALUE);
	}
	
}
