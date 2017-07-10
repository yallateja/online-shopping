package com.teja.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.teja.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	private static final String DATABASE_URL="jdbc:mysql://localhost:3306/onlineshopping";
	private static final String DATABASE_DRIVER="com.mysql.jdbc.Driver";
	private static final String DATABASE_DIALECT="org.hibernate.dialect.MySQLDialect";
	private static final String DATABASE_USERNAME="root";
	private static final String DATABASE_PASSWORD="admin";
	
	
	@Bean(name = "dataSource")
	public DataSource getDataSource(){
		
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);		
		
		return datasource;
	}
	
	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean  getSessionFactory(){		
		
		//LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder();
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan("com.teja.shoppingbackend.dto");
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
//		sessionFactory.setProperties(getHibernateProperties());
//		sessionFactory.scanPackages("com.teja.shoppingbackend.dto");
		
		return sessionFactory;
		
	}

	private Properties getHibernateProperties() {
		
		Properties prop=new Properties();
		prop.setProperty("hibernate.dialect", DATABASE_DIALECT);
		prop.setProperty("hibernate.show_sql", "true");
		prop.setProperty("hibernate.format_sql", "true");
		//prop.put("hibernate.connection.provider_class", "org.hibernate.c3p0.internal.C3P0ConnectionProvider");
		
		return prop;
	}
	
	
	@SuppressWarnings("deprecation")
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager trasactionManager=new HibernateTransactionManager(sessionFactory);
		//trasactionManager.setSessionFactory(sessionFactory);
		return trasactionManager;
		
	}
	
	

}
