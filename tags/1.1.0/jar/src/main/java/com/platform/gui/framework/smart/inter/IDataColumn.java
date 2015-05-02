package com.platform.gui.framework.smart.inter;

import java.util.List;

import com.platform.gui.framework.smart.model.DataColumn;

public interface IDataColumn extends IEnableDecorate {

	public List<DataColumn> getDataColumn() throws Exception;
}
