package com.shen.transaction.step5_transaction_proxy;

import static junit.framework.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.shen.transaction.BankFixture;
import com.shen.transaction.BankService;
import com.shen.transaction.step3_connection_holder.TransactionManager;

/**
 * 测试代码中，我们首先创建一个BareBankService对象，然后调用transactionEnabledProxyManager的proxyFor方法生成对原BareBankService对象
 * 的代理对象，最后在代理对象上调用transfer方法，测试运行成功。
 * 
 * 可以看到，通过以上动态代理实现，BareBankService中的所有public方法都被代理了，即他们都被加入到事务中。这对于service层中的所有方法
 * 都需要和数据库打交道的情况是可以的，本例即如此（有且只有一个transfer方法），然而对于service层中不需要和数据库打交道的public方法，
 * 这样做虽然也不会出错，但是却显得多余。在下一例子中，我们将讲到使用Java注解（com.shen.annotation）的方式来声明一个方法是否需要事务，就
 * 像Spring中的Transactional注解一样。
 * 
 * @author shen
 *
 */
public class BareBankServiceTest extends BankFixture {
	@Test
	public void transferSuccess() throws SQLException {
		TransactionEnabledProxyManager transactionEnabledProxyManager = new TransactionEnabledProxyManager(
				new TransactionManager(dataSource));
		Object bankService = new BareBankService(dataSource);
		BankService proxyBankService = (BankService) transactionEnabledProxyManager
				.proxyFor(bankService);
		proxyBankService.transfer(1111, 2222, 200);

		assertEquals(800, getBankAmount(1111));
		assertEquals(1200, getInsuranceAmount(2222));

	}

	@Test
	public void transferFailure() throws SQLException {
		TransactionEnabledProxyManager transactionEnabledProxyManager = new TransactionEnabledProxyManager(
				new TransactionManager(dataSource));
		Object bankService = new BareBankService(dataSource);
		BankService proxyBankService = (BankService) transactionEnabledProxyManager
				.proxyFor(bankService);

		int toNonExistId = 3333;
		proxyBankService.transfer(1111, toNonExistId, 200);

		assertEquals(1000, getBankAmount(1111));
		assertEquals(1000, getInsuranceAmount(2222));
	}
}
