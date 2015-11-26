package com.shen.transaction.step3_connection_holder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author shen
 * 
 */
public class ConnectionHolderBankDao {
	private DataSource dataSource;

	public ConnectionHolderBankDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void withdraw(int bankId, int amount) throws SQLException {
		Connection connection = SingleThreadConnectionHolder
				.getConnection(dataSource);
		PreparedStatement selectStatement = connection
				.prepareStatement("SELECT BANK_AMOUNT FROM BANK_ACCOUNT WHERE BANK_ID = ?");
		selectStatement.setInt(1, bankId);
		ResultSet resultSet = selectStatement.executeQuery();
		resultSet.next();
		int previousAmount = resultSet.getInt(1);
		resultSet.close();
		selectStatement.close();

		int newAmount = previousAmount - amount;
		PreparedStatement updateStatement = connection
				.prepareStatement("UPDATE BANK_ACCOUNT SET BANK_AMOUNT = ? WHERE BANK_ID = ?");
		updateStatement.setInt(1, newAmount);
		updateStatement.setInt(2, bankId);
		updateStatement.execute();

		updateStatement.close();
	}
}
