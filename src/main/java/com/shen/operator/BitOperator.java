package com.shen.operator;

/**
 * 位运算
 * 
 * 直接对整数类型的位进行操作。包括 long，int，short，char，byte
 * 
 * 位运算:

	位运算符包括:　与（&）、或（|）、非（~）也叫补码、异或（^）

　　		&：当两边操作数的位同时为1时，结果为1，否则为0。如1100&1010=1000 　　
      	| ：当两边操作数的位有一边为1时，结果为1，否则为0。如1100|1010=1110 　　
      	~：0变1,1变0 　　
      	^：两边的位不同时，结果为1，否则为0.如1100^1010=0110


 * 
 * @author shen
 *
 */
public class BitOperator {

	public static void main(String[] args) {
		BitOperator.leftMoving(3);
		BitOperator.rightMoving(1);
	}
	
	/**
	 * 左移运算符 <<
	 * @param w
	 */
	public static void leftMoving(int w){
		//在java中，int的长度32位，范围是 -2的31次方到2的31次方。默认值0。
		//所以5的二进制表示是（进制转换算法？？？？？）：
		//0000 0000 0000 0000 0000 0000 0000 0101         ? 5
		//0000 0000 0000 0000 0000 0000 0010 1000         ? 40  左移3个，变成十进制是40。
		System.out.println("5 << "+w+" = : "+ (5 << w) );
	}
	
	public static void rightMoving(int w){
//		计算过程：
//		0000 0000 0000 0000 0000 0000 0000 0101         ? 5
//		0000 0000 0000 0000 0000 0000 0000 0010         ? 2
		System.out.println("5 >> "+w+" = : "+ (5 >> w) );
	}
	
	
}
