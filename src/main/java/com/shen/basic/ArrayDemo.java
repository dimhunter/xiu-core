package com.shen.basic;
/**
 * 1维2维数组初始化
 * 
 * @author shen
 *
 */
public class ArrayDemo{
	public static void main(String[] args){
		int[]  array1;          // 数组声明
	 	array1=new int[5];     // 申请空间
	    array1[0]=98;
	    array1[1]=89;
	    array1[4]=90;
	    System.out.println(array1.length);
	    
	    int[] array2={1,2,3,4,5,6,7,8,3,3,3,3,3,3,3,3};      // 显式初始化
		
		// 2维数组的初始化方式！！！！
		  int[][] a=new int[3][4];   
		  a[0][0]=12;
		  a[0][1]=23;
		  a[1][0]=34;
		  a[2][3]=45;    
		  for(int i=0;i<a.length;i++){ 
		  	  for(int k=0;k<a[i].length;k++){   
		  	  	        System.out.print(a[i][k]+"\t");
		  	  }      
		  	  System.out.println();
		  }
		  //a[3][3]=46;  ---- row error
		  //a[2][4]=45;  -----column error        
		  
		  int[][] b={{1,2,2},{2,2,2},{3,3,3}};   
		  int[][] c=new int[][]{{1,2,2},{2,2,2},{3,3,3}}; 
		  
		 /* int[][] d=new int[9][9];        
		  for(int i=0;i<d.length;i++){ 
		  	  for(int k=0;k<d[i].length;k++){   
		  	  	        System.out.print(d[i][k]+" ");
		  	  }      
		  	  System.out.println();
		  }    */
		  int[][] e=new int[9][];   
		  System.out.println(e);   
		  System.out.println(e.length);    
		  //System.out.println(e[3].length);
		  System.out.println(e[3]);
	}
}