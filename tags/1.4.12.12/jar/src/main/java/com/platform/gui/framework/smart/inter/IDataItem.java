/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.platform.gui.framework.smart.inter;

import java.util.List;

import com.platform.gui.framework.smart.model.DataItem;


public interface IDataItem{
    /**
     * Return the data column which implement the IDataColumn interface.
     *
     * NOTE
     * user can choice to define the column information in JSP file,implement the interface
     * or define it into the preference file.
     *
     * PRIORITY
     * Preference > JSP file > interface.
     */
    public List<DataItem> getDataItems() throws Exception;
}
