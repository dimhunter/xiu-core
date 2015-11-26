package com.shen.transaction.step1_failure;

import static junit.framework.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.shen.transaction.BankFixture;

/**
 * 
 * @author shen
 * 
 */
public class FailureBankServiceTest extends BankFixture {
	
	@Test
	public void transferSuccess() throws SQLException {
		//虽然单例模式保证了dataSource是同一个，但是通过dataSource获得的connection则不是同一个。
		//我们分别从FailureBankService，FailureBankDao和FailureInsuranceDao中调用了三次dataSource.getConnection()，
		//亦即我们创建了三个不同的Connection对象，而Java事务是作用于Connection之上的，所以从在三个地方我们开启了三个不同的
		//事务，而不是同一个事务。
		FailureBankDao failureBankDao = new FailureBankDao(dataSource);
		FailureInsuranceDao failureInsuranceDao = new FailureInsuranceDao(dataSource);

		FailureBankService bankService = new FailureBankService(dataSource);
		bankService.setFailureBankDao(failureBankDao);
		bankService.setFailureInsuranceDao(failureInsuranceDao);

		bankService.transfer(1111, 2222, 200);

		assertEquals(800, getBankAmount(1111));
		assertEquals(1200, getInsuranceAmount(2222));

	}

	@Test
	public void transferFailure() throws SQLException {
		FailureBankDao failureBankDao = new FailureBankDao(dataSource);
		FailureInsuranceDao failureInsuranceDao = new FailureInsuranceDao(dataSource);

		FailureBankService bankService = new FailureBankService(dataSource);
		bankService.setFailureBankDao(failureBankDao);
		bankService.setFailureInsuranceDao(failureInsuranceDao);
		
		//由于查询了一个不存在的账户3333，没有查询到任何结果，却调用了rs.next() 或者，游标到了查询出来的最后一条记录，
		//又调用了rs.next()则，会找不到next条记录。会异常 java.sql.SQLException: 结果集已耗尽。事务回滚，但是这个回滚
		//的事务是在FailureInsuranceDao里，例子1没有共享connection(事务),所以这个回滚不会全局回滚，账户1的钱还是会减少
		//所以是不对的。和例2比较。
		int toNonExistId = 3333;
		bankService.transfer(1111, toNonExistId, 200);

		assertEquals(1000, getInsuranceAmount(2222));
		assertEquals(800, getBankAmount(1111));
	}
}
