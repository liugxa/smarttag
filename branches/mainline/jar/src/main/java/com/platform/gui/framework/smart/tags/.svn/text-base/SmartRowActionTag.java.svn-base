package com.platform.gui.framework.smart.tags;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.inter.impl.SelectColumnDecorate;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.model.SmartOption;
import com.platform.gui.framework.smart.tags.model.SmartRowAction;

public class SmartRowActionTag extends SmartElementTag{

	private Logger logger = Logger.getLogger(SmartRowAction.class);
	
	private static final long serialVersionUID = 1L;
	
	private Boolean disable;
	
	private List<SmartOption> options;
	
	private SmartCell cell;
	
	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		options = new ArrayList<SmartOption>();
		cell = new SmartCell();
		return super.doStartTag();
	}
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			SmartTableGridTag parent = (SmartTableGridTag)this.getParent();
			List<SmartCell> cells = parent.getCells();
			
			cell.setId(cells.size());
			cell.setName(name);
			
			cell.setLabel(this.getText(label));
			cell.setValue(value);
			cell.setDisable(disable);
			
			Map<String,String> parameters = new LinkedHashMap<String,String>();
			List<SmartOption> options = this.getOptions();
			for(SmartOption option:options){
				parameters.put(option.getName(), option.getLabel());
			}
			cell.setColumnDecorate(new SelectColumnDecorate(value , parameters));
			
			cell.setContext(context);
			cell.setTemplate(template);
			cell.setTemplatePath(templatePath);
			
			//add it to its parent cell list
			cell.setParent(parent.getTable());
			cells.add(cell);
			return EVAL_PAGE;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new JspException(e);
		}
	}

	public Boolean getDisable() {
		return disable;
	}
	
	public void setDisable(Boolean disable) {
		this.disable = disable;
	}
	
	public List<SmartOption> getOptions() {
		return options;
	}

	public void setOptions(List<SmartOption> options) {
		this.options = options;
	}
	
	public SmartCell getCell() {
		return cell;
	}

	public void setCell(SmartCell cell) {
		this.cell = cell;
	}
}
