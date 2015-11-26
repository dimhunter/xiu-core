package com.shen.transaction.step5_transaction_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.shen.transaction.step3_connection_holder.TransactionManager;

/**
 * 
 * @author shen
 *
 */
public class TransactionEnabledProxyManager {
	private TransactionManager transactionManager;

	public TransactionEnabledProxyManager(TransactionManager transactionManager) {

		this.transactionManager = transactionManager;
	}
	/**
	 * 创建代理
	 * 通过调用该类的proxyFor方法，传入需要被代理的对象（本例中为BareBankService对象），返回一个代理对象。、
	 * 此后，在调用代理对象的transfer方法时，会自动调用TransactionIvocationHandler的invoke方法，在该方法中，
	 * 我们首先开始事务，然后执行逻辑，异常回滚等。
	 * 代理的是service层中所有的public方法，包括不需要和数据库事务打交道的方法。
	 * @param object
	 * @return
	 */
	public Object proxyFor(Object object) {
		return Proxy.newProxyInstance(object.getClass().getClassLoader(),
				object.getClass().getInterfaces(),
				new TransactionInvocationHandler(object, transactionManager));
	}
}

class TransactionInvocationHandler implements InvocationHandler {
	private Object proxy;
	private TransactionManager transactionManager;

	TransactionInvocationHandler(Object object,
			TransactionManager transactionManager) {
		this.proxy = object;
		this.transactionManager = transactionManager;
	}

	public Object invoke(Object o, Method method, Object[] objects)
			throws Throwable {
		transactionManager.start();
		Object result = null;
		try {
			result = method.invoke(proxy, objects);
			transactionManager.commit();
		} catch (Exception e) {
			System.out.println("代理处理事务，异常="+e);
        	e.printStackTrace();
			transactionManager.rollback();
			System.out.println("代理处理事务，回滚");
		} finally {
			transactionManager.close();
		}
		return result;
	}
}
