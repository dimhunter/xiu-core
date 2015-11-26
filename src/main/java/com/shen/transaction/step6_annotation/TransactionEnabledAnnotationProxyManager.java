package com.shen.transaction.step6_annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.shen.transaction.step3_connection_holder.TransactionManager;


public class TransactionEnabledAnnotationProxyManager {
	private TransactionManager transactionManager;

	public TransactionEnabledAnnotationProxyManager(
			TransactionManager transactionManager) {

		this.transactionManager = transactionManager;
	}

	public Object proxyFor(Object object) {
		return Proxy.newProxyInstance(object.getClass().getClassLoader(),
				object.getClass().getInterfaces(),
				new AnnotationTransactionInvocationHandler(object,
						transactionManager));
	}
}

class AnnotationTransactionInvocationHandler implements InvocationHandler {
	private Object proxied;
	private TransactionManager transactionManager;

	AnnotationTransactionInvocationHandler(Object object,
			TransactionManager transactionManager) {
		this.proxied = object;
		this.transactionManager = transactionManager;
	}

	public Object invoke(Object proxy, Method method, Object[] objects)
			throws Throwable {
		Method originalMethod = proxied.getClass().getMethod(method.getName(),
				method.getParameterTypes());
		//通过注解判断此方法是否需要代理事务
		if (!originalMethod.isAnnotationPresent(Transactional.class)) {
			return method.invoke(proxied, objects);
		}

		transactionManager.start();
		Object result = null;
		try {
			result = method.invoke(proxied, objects);
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
