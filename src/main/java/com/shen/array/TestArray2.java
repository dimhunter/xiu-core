package com.shen.array;

public class TestArray2{     
    public static void main(String[] args){         
          int[] a={1,2,3,4,5,6};       
          a=expand(a);  // ------>b
        /*  int[] b=new int[a.length*2];
          for(int i=0;i<a.length;i++){  
          	   b[i]=a[i];
          }  
          a=b;
          System.out.println(a.length);            */
    }     
    
    public static int[] expand(int[] a){              
    	  int[] b=new int[a.length*2];
          for(int i=0;i<a.length;i++){  
          	   b[i]=a[i];
          }   
          return b;     
    }  
    public static void expand2(int[] a){      
    	int[] b=new int[a.length*2];
    	 System.arraycopy(a,0,b,0,a.length);
    } 
}    
