package com.platform.gui.framework.smart.inter;

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
	public String decorate(Object bean , String columnName) throws Exception;
}
