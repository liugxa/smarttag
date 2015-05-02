package com.platform.gui.framework.tags.mock;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.platform.gui.demo.request.model.Request;
import com.platform.gui.framework.tags.config.SmartTableGridConfigure;
import com.platform.gui.framework.tags.context.SmartTableGridContext;
import com.platform.gui.framework.tags.decorate.ColumnDecorateFactory;
import com.platform.gui.framework.tags.model.SmartCell;
import com.platform.gui.framework.tags.model.SmartRow;

public class MockSmartTableGridContext extends SmartTableGridContext{

	public MockSmartTableGridContext(){
		this.setCells(this.getSmartCells());
		this.setParameters(this.getSmartParameters());
		this.setRows(this.getSmartRows());
		this.setConfigure(this.getSmartConfigure());
	}
	
	public Map<String , String> getSmartParameters(){
		Map<String , String> parameters = new HashMap<String , String>();
		parameters.put("page", "0");
		parameters.put("sortBy", "name");
		parameters.put("sortOrder", "asc");
		parameters.put("dataSize", "20");
		parameters.put("action", "/toList.action?file=aa");
		parameters.put("contextPath", "/request");
		return parameters;
	}
	
	public List<SmartCell> getSmartCells(){
		List<SmartCell> cells = new ArrayList<SmartCell>();
		Field[] fields = Request.class.getDeclaredFields();
		for(Field field:fields){
			SmartCell cell = new SmartCell();
			cell.setName(field.getName());
			cell.setValue(field.getName().toUpperCase());
			cells.add(cell);
			cell.setColumnDecorate(ColumnDecorateFactory.getDecorateFromBean(new Request(), cell.getName()));
		}
		cells.get(0).setUrl("/toRequest.action");
		return cells;
	}
	
	public List<SmartRow> getSmartRows(){
		List<SmartRow> rows = new ArrayList<SmartRow>();
		for(int i=0;i<20;i++){
			Request request = new Request();
			request.setId(i);
			request.setName("name" + i);
			request.setDate(Calendar.getInstance().getTime());
			request.setDesc("desc" + i);
			request.setMachines(10 + i);
			request.setMemory(10 + i);
			request.setStatus("status" + i);
			request.setUser("user" + i);
			
			SmartRow row = new SmartRow();
			row.setObj(request);
			rows.add(row);
		}
		return rows;
	}
	
	public 	SmartTableGridConfigure getSmartConfigure(){
		SmartTableGridConfigure configure = new SmartTableGridConfigure();
		configure.setPageSize(9);
		return configure;
	}
}
