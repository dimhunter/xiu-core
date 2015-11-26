package com.shen.select;

/**
 * 嵌套 if 语句。
 * 
 * 是指该if语句为另一个if或者else语句的对象。
 * 要记住一点：一个else语句总是对应着它在同一个块中的最近的if语句，而且该if语句没有与其他else语句相关联。
 * 
 * @author shen
 *
 */
public class IfelseTest2 {
	
	/**
	 * if(i==10){
	 * 		if(j<20) a=b;
	 * 		if(k>30) c=d;
	 * 		else a=c;
	 * }
	 * else a=d;
	 * 
	 * 最后一个else a=d 和 if(i=10)是对应的，else a=c 是和if(k>30)对应的。
	 * 
	 */

}
