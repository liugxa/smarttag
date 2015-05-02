package com.platform.gui.framework.smart.tags;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.tags.context.SmartTableContext;

public abstract class SmartElementTag extends TagSupport{
	
	private Logger logger = Logger.getLogger(SmartElementTag.class);
	
	private static final long serialVersionUID = 1L;
	
	/* the name property */
	protected String name;
	
	/* the label property */
	protected String label;
	
	/* the value property */
	protected String value;
	
	/* the resource property */
	protected String resource;
	
	/* the template property */
	protected String template;
	
	/* the template path */
	protected String templatePath;
	
	/* the smart context object */
	protected SmartTableContext context;
	
	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		try{
			Object obj = pageContext.getAttribute("st_context");
			if(obj != null) context = (SmartTableContext)obj;
			return EVAL_BODY_INCLUDE;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new JspException(e);
		}
	}
	
	public String getText(String key){
		Locale locale = pageContext.getRequest().getLocale();
		return this.getText(this, locale , key);
	}
	
	private String getText(SmartElementTag tag , Locale locale , String key){
		String value = null;
		ResourceBundle bundle = null;
		try{
			bundle = ResourceBundle.getBundle(tag.getResource() , locale);
		}catch(Exception e){
			logger.error("can not get the key[" + key + "]value from the properies file:" + tag.getResource());
		}
		
		if(bundle != null){
			//get the property value from the bundle
	        value = this.getString(bundle, key);
		}else{
			//get the property from its parent bundle
	        Tag parent = tag.getParent();
	        if(parent != null && parent instanceof SmartElementTag){
	        	SmartElementTag p = (SmartElementTag)parent; 
	            value = p.getText(p , locale , key);
	    	}
		}
	    
	    //find it in the default properties file.
		if(value == null){
			try{
				bundle = ResourceBundle.getBundle("smart-global" , Locale.ENGLISH);
				value = this.getString(bundle, key);
			}catch(Exception e){
				logger.error("can not get the key[" + key + "]value from the default properies file:"  + e.getMessage());
			}
		}
		if(value == null) value = key;
		if(logger.isDebugEnabled()) logger.debug("the lable[" + key + "]'s value is " + value);
		return value;
    }
	
    private String getString(ResourceBundle bundle , String key){
        String value = null;
        if(bundle != null){
            try{
                value = bundle.getString(key);
            }catch(Exception e){
                //forgot it
            	logger.error(e.getMessage());
            }
        }
        return value;
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public SmartTableContext getContext() {
		return context;
	}

	public void setContext(SmartTableContext context) {
		this.context = context;
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

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
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
}
