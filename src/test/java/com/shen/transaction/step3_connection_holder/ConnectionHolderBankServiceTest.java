package com.shen.transaction.step3_connection_holder;

import static junit.framework.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.shen.transaction.BankFixture;

public class ConnectionHolderBankServiceTest extends BankFixture
{

    @Test
    public void transferSuccess() throws SQLException
    {
        ConnectionHolderBankService connectionHolderBankService = new ConnectionHolderBankService(dataSource);
        connectionHolderBankService.transfer(1111, 2222, 200);

        assertEquals(800, getBankAmount(1111));
        assertEquals(1200, getInsuranceAmount(2222));

    }

    @Test
    public void transferFailure() throws SQLException
    {
        ConnectionHolderBankService connectionHolderBankService = new ConnectionHolderBankService(dataSource);

        int toNonExistId = 3333;
        connectionHolderBankService.transfer(1111, toNonExistId, 200);

        assertEquals(1000, getBankAmount(1111));
        assertEquals(1000, getInsuranceAmount(2222));

    }
}
