package com.platform.gui.framework.smart.tags.mock;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.platform.gui.framework.smart.inter.impl.CheckboxColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.ColumnDecorateFactory;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.model.SmartPagination;
import com.platform.gui.framework.smart.tags.model.SmartRow;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;

public class MockSmartTableGrid extends SmartTableGrid{
	
	public MockSmartTableGrid(){
		super();
		this.setCells(this.getSmartCells());
		this.setRows(this.getSmartRows());
		
		MockSmartTableGridContext context = new MockSmartTableGridContext();
		this.setContext(context);
		this.setPagination(new SmartPagination(context));
	}

	public List<SmartCell> getSmartCells(){
		List<SmartCell> cells = new ArrayList<SmartCell>();
		Field[] fields = Request.class.getDeclaredFields();
		for(Field field:fields){
			SmartCell cell = new SmartCell();
			cell.setName(field.getName());
			cell.setValue(field.getName().toUpperCase());
			cells.add(cell);
			if(cell.getName() == "id"){
				cell.setColumnDecorate(new CheckboxColumnDecorate());
			}else{
				cell.setColumnDecorate(ColumnDecorateFactory.getDecorateByType(Request.class, cell.getName()));
			}
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
}
