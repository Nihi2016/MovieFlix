package io.egen.movieflix;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JPAConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	    emf.setDataSource(dataSource());
	    emf.setPackagesToScan("io.egen.movieflix.*");
	    JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	    emf.setJpaVendorAdapter(adapter);
	    emf.setJpaProperties(properties());
		return emf;
	}
	
	@Bean
	public DataSource dataSource(){ 
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/movieflix-db");
		ds.setUsername("root");
		ds.setPassword("Nihitha_18");
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager txnManager(EntityManagerFactory emf){
		JpaTransactionManager txn = new JpaTransactionManager(emf);
		return txn;
		//use in service layer
	}
	
	
	private Properties properties(){
		
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.hbm2ddl.auto", "create");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
		return props;
		
	}
}
