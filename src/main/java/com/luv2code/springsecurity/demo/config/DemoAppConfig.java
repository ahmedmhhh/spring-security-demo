package com.luv2code.springsecurity.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	@Autowired
	private Environment env;
	private Logger logger = Logger.getLogger(getClass().getName());

	//define a bean for Database
	@Bean
	public DataSource securityDataSource(){
		ComboPooledDataSource comboPooledDataSource
				= new ComboPooledDataSource();
		try {
			comboPooledDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}

		logger.info(">>============ url is "+env.getProperty("jdbc.url"));
		logger.info(">>============ user is "+env.getProperty("jdbc.user"));

		comboPooledDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		comboPooledDataSource.setUser(env.getProperty("jdbc.user"));
		comboPooledDataSource.setPassword(env.getProperty("jdbc.password"));

		comboPooledDataSource.setInitialPoolSize(getIntProp("connection.pool.initialPoolSize"));
		comboPooledDataSource.setMinPoolSize(getIntProp("connection.pool.minPoolSize"));
		comboPooledDataSource.setMaxPoolSize(getIntProp("connection.pool.maxPoolSize"));
		comboPooledDataSource.setMaxIdleTime(getIntProp("connection.pool.maxIdleTime"));

		return comboPooledDataSource;
	}

	private int getIntProp(String name){
		String pro = env.getProperty(name);
		int intPro = Integer.parseInt(pro);
		return intPro;
	}

	// define a bean for ViewResolver

	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
}









