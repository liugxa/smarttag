/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.platform.gui.framework.smart.tags.model;

import java.util.Locale;
import junit.framework.TestCase;


public class SmartResourceBundleTest extends TestCase {
    
    public SmartResourceBundleTest(String testName) {
        super(testName);
    }

    public void testGetResources(){
        try{
           String resource = "com.platform.gui.framework.smart.tags.model.application";
           SmartResourceBundle bundle = new SmartResourceBundle(resource , Locale.ENGLISH);
            
           assertEquals("gliu", bundle.getText("my.name"));
           assertEquals("Last", bundle.getText("st.list.table.pagination.last"));

        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

}
