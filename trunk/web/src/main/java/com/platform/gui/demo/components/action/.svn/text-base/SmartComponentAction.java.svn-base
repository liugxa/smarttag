package com.platform.gui.demo.components.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.platform.gui.demo.components.model.Option;

public class SmartComponentAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	private List<String> list;
	
	private Map<String,String> map;
	
	private List<Option> options;
	
	public String toSelectComponent() throws Exception{
		list = new ArrayList<String>();
		list.add("option1");
		list.add("option2");
		list.add("option3");
	
		
		map = new HashMap<String,String>();
		map.put("1", "option1");
		map.put("2", "option2");
		map.put("3", "option3");
	
		options = new ArrayList<Option>();
		Option[] ops = new Option[3];
		
		ops[0] = new Option("1" , "option1");
		ops[1] = new Option("2" , "option2");
		ops[2] = new Option("3" , "option3");
		for(Option op:ops) options.add(op);
		
		return SUCCESS;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}
}

