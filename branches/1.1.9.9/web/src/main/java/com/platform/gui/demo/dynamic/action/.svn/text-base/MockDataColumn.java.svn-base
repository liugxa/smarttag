package com.platform.gui.demo.dynamic.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.platform.gui.demo.dynamic.util.DataTableUtils;
import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.DefaultColumnDecorate;
import com.platform.gui.framework.smart.model.DataColumn;

public class MockDataColumn implements IDataColumn , IDataColumnDecorate{

	private String fileName;
	
	private String type;
	
	public MockDataColumn(String fileName , String type){
		this.fileName = fileName;
		this.type = type;
	}
	
	public List<DataColumn> getDataColumns() throws Exception {
		List<DataColumn> dataColumns = new ArrayList<DataColumn>();
		List<Object> beans = DataTableUtils.getTableDataFromFile(fileName);
		for(Object bean:beans){
			String id = BeanUtils.getProperty(bean, "id");
			if(type.equals(id)){
				String[] columns = BeanUtils.getArrayProperty(bean, "names");
				String[] values = BeanUtils.getArrayProperty(bean, "values");
				for(int i=0;i<columns.length;i++){
					DataColumn dataColumn = new DataColumn();
					dataColumn.setName(columns[i]);
					dataColumn.setLabel(values[i]);
					
					if(columns[i].equals("memory")) dataColumn.setAlign("right");
					dataColumns.add(dataColumn);
				}
			}
		}
		return dataColumns;
	}

	public IColumnDecorate getColumnDecorate(String columnName) {
		return new DefaultColumnDecorate();
	}
}
