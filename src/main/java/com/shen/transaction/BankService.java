package com.shen.transaction;

/**
 * 转账接口
 * @author shen
 *
 */
public interface BankService {
	
	/**
	 * 该用户的银行账户向保险账户转帐
	 * @param fromId
	 * @param toId
	 * @param amount
	 */
    public void transfer(int fromId, int toId, int amount);
}
