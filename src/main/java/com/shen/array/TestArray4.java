package com.shen.array;

public class TestArray4{
     static int[] a={1,2,3,4,5,6};
     static int index=a.length; 
     
     public static void main(String[] args){      
     	   System.out.println(a.length);
     	   insert(3,33);  
     	   insert(2,22);  
     	   delete(3);
     	   System.out.println(a.length);      
     	   System.out.println(index);   
     	   for(int i=0;i<a.length;i++){        
     	   	   System.out.println(a[i]);
     	  }
    } 
    public static void insert(int pos,int value){    
    	 if(index>=a.length){  
    	 	      int[] b=new int[a.length*2];  
    	  		for(int i=0;i<a.length;i++){      
    	  	  		 b[i]=a[i];
    	  		}    
    	  		a=b;  
    	}      
    	  for(int i=index;i>pos;i--){ 
    	  	   a[i]=a[i-1];
    	  }
    	  a[pos]=value;   
    	  index++;
    }
    public static void delete(int pos){    
    	   index--;
    	   for(int i=pos;i<index;i++){
    	   	    a[i]=a[i+1];
    	  }  
    	  a[index]=0;
    }
}       

/* 1  insert      2  delete      3 exit
 please input  your option:  1  
 please input pos: 3
 please input value: 33
  insert ok;
   
   1  insert      2  delete      3 exit
 please input  your option:

 switch( num){     
 	 case 1: insert(pos,value); break;
 	 case 2: delete(pos); break;
 	 case 3: System.exit(0);
}
*/ 