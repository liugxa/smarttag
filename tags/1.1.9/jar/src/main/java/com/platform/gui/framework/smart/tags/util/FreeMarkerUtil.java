package com.platform.gui.framework.smart.tags.util;

import java.io.StringWriter;
import java.util.Map;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FreeMarkerUtil {

	public static String getTemplateHtml(String templatePath , String templateName , Map<String , Object> root) throws Exception{
		StringWriter sw = new StringWriter();
		
		Template template = getTemplate(templatePath , templateName);
		template.process(root, sw);
		return sw.getBuffer().toString();
	}
	
	public static Template getTemplate(String templatePath , String templateName) throws Exception{
		Configuration cfg = new Configuration();
		
		// Specify the data source where the template files come from.
		// Here I set a file directory for it:
		String templateDir = "/com/platform/gui/framework/smart/tags/template";
		cfg.setTemplateLoader(new ClassTemplateLoader(FreeMarkerUtil.class , templateDir));

		// Specify how templates will see the data-model. This is an advanced
		// topic...
		// but just use this:
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		return cfg.getTemplate(templateName);
	}	
}
