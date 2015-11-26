package com.shen.transaction.step2_ugly;

import static junit.framework.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.shen.transaction.BankFixture;

/**
 * 共享同一个connection(事务的做法)，service和dao之间传conn，是丑陋的做法，API污染
 * @author shen
 *
 */
public class UglyBankServiceTest extends BankFixture {

    @Test
    public void transferSuccess() throws SQLException {
        UglyBankDao failureBankDao = new UglyBankDao();
        UglyInsuranceDao failureInsuranceDao = new UglyInsuranceDao();

        UglyBankService bankService = new UglyBankService(dataSource);
        bankService.setUglyBankDao(failureBankDao);
        bankService.setUglyInsuranceDao(failureInsuranceDao);

        bankService.transfer(1111, 2222,200);

        assertEquals(800, getBankAmount(1111));
        assertEquals(1200, getInsuranceAmount(2222));
    }

    @Test
    public void transferFailure() throws SQLException {
        UglyBankDao failureBankDao = new UglyBankDao();
        UglyInsuranceDao failureInsuranceDao = new UglyInsuranceDao();

        UglyBankService bankService = new UglyBankService(dataSource);
        bankService.setUglyBankDao(failureBankDao);
        bankService.setUglyInsuranceDao(failureInsuranceDao);
        
        //由于查询了一个不存在的账户3333，没有查询到任何结果，却调用了rs.next() 或者，游标到了查询出来的最后一条记录，
		//又调用了rs.next()则，会找不到next条记录。会异常 java.sql.SQLException: 结果集已耗尽。事务回滚，由于这个这个回滚
		//的事务是全局共享，和例1不同，所以事务全局回滚，账户1的钱并不减少。是对的。
        int toNonExistId = 3333;
        bankService.transfer(1111, toNonExistId,200);

        assertEquals(1000,getBankAmount(1111));
        assertEquals(1000, getInsuranceAmount(2222));
    }

}
