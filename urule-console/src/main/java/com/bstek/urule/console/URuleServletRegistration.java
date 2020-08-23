package com.bstek.urule.console;

import com.bstek.urule.console.servlet.URuleServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;

/**
 * @author Jacky.gao
 * @since 2016年10月12日
 */
@Component
public class URuleServletRegistration {
	@Bean
	public ServletRegistrationBean<HttpServlet> registerURuleServlet(){
		return new ServletRegistrationBean<HttpServlet>(new URuleServlet(), "/urule/*");
	}
}
