package com.shen.transaction.step1_failure;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.shen.transaction.BankService;

/**
 * 银行账户service
 * 
 * @author shen
 * 
 */
public class FailureBankService implements BankService {
	private FailureBankDao failureBankDao;
	private FailureInsuranceDao failureInsuranceDao;
	private DataSource dataSource;

	public FailureBankService(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void transfer(int fromId, int toId, int amount) {
		Connection connection = null;
		try {
			//connection事务1
			connection = dataSource.getConnection();
			//取消自动提交，改为手动
			connection.setAutoCommit(false);
			
			failureBankDao.withdraw(fromId, amount);
			failureInsuranceDao.deposit(toId, amount);
			
			//手动提交事务。
			connection.commit();
		} catch (Exception e) {
			System.out.println("异常="+e);
        	e.printStackTrace();
			try {
				assert connection != null;
				connection.rollback();
				System.out.println("事务回滚");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				assert connection != null;
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void setFailureBankDao(FailureBankDao failureBankDao) {
		this.failureBankDao = failureBankDao;
	}

	public void setFailureInsuranceDao(FailureInsuranceDao failureInsuranceDao) {
		this.failureInsuranceDao = failureInsuranceDao;
	}
}
