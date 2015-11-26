package com.shen.transaction.step4_transaction_template;

import javax.sql.DataSource;

import com.shen.transaction.step3_connection_holder.TransactionManager;

/**
 * 
 * @author shen
 *
 */
public abstract class TransactionTemplate {
	private TransactionManager transactionManager;

	protected TransactionTemplate(DataSource dataSource) {
		transactionManager = new TransactionManager(dataSource);
	}
	
	/**
	 * 在事务中工作
	 */
	public void doJobInTransaction() {
		try {
			transactionManager.start();
			doJob();
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
	
	/**
	 * 抽象方法，具体逻辑由子类实现。
	 * @throws Exception
	 */
	protected abstract void doJob() throws Exception;
}
