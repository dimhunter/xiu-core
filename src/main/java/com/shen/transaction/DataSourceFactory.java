package com.shen.transaction;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/**
 * 单例数据源工厂类。
 * @author shen
 *
 */
public class DataSourceFactory{

    private static final BasicDataSource dataSource = new BasicDataSource();

    static{
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@10.1.7.79:1521:tjkf");
        dataSource.setUsername("monad");
        dataSource.setPassword("monad");
    }

    public static DataSource createDataSource(){
        return dataSource;
    }
    
    public static void main(String[] args){
    	DataSourceFactory.createDataSource();
    }
}