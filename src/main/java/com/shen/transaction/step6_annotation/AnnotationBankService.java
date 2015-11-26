package com.shen.transaction.step6_annotation;

import javax.sql.DataSource;

import com.shen.transaction.BankService;
import com.shen.transaction.step3_connection_holder.ConnectionHolderBankDao;
import com.shen.transaction.step3_connection_holder.ConnectionHolderInsuranceDao;

/**
 * 
 * @author shen
 *
 */
public class AnnotationBankService implements BankService {
	private ConnectionHolderBankDao connectionHolderBankDao;
	private ConnectionHolderInsuranceDao connectionHolderInsuranceDao;

	public AnnotationBankService(DataSource dataSource) {
		connectionHolderBankDao = new ConnectionHolderBankDao(dataSource);
		connectionHolderInsuranceDao = new ConnectionHolderInsuranceDao(
				dataSource);
	}

	@Transactional
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
