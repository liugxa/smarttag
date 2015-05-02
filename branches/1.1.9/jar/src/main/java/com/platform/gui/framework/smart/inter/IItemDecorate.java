package com.platform.gui.framework.smart.inter;

import com.platform.gui.framework.smart.model.DataItem;
import com.platform.gui.framework.smart.model.FilterData;

public interface IItemDecorate{
	/**
	 * Decorate the column value.
	 * Some of the default decorate has been implements in the tag jar file. 
	 * NumberColumnDecorate,DateColumnDecorate,PrecentColumnDecorate,URLColumnDecorate.
	 * 
	 * And you can return these default decorates by use 
	 * ColumnDecorateFactory.getDecorateFromBean
	 * 
	 * @param column name
	 * @return String
	 * @throws Exception
	 */
	public String decorate(Integer index , FilterData filterData , DataItem item) throws Exception;
}
