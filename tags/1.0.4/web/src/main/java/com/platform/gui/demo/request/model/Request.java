package com.platform.gui.demo.request.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.inter.IEnableAction;
import com.platform.gui.framework.smart.inter.IEnableDecorate;
import com.platform.gui.framework.smart.inter.impl.ColumnDecorateFactory;

public class Request implements IEnableAction , IEnableDecorate{
	
	private Integer id;
	
	private String name;
	
	private Date date;
	
	private String status;
	
	private Integer machines;

	private Integer memory;
	
	private String desc;
	
	private String user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getMachines() {
		return machines;
	}

	public void setMachines(Integer machines) {
		this.machines = machines;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Integer getMemory() {
		return memory;
	}

	public void setMemory(Integer memory) {
		this.memory = memory;
	}

	public List<String> getActions() throws Exception {
		List<String> actions = new ArrayList<String>();
		actions.add("Action");
		actions.add("----");
		actions.add("Remove");
		actions.add("Clone");
		return actions;
	}
	
	public IColumnDecorate getColumnDecorate(String columnName){
		IColumnDecorate decorate = null;
		if(columnName.equals("memory")){
			decorate = new MemoryColumnDecorate();
		}
		else if(columnName.equals("name")){
			//add link
			decorate = new NameURLColumnDecorate("./toRequest.action");
		}
		else{
			decorate = ColumnDecorateFactory.getDecorateByType(Request.class, columnName);
		}
		return decorate;
	}
}
