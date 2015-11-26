package com.shen.transaction.step1_failure;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 银行账户dao
 * 
 * @author shen
 * 
 */
public class FailureBankDao {
	private DataSource dataSource;

	public FailureBankDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * 转出
	 * @param bankId
	 * @param amount
	 * @throws SQLException
	 */
	public void withdraw(int bankId, int amount) throws SQLException {
		//connection事务2
		Connection connection = dataSource.getConnection();
		PreparedStatement selectStatement = connection
				.prepareStatement("SELECT BANK_AMOUNT FROM BANK_ACCOUNT WHERE BANK_ID = ?");
		selectStatement.setInt(1, bankId);
		ResultSet resultSet = selectStatement.executeQuery();
		resultSet.next();
		//刚开始余额
		int previousAmount = resultSet.getInt(1);
		resultSet.close();
		selectStatement.close();
		
		//新余额
		int newAmount = previousAmount - amount;
		PreparedStatement updateStatement = connection
				.prepareStatement("UPDATE BANK_ACCOUNT SET BANK_AMOUNT = ? WHERE BANK_ID = ?");
		updateStatement.setInt(1, newAmount);
		updateStatement.setInt(2, bankId);
		updateStatement.execute();
		//执行完execute，数据库中的余额已经减少，因为这里的connection和FailureBankService里的connection不是一个，所以不是一个事务，这个connection自动提交还是true，所以余额就变了。
		updateStatement.close();
		connection.close();

	}
}
