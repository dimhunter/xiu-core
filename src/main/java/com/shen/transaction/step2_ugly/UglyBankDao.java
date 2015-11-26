package com.shen.transaction.step2_ugly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 共享同一个connection(事务的做法)，service和dao之间传conn，是丑陋的做法，API污染
 * @author shen
 *
 */
public class UglyBankDao {
    public void withdraw(int bankId, int amount, Connection connection) throws SQLException {
        PreparedStatement selectStatement = connection.prepareStatement("SELECT BANK_AMOUNT FROM BANK_ACCOUNT WHERE BANK_ID = ?");
        selectStatement.setInt(1, bankId);
        ResultSet resultSet = selectStatement.executeQuery();
        resultSet.next();
        int previousAmount = resultSet.getInt(1);
        resultSet.close();
        selectStatement.close();


        int newAmount = previousAmount - amount;
        PreparedStatement updateStatement = connection.prepareStatement("UPDATE BANK_ACCOUNT SET BANK_AMOUNT = ? WHERE BANK_ID = ?");
        updateStatement.setInt(1, newAmount);
        updateStatement.setInt(2, bankId);
        updateStatement.execute();

        updateStatement.close();
    }
}
