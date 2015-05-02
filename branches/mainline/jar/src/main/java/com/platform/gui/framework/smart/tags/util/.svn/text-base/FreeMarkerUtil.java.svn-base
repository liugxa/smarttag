package com.platform.gui.framework.smart.tags.util;

import java.io.StringWriter;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.WebappTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FreeMarkerUtil {
	
	private static Logger logger = Logger.getLogger(FreeMarkerUtil.class);
	
	public static String getTemplateHtml(ServletContext servletContext , String templatePath , String templateName , Map<String , Object> root) throws Exception{
		try{
			StringWriter sw = new StringWriter();
			
			//get template from the class loader
			Template template = getTemplateFromClass(templatePath , templateName);
			
			//if can not find it, search in the web application
			if(template == null) template = getTemplateFromWebApp(servletContext , templatePath , templateName);

			//if still can not find it, throw exception
			if(template == null) throw new Exception("can not find the template which name is:" + templateName + " and path is " + templatePath);
			
			template.process(root, sw);
			return sw.getBuffer().toString();
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public static Template getTemplateFromClass(String templatePath , String templateName) throws Exception{
		Template template = null;
		try{
			Configuration cfg = new Configuration();
			
			// Specify the data source where the template files come from.
			// Here I set a file directory for it:
			cfg.setTemplateLoader(new ClassTemplateLoader(FreeMarkerUtil.class , templatePath));				
			
			// Specify how templates will see the data-model. This is an advanced
			// topic...
			// but just use this:
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			template = cfg.getTemplate(templateName);
		}catch(Exception e){
			if(logger.isInfoEnabled()) logger.info("the exception:" + e.getMessage());
		}
		return template;
	}	

	public static Template getTemplateFromWebApp(ServletContext servletContext , String templatePath , String templateName) throws Exception{
		Template template = null;
		try{
			Configuration cfg = new Configuration();
			
			// Specify the data source where the template files come from.
			// Here I set a file directory for it:
			cfg.setTemplateLoader(new WebappTemplateLoader(servletContext));
			
			// Specify how templates will see the data-model. This is an advanced
			// topic...
			// but just use this:
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			if(templatePath != null){
				template = cfg.getTemplate(templatePath + templateName);
			}else{
				template = cfg.getTemplate(templateName);
			}
		}catch(Exception e){
			if(logger.isInfoEnabled()) logger.info("the exception:" + e.getMessage());
		}
		return template;
	}
}
