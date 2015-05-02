package com.platform.gui.framework.smart.tags.util;

import java.io.StringWriter;
import java.util.Map;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FreeMarkerUtil {

	private static String TEMPLATE_PATH = "/com/platform/gui/framework/smart/tags/template";
	
	private static Configuration cfg = new Configuration();
	
	static{
		// Specify the data source where the template files come from.
		// Here I set a file directory for it:
		cfg.setTemplateLoader(new ClassTemplateLoader(FreeMarkerUtil.class , TEMPLATE_PATH));
		
		// Specify how templates will see the data-model. This is an advanced
		// topic...
		// but just use this:
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		
		// the SoftCacheStorage is thread-safe
		cfg.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250));
		//cfg.setCacheStorage(new SoftCacheStorage());
	}
	
	public static String getTemplateHtml(String templateName , Map<String , Object> root) throws Exception{
		StringWriter sw = new StringWriter();
		
		Template template = cfg.getTemplate(templateName);
		template.process(root, sw);
		return sw.getBuffer().toString();
	}
	
	/*
	public static Template getTemplate(String templatePath , String templateName) throws Exception{
		Configuration cfg = new Configuration();
		
		// Specify the data source where the template files come from.
		// Here I set a file directory for it:
		cfg.setTemplateLoader(new ClassTemplateLoader(FreeMarkerUtil.class , templatePath));
		
		// Specify how templates will see the data-model. This is an advanced
		// topic...
		// but just use this:
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		cfg.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250));
		return cfg.getTemplate(templateName);
	}
	*/
}
