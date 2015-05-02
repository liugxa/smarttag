package com.platform.gui.framework.smart.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.commons.beanutils.BeanUtils;

import com.platform.gui.framework.smart.tags.exception.SmartTagException;
import com.platform.gui.framework.smart.tags.model.SmartButton;
import com.platform.gui.framework.smart.tags.model.SmartItem;
import com.platform.gui.framework.smart.tags.model.SmartSection;

public class SmartSectionTag extends SmartElementTag{

	private static final long serialVersionUID = 1L;
		
	/* The filter bar will display this option groups at first time */
	private String isDefault;
	
	/* The SmartItem object */
	private List<SmartItem> items;
	
	/* Display a button */
	private SmartButton button;

	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {		
		items = new ArrayList<SmartItem>();
		button = new SmartButton();
		return EVAL_BODY_INCLUDE;
	}
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			SmartSection section = new SmartSection();
			BeanUtils.copyProperties(section , this);
			
			SmartFilterTag parent = (SmartFilterTag)this.getParent();
			parent.getSections().add(section);
			return EVAL_PAGE;
		}catch(Exception e){
			throw new SmartTagException(e);
		}
	}

	public List<SmartItem> getItems() {
		return items;
	}

	public void setItems(List<SmartItem> items) {
		this.items = items;
	}

	public SmartButton getButton() {
		return button;
	}

	public void setButton(SmartButton button) {
		this.button = button;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
}
