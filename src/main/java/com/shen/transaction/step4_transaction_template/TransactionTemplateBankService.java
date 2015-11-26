package com.shen.transaction.step4_transaction_template;

import javax.sql.DataSource;

import com.shen.transaction.BankService;
import com.shen.transaction.step3_connection_holder.ConnectionHolderBankDao;
import com.shen.transaction.step3_connection_holder.ConnectionHolderInsuranceDao;

/**
 * 
 * @author shen
 *
 */
public class TransactionTemplateBankService implements BankService {
	private DataSource dataSource;
	private ConnectionHolderBankDao connectionHolderBankDao;
	private ConnectionHolderInsuranceDao connectionHolderInsuranceDao;

	public TransactionTemplateBankService(DataSource dataSource) {
		this.dataSource = dataSource;
		connectionHolderBankDao = new ConnectionHolderBankDao(dataSource);
		connectionHolderInsuranceDao = new ConnectionHolderInsuranceDao(
				dataSource);
	}

	public void transfer(final int fromId, final int toId, final int amount) {
		//创建了一个匿名的TtransactionTemplate类，并且实现了doJob方法，在doJob方法中调用两个DAO完成业务操作，然后调用
		//调用TransactionTemplateBankService的doJobInTransaction方法。
		new TransactionTemplate(dataSource) {
			@Override
			protected void doJob() throws Exception {
				connectionHolderBankDao.withdraw(fromId, amount);
				connectionHolderInsuranceDao.deposit(toId, amount);
			}
		}.doJobInTransaction();
	}
}
