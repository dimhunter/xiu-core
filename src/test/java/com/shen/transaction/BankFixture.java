package com.shen.transaction;

import org.junit.Before;

import javax.sql.DataSource;
import java.sql.*;

/**
 * 
 * @author shen
 * 
 */
public class BankFixture {

	protected final DataSource dataSource = DataSourceFactory
			.createDataSource();

	@Before
	public void setUp() throws SQLException {
		Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();

//		statement.execute("DROP TABLE BANK_ACCOUNT");
//		statement.execute("DROP TABLE INSURANCE_ACCOUNT");
//		System.out.println("-----删 表");
//		statement.execute("CREATE TABLE BANK_ACCOUNT (BANK_ID NUMBER,BANK_AMOUNT NUMBER)");
//		statement.execute("CREATE TABLE INSURANCE_ACCOUNT (INSURANCE_ID NUMBER,INSURANCE_AMOUNT NUMBER)");
//		System.out.println("-----建 表");
		statement.execute("TRUNCATE TABLE BANK_ACCOUNT");
		statement.execute("TRUNCATE TABLE INSURANCE_ACCOUNT");
		statement.execute("INSERT INTO BANK_ACCOUNT VALUES (1111, 1000)");
		statement.execute("INSERT INTO INSURANCE_ACCOUNT VALUES (2222, 1000)");
		System.out.println("-----初始化数据");
		
		statement.close();
		connection.close();
	}

	protected int getBankAmount(int bankId) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement selectStatement = connection
				.prepareStatement("SELECT BANK_AMOUNT FROM BANK_ACCOUNT WHERE BANK_ID = ?");
		selectStatement.setInt(1, bankId);
		ResultSet resultSet = selectStatement.executeQuery();
		resultSet.next();
		int amount = resultSet.getInt(1);
		resultSet.close();
		selectStatement.close();
		connection.close();
		return amount;
	}

	protected int getInsuranceAmount(int insuranceId) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement selectStatement = connection
				.prepareStatement("SELECT INSURANCE_AMOUNT FROM INSURANCE_ACCOUNT WHERE INSURANCE_ID = ?");
		selectStatement.setInt(1, insuranceId);
		ResultSet resultSet = selectStatement.executeQuery();
		resultSet.next();
		int amount = resultSet.getInt(1);
		resultSet.close();
		selectStatement.close();
		connection.close();
		return amount;
	}

}
