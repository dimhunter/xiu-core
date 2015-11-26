package com.shen.transaction.step3_connection_holder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * connectionMap是线程不安全的，所以不可采用。
 * 
 * 虽然我们不会自己手动地在中途移除或者关闭Conncetion对象（当然，在事务处理末尾我们应该关闭Conncetion），我们却无法阻止其他
 * 线程这么做。比如，ConnectionHolder类是可以在多个线程中同时使用的，并且这些线程使用了同一个DataSource，其中一个线程使用
 * 完Connection后便将其关闭，而此时另外一个线程正试图使用这个Connection，问题就出来了。因此，上面的ConnectionHolder不是线程安全的。
 * 
 * @author shen
 *
 */
public class ConnectionHolder {
	private Map<DataSource, Connection> connectionMap = new HashMap<DataSource, Connection>();

	public Connection getConnection(DataSource dataSource) throws SQLException {
		Connection connection = connectionMap.get(dataSource);
		if (connection == null || connection.isClosed()) {
			connection = dataSource.getConnection();
			connectionMap.put(dataSource, connection);
		}

		return connection;
	}

	public void removeConnection(DataSource dataSource) {
		connectionMap.remove(dataSource);
	}
}
