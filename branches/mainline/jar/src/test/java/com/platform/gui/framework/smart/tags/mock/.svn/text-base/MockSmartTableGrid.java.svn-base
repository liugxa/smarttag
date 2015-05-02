package com.platform.gui.framework.smart.tags.mock;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.platform.gui.framework.smart.inter.impl.CheckboxColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.ColumnDecorateFactory;
import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.model.SmartOption;
import com.platform.gui.framework.smart.tags.model.SmartPagination;
import com.platform.gui.framework.smart.tags.model.SmartRow;
import com.platform.gui.framework.smart.tags.model.SmartRowAction;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;

public class MockSmartTableGrid extends SmartTableGrid{

	public MockSmartTableGrid(SmartTableContext context){
		List<SmartCell> cells = this.getSmartCells(context);

		this.setContext(context);
		this.setCells(cells);
		
		this.setRows(this.getSmartRows());
		this.setPagination(new SmartPagination(context , 6));
	}
	
	public List<SmartCell> getSmartCells(SmartTableContext context){
		List<SmartCell> cells = new ArrayList<SmartCell>();
		Field[] fields = Request.class.getDeclaredFields();
		for(Field field:fields){
			SmartCell cell = new SmartCell();
			cell.setName(field.getName());
			cell.setLabel(field.getName().toUpperCase());
			cell.setContext(context);
			if(cell.getName() == "id"){
				cell.setColumnDecorate(new CheckboxColumnDecorate());
			}else{
				cell.setColumnDecorate(ColumnDecorateFactory.getDecorateByType(Request.class, cell.getName() , ""));
			}
			cells.add(cell);
		}
		cells.get(0).setParameters("/toRequest.action");
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
	
	public SmartRowAction getSmartRowAction(){	
		SmartRowAction rowAction = new SmartRowAction();
		List<SmartOption> options = new ArrayList<SmartOption>();
		for(int i=0;i<4;i++){
			SmartOption option = new SmartOption();
			option.setLabel("Action " + i);
			option.setName("action" + i);
			options.add(option);
		}
		rowAction.setOptions(options);
		return rowAction;
	}
}
