package cn.sz.zl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.sz.zl.interceptor.Test;



@SpringBootConfiguration
public class MySpringBootInterceptor implements WebMvcConfigurer {
	@Autowired
	private Test tt;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addInterceptor(tt).addPathPatterns("pc/confirm");
	}
}
