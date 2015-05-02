package com.platform.gui.framework.smart.tags.model;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.inter.IEnableHtml;
import com.platform.gui.framework.smart.tags.util.FreeMarkerUtil;

public class SmartElement implements IEnableHtml{
	
	private Logger logger = Logger.getLogger(SmartElement.class);
	
	protected Integer id;
	
	protected String name;
	
	protected String label;
	
	protected String value;
	
	protected String template;
	
	protected String templatePath;
	
	protected SmartTableContext context;
	
	/* default template */
	protected String dTemplate;
	
	/* default template path */
	protected String dTemplatePath = SmartConstants.TEMPLATE_PATH ;

	protected SmartElement parent;
	
	private String html;
	
	public SmartElement(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDTemplate() {
		return dTemplate;
	}

	public void setDTemplate(String template) {
		dTemplate = template;
	}

	public String getDTemplatePath() {
		return dTemplatePath;
	}

	public void setDTemplatePath(String templatePath) {
		dTemplatePath = templatePath;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getHtml() throws Exception {
		try{
			HashMap<String, Object> root = new HashMap<String, Object>();
			
			//set table configure object
			root.put("context", this.context);
			
			//set table context and row action object
			root.put("self", this);
			
			//get template file
			if(template != null){
				html = FreeMarkerUtil.getTemplateHtml(context.getServletContext() , templatePath , template , root);
			}else{
				//use the default one
				html = FreeMarkerUtil.getTemplateHtml(context.getServletContext() , dTemplatePath , dTemplate , root);
			}
			return html;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public SmartTableContext getContext() {
		return context;
	}

	public void setContext(SmartTableContext context) {
		this.context = context;
	}
	
	public SmartElement getParent() {
		return parent;
	}

	public void setParent(SmartElement parent) {
		this.parent = parent;
	}
}
