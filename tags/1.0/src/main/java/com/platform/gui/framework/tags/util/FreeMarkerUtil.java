package com.platform.gui.framework.tags.util;

import java.io.File;
import java.io.StringWriter;
import java.util.Map;

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
		//System.out.println(FreeMarkerUtil.class.getResource(templatePath));
		File file = new File(FreeMarkerUtil.class.getResource(templatePath).getFile());
		cfg.setDirectoryForTemplateLoading(file);

		// Specify how templates will see the data-model. This is an advanced
		// topic...
		// but just use this:
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		return cfg.getTemplate(templateName);
	}	
}
