/**
 * 
 */
package com.zzu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**  
* <p>Title: SpringMVCConfig.java</p>  

* <p>Description: </p>  

 * <p>Company: zzu</p>  

* @author HotWater  

* @date 2018年5月7日  
*/
@Configuration
@ComponentScan("com.zzu.controller")//扫描包
@EnableWebMvc//支持注解并隐式方式注入映射适配器和映射处理器
public class SpringMVCConfig {

	//配置资源视图解析器
	@Bean
	public  InternalResourceViewResolver  getInternalResourceViewResolver() {
		InternalResourceViewResolver  internalResourceViewResolver  = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/pages/jsp/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	
	
}
