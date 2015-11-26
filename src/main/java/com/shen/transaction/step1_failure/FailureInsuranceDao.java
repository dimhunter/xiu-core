package com.shen.transaction.step1_failure;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 保险账户
 * 
 * @author shen
 * 
 */
public class FailureInsuranceDao {
	private DataSource dataSource;

	public FailureInsuranceDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * 转入
	 * @param insuranceId
	 * @param amount
	 * @throws SQLException
	 */
	public void deposit(int insuranceId, int amount) throws SQLException {
		//connection事务3
		Connection connection = dataSource.getConnection();
		PreparedStatement selectStatement = connection
				.prepareStatement("SELECT INSURANCE_AMOUNT FROM INSURANCE_ACCOUNT WHERE INSURANCE_ID = ?");
		selectStatement.setInt(1, insuranceId);
		ResultSet resultSet = selectStatement.executeQuery();
		resultSet.next();
		//刚开始余额
		int previousAmount = resultSet.getInt(1);
		resultSet.close();
		selectStatement.close();
		//新余额
		int newAmount = previousAmount + amount;
		PreparedStatement updateStatement = connection
				.prepareStatement("UPDATE INSURANCE_ACCOUNT SET INSURANCE_AMOUNT = ? WHERE INSURANCE_ID = ?");
		updateStatement.setInt(1, newAmount);
		updateStatement.setInt(2, insuranceId);
		updateStatement.execute();

		updateStatement.close();
		connection.close();
	}
}
