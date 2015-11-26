package com.shen.transaction.step2_ugly;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.shen.transaction.BankService;

/**
 * 共享同一个connection(事务的做法)，service和dao之间传conn，是丑陋的做法，API污染
 * @author shen
 *
 */
public class UglyBankService implements BankService {
    private DataSource dataSource;
    private UglyBankDao uglyBankDao;
    private UglyInsuranceDao uglyInsuranceDao;

    public UglyBankService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void transfer(int fromId, int toId, int amount) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            uglyBankDao.withdraw(fromId, amount, connection);
            uglyInsuranceDao.deposit(toId, amount, connection);

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
            try
            {
                assert connection != null;
                connection.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void setUglyBankDao(UglyBankDao uglyBankDao) {
        this.uglyBankDao = uglyBankDao;
    }

    public void setUglyInsuranceDao(UglyInsuranceDao uglyInsuranceDao) {
        this.uglyInsuranceDao = uglyInsuranceDao;
    }
}
