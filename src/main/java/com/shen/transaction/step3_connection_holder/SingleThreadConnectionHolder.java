package com.shen.transaction.step3_connection_holder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 为了获得线程安全的ConnectionHolder类，我们可以引入Java提供的ThreadLocal类，该类保证一个类的实例变量在各个线程中都有
 * 一份单独的拷贝，从而不会影响其他线程中的实例变量。
 * 
 * @author shen
 *
 */
public class SingleThreadConnectionHolder {
	private static ThreadLocal<ConnectionHolder> localConnectionHolder = new ThreadLocal<ConnectionHolder>();

	public static Connection getConnection(DataSource dataSource)
			throws SQLException {
		return getConnectionHolder().getConnection(dataSource);
	}

	public static void removeConnection(DataSource dataSource) {
		getConnectionHolder().removeConnection(dataSource);
	}

	private static ConnectionHolder getConnectionHolder() {
		ConnectionHolder connectionHolder = localConnectionHolder.get();
		if (connectionHolder == null) {
			connectionHolder = new ConnectionHolder();
			localConnectionHolder.set(connectionHolder);
		}
		return connectionHolder;
	}

}
