package com.platform.gui.demo.request.model;

import com.platform.gui.framework.smart.inter.IDataItemDecorate;
import com.platform.gui.framework.smart.inter.IItemDecorate;
import com.platform.gui.framework.smart.inter.impl.item.CheckboxItemDecorate;
import com.platform.gui.framework.smart.inter.impl.item.InputItemDecorate;

public class RequestItemDecorate implements IDataItemDecorate{

	public IItemDecorate getItemDecorate(String itemName) throws Exception {
		if(itemName.equals("status")){
			return new CheckboxItemDecorate("{'active':'Active','suspend':'Suspend'}");
		}
		return new InputItemDecorate();
	}

}
