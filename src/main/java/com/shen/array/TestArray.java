package com.shen.array;

public class TestArray{   
	 public static void main(String[] args){   
	 	int[]  array1;          // shu zu sheng ming
	 	array1=new int[5];     // shen qing kong jian
	    array1[0]=98;
	    array1[1]=89;
	    array1[2]=67;   
	    array1[3]=89;
	    array1[4]=90;
	    System.out.println(array1.length);	     
	    double sum=0.0;
	    for(int i=0;i<array1.length;i++){   
	    	sum+=array1[i];  
	    }         
	    System.out.println(sum/array1.length);
	           
	           
	    int[] array2={1,2,3,4,5,6,7,8,3,3,3,3,3,3,3,3};      // xian shi chu shi hua   
	    /*for(int i=0;i< array2.length;i++){}  
	    
	    int[] array3=new int[]{1,2,3,43,5,6,7,78};        
	         */
	}
}