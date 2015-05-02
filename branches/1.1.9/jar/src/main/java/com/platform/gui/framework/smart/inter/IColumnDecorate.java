package com.platform.gui.framework.smart.inter;

import com.platform.gui.framework.smart.model.DataColumn;

public interface IColumnDecorate {
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
	public String decorate(Integer index , Object bean , DataColumn column) throws Exception;
}
