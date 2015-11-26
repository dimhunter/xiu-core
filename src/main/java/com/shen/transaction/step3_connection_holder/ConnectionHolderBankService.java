package com.shen.transaction.step3_connection_holder;

import javax.sql.DataSource;

import com.shen.transaction.BankService;

/**
 * 
 * @author shen
 *
 */
public class ConnectionHolderBankService implements BankService {
	private TransactionManager transactionManager;
	private ConnectionHolderBankDao connectionHolderBankDao;
	private ConnectionHolderInsuranceDao connectionHolderInsuranceDao;

	public ConnectionHolderBankService(DataSource dataSource) {
		transactionManager = new TransactionManager(dataSource);
		connectionHolderBankDao = new ConnectionHolderBankDao(dataSource);
		connectionHolderInsuranceDao = new ConnectionHolderInsuranceDao(
				dataSource);

	}

	public void transfer(int fromId, int toId, int amount) {
		try {
			transactionManager.start();
			connectionHolderBankDao.withdraw(fromId, amount);
			connectionHolderInsuranceDao.deposit(toId, amount);
			transactionManager.commit();
		} catch (Exception e) {
			System.out.println("异常="+e);
        	e.printStackTrace();
			transactionManager.rollback();
			System.out.println("事务回滚");
		} finally {
			transactionManager.close();
		}
	}
}
