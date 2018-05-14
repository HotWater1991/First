/**
 * 
 */
package com.zzu.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**  
* <p>Title: SpringConfig.java</p>  

* <p>Description:  关于Spring 的配置类 </p>  

 * <p>Company: zzu</p>  

* @author HotWater  

* @date 2018年5月7日  
*/
@Configuration
@ComponentScan("com.zzu.service")//扫描service
@MapperScan("com.zzu.dao")//扫描dao
@EnableTransactionManagement//声明式注解
public class SpringConfig {
	//配置数据源
	@Bean
	public  DataSource  getDataSource() {
		ComboPooledDataSource  dataSource  = new ComboPooledDataSource();
		try {
			/**
			 * jdbc.driverClass=oracle.jdbc.driver.OracleDriver
				jdbc.url=jdbc:oracle:thin:@192.168.199.168:1521:orcl
				jdbc.username=SSM
				jdbc.password=ssm
			 */
			dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
			dataSource.setJdbcUrl("jdbc:oracle:thin:@192.168.199.168:1521:orcl");
			dataSource.setUser("SSM");
			dataSource.setPassword("ssm");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
			throw  new RuntimeException("初始化数据源异常");
		}
		return dataSource;
	}
	
	//配置事务
	@Bean
	public DataSourceTransactionManager  getDataSourceTransactionManager(DataSource  dataSource) {
		DataSourceTransactionManager  dataSourceTransactionManager  = new DataSourceTransactionManager(dataSource);
		return dataSourceTransactionManager;
	}
	//整合MyBatis
	@Bean
	public  SqlSessionFactoryBean  getSqlSessionFactoryBean(DataSource  dataSource) {
		SqlSessionFactoryBean  bean  = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		return bean;
	}
	
	

}
