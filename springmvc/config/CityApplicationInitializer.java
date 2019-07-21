package com.springmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


/*Spring uses the DispatcherServlet as the FrontController and it must be registered with 
 * the web.xml or you required to create the class which is implementing the
 *  WebApplicationInializer interface with onStartup method which receives the
 *   servlet Context as a parameter
 * 
 */
public class CityApplicationInitializer implements WebApplicationInitializer  {

	public void onStartup(ServletContext container) throws ServletException {
		// TODO Auto-generated method stub
		
//Step1- AnnotationConfigWebApplication object created
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		
//Step2-look for the spring configuration in class which has been annotated with @configure
		ctx.register(CityApplicationConfiguration.class);
		
//Step3-Setting the servlet context
		ctx.setServletContext(container);
        
//Step4-Registering the dispatcher servlet with("/") as URL Pattern and set early load on startup
		ServletRegistration.Dynamic servlet = container.addServlet(
				"dispatcher", new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}
