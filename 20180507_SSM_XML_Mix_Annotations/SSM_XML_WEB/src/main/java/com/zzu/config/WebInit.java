/**
 * 
 */
package com.zzu.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**  
* <p>Title: WebInit.java</p>  

* <p>Description: 替代web.xml文件中配置的核心配置类</p>  

 * <p>Company: zzu</p>  

* @author HotWater  

* @date 2018年5月7日  
*/
@Configuration
public class WebInit implements  WebApplicationInitializer {

	/* (non-Javadoc)
	 * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.ServletContext)
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
			
		AnnotationConfigWebApplicationContext  annotationConfigWebApplicationContext   = new AnnotationConfigWebApplicationContext();
		annotationConfigWebApplicationContext.register(SpringConfig.class,SpringMVCConfig.class);
			//spring的核心监听器---初始化spring容器
		ContextLoaderListener contextLoaderListener = new ContextLoaderListener(annotationConfigWebApplicationContext);
		servletContext.addListener(contextLoaderListener );
		
		//springMVC的核心前端控制器----初始化SpringMVC容器----此处遗漏了关于拦截器的拦截映射路径(补充2018年5月7日16:27:08)
		servletContext.addServlet("dispacthServlet", new DispatcherServlet(annotationConfigWebApplicationContext)).addMapping("*.do");
		
		//处理编码过滤器---此处可能有问题----遗漏了关于中文乱码过滤解析映射路径(补充2018年5月7日16:27:08)
		CharacterEncodingFilter  characterEncodingFilter  = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		EnumSet<DispatcherType> enumSet  = EnumSet.noneOf(DispatcherType.class);
		enumSet.add(DispatcherType.REQUEST);
		enumSet.add(DispatcherType.FORWARD);
		servletContext.addFilter("characterEncodingFilter",characterEncodingFilter).addMappingForUrlPatterns(enumSet, false, "/*");;
		
		
		
		
		
		
		
		
	}

}
