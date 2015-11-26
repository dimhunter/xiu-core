package com.shen.string;

import java.util.Random;
import java.util.StringTokenizer;

/**
 * String的substring、split, StringTokenizer 截取字符串性能比较 .
 * StringTokenizer在截取字符串中效率最高，不论数据量大小，几乎持平。
 * substring则要次之，数据量增加耗时也要随之增加。
 * split则是表现最差劲的。
 * 究其原因，split的实现方式是采用正则表达式实现，所以其性能会比较低。至于正则表达式为何低，还未去验证。
 * @author xiaori.Liu
 *
 */
public class StringTest1 {
    
    public static void main(String args[]){
        String orginStr = getOriginStr(10);
        
        //////////////String.split()表现//////////////////////////////////////////////
        System.out.println("使用String.split()的切分字符串"); 
        long st1 = System.nanoTime(); 
        String [] result = orginStr.split("\\.");
        System.out.println("String.split()截取字符串用时：" + (System.nanoTime()-st1));
        System.out.println("String.split()截取字符串结果个数：" + result.length);
        System.out.println();
        
        //////////////StringTokenizer表现//////////////////////////////////////////////
        System.out.println("使用StringTokenizer的切分字符串"); 
        long st3 = System.nanoTime();  
        StringTokenizer token=new StringTokenizer(orginStr,".");  
        System.out.println("StringTokenizer截取字符串用时:"+(System.nanoTime()-st3)); 
        System.out.println("StringTokenizer截取字符串结果个数：" + token.countTokens());
        System.out.println();
        
        ////////////////////String.substring()表现//////////////////////////////////////////
        
        
        long st5 = System.nanoTime();  
        int len = orginStr.lastIndexOf(".");
        System.out.println("使用String.substring()切分字符串");  
        int k=0,count=0;  
        
        for (int i = 0; i <= len; i++) {  
         if(orginStr.substring(i, i+1).equals(".")){  
          if(count==0){  
           orginStr.substring(0, i);  
          }else{  
             orginStr.substring(k+1, i); 
             if(i == len){
               orginStr.substring(len+1, orginStr.length()); 
           }
          }
          k=i;count++;  
         }  
        }
        System.out.println("String.substring()截取字符串用时"+(System.nanoTime()-st5));  
        System.out.println("String.substring()截取字符串结果个数：" + (count + 1));
    }
    
    /**
     * 构造目标字符串
     * eg：10.123.12.154.154
     * @param len 目标字符串组数(每组由3个随机数组成)
     * @return
     */
    private static String getOriginStr(int len){
        
        StringBuffer sb = new StringBuffer();
        StringBuffer result = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < len; i++){
            sb.append(random.nextInt(9)).append(random.nextInt(9)).append(random.nextInt(9));
            result.append(sb.toString());
            sb.delete(0, sb.length());
            if(i != len-1)
                result.append(".");
        }
        
        return result.toString();
    }
}
