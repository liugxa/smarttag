package com.platform.gui.framework.smart.tags;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts2.views.jsp.TagUtils;

import com.opensymphony.xwork2.util.ValueStack;
import com.platform.gui.framework.smart.tags.exception.SmartTagException;
import com.platform.gui.framework.smart.tags.model.SmartOption;
import com.platform.gui.framework.smart.tags.model.SmartSelect;
import com.platform.gui.framework.smart.tags.util.SmartTagUtil;

public class SmartSelectTag extends  TagSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String name;
	
	private String value;
	
	private String list;
	
	private String listKey;
	
	private String listValue;
	
	private Boolean readonly;
	
	private String onclick;
	
	private String onchange;
	
	private String onblur;
	
	private String onkeydown;
	
	public int doStart() throws JspException {
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag() throws JspException {
		try {
			ValueStack stack = TagUtils.getStack(pageContext);
			SmartSelect select = new SmartSelect();

			select.setId(SmartTagUtil.findString(stack, id));
			select.setName(SmartTagUtil.findString(stack, name));
			
			select.setValue(SmartTagUtil.findString(stack, value));
			select.setOptions(this.getSmartOptions(stack , list , listKey , listValue));
			
			select.setOnblur(onblur);
			select.setOnclick(onclick);
			
			select.setOnkeydown(onkeydown);
			select.setOnchange(onchange);
			
			select.setReadonly(readonly);
			
			// print the table header
			JspWriter writer = pageContext.getOut();
			writer.print(select.getHtml());
			
		} catch (Exception e) {
			throw new SmartTagException(e);
		}
		return EVAL_PAGE;
	}	
	
	private List<SmartOption> getSmartOptions(ValueStack stack , String list , String listKey , String listValue) throws Exception{
		Map<String,String> valueMap = SmartTagUtil.findListValue(stack, list, listKey , listValue);
		List<SmartOption> options = new LinkedList<SmartOption>();
		
		for(String k:valueMap.keySet()){
			String v = valueMap.get(k);
			SmartOption option = new SmartOption(k,v);
			options.add(option);
		}
		
		return options;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getListKey() {
		return listKey;
	}

	public void setListKey(String listKey) {
		this.listKey = listKey;
	}

	public String getListValue() {
		return listValue;
	}

	public void setListValue(String listValue) {
		this.listValue = listValue;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getOnblur() {
		return onblur;
	}

	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}

	public String getOnkeydown() {
		return onkeydown;
	}

	public void setOnkeydown(String onkeydown) {
		this.onkeydown = onkeydown;
	}

	public Boolean getReadonly() {
		return readonly;
	}

	public void setReadonly(Boolean readonly) {
		this.readonly = readonly;
	}
}
