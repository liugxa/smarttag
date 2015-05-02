package com.platform.gui.framework.smart.tags.template;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.beanutils.BeanUtils;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;

import com.platform.gui.framework.smart.inter.impl.CheckboxColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.DefaultColumnDecorate;
import com.platform.gui.framework.smart.model.DataColumn;
import com.platform.gui.framework.smart.tags.mock.MockSmartTableGridContext;
import com.platform.gui.framework.smart.tags.mock.Request;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.model.SmartPagination;
import com.platform.gui.framework.smart.tags.model.SmartRow;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;

public class TestSmartTableGrid extends TestCase{
	
	public void testTableGrid(){
		try{
			SmartTableGrid tableGrid = new SmartTableGrid();
			List<SmartCell> cells = this.getSmartCells();
			tableGrid.setCells(cells);
			tableGrid.setRows(this.getSmartRows());
			
			MockSmartTableGridContext context = new MockSmartTableGridContext();
			context.setDataSize(6);
			tableGrid.setContext(context);
			tableGrid.setPagination(new SmartPagination(context));
			
			//System.out.println(tableGrid.getHtml());
			
			//test table columns
			Parser parser = new Parser(tableGrid.getHtml());
			NodeList as = parser.parse(new TagNameFilter("a"));
			assertEquals(8 , as.size());
			
			assertTrue(as.elementAt(0) instanceof LinkTag);
			LinkTag a0 = (LinkTag)as.elementAt(0);
			assertEquals(cells.get(0).getLabel() , a0.toPlainTextString().trim());
			
			LinkTag a7 = (LinkTag)as.elementAt(7);
			assertEquals(cells.get(7).getLabel() , a7.toPlainTextString().trim());
			
			/*
			SAXReader reader = new SAXReader(false);
			Document document = reader.read(new StringReader(html));
			System.out.println(document);
			*/
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	public List<SmartCell> getSmartCells() throws Exception{
		List<SmartCell> cells = new ArrayList<SmartCell>();
		Field[] fields = Request.class.getDeclaredFields();
		for(Field field:fields){
			SmartCell cell = new SmartCell();
			cell.setName(field.getName());
			cell.setLabel(field.getName().toUpperCase());
			cells.add(cell);
			if(cell.getName() == "id"){
				cell.setColumnDecorate(new CheckboxColumnDecorate());
			}else{
				DataColumn column = new DataColumn();
				BeanUtils.copyProperties(column , cell);
				
				cell.setColumnDecorate(new DefaultColumnDecorate());
			}
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
}
