package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;

import org.apache.commons.beanutils.BeanUtils;

import com.platform.gui.framework.smart.inter.IDataItem;
import com.platform.gui.framework.smart.inter.IDataItemDecorate;
import com.platform.gui.framework.smart.inter.IItemDecorate;
import com.platform.gui.framework.smart.tags.exception.SmartTagException;
import com.platform.gui.framework.smart.tags.model.SmartItem;
import com.platform.gui.framework.smart.tags.util.SmartItemDecorateUtil;

public class SmartItemTag extends SmartElementTag{

	private static final long serialVersionUID = 1L;
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			SmartSectionTag parent = (SmartSectionTag)this.getParent();
			SmartFilterTag filter = (SmartFilterTag)parent.getParent();
			
			//get SmartListTableTag object
			SmartListTableTag listTable = (SmartListTableTag)filter.getParent();
			IDataItem dataItem = listTable.getDataItem();
			IDataItemDecorate itemDecorate = listTable.getDataItemDecorate();
			
			SmartItem item = new SmartItem();
			BeanUtils.copyProperties(item , this);
			
			//set item decorate
			IItemDecorate decorate = SmartItemDecorateUtil.getDecorateFromJsp(pageContext, itemDecorate, dataItem, item);
			item.setItemDecorate(decorate);
			
			parent.getItems().add(item);
			return EVAL_PAGE;
		}catch(Exception e){
			throw new SmartTagException(e);
		}
	}
}
