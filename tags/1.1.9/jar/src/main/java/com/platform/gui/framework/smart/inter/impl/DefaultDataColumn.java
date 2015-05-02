/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.platform.gui.framework.smart.inter.impl;

import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.model.DataColumn;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gliu
 */
public class DefaultDataColumn implements IDataColumn{

    public List<DataColumn> getDataColumns() throws Exception {
        return new ArrayList<DataColumn>();
    }

}
