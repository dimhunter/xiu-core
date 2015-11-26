package com.shen.transaction.step5_transaction_proxy;

import javax.sql.DataSource;

import com.shen.transaction.BankService;
import com.shen.transaction.step3_connection_holder.ConnectionHolderBankDao;
import com.shen.transaction.step3_connection_holder.ConnectionHolderInsuranceDao;

/**
 * 没有任何事务处理的影子，我们只需关注核心业务逻辑即可，事务放代理中做了。
 * 
 * @author shen
 *
 */
public class BareBankService implements BankService {
	private ConnectionHolderBankDao connectionHolderBankDao;
	private ConnectionHolderInsuranceDao connectionHolderInsuranceDao;

	public BareBankService(DataSource dataSource) {
		connectionHolderBankDao = new ConnectionHolderBankDao(dataSource);
		connectionHolderInsuranceDao = new ConnectionHolderInsuranceDao(
				dataSource);
	}
	
	/**
	 * 真实类中只做逻辑，不处理事务，事务属于额外逻辑，在代理类中做。
	 */
	public void transfer(final int fromId, final int toId, final int amount) {
		try {
			connectionHolderBankDao.withdraw(fromId, amount);
			connectionHolderInsuranceDao.deposit(toId, amount);
		} catch (Exception e) {
			System.out.println("真实类异常="+e);
        	e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
