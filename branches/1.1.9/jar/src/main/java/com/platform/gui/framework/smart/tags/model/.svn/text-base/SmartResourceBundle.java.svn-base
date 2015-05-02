package com.platform.gui.framework.smart.tags.model;

import java.util.Locale;
import java.util.ResourceBundle;

public class SmartResourceBundle{

    private ResourceBundle bundle;

    private ResourceBundle parent;

    public SmartResourceBundle(String resource , Locale locale){
        try{     
            parent = ResourceBundle.getBundle("smart-global" , Locale.ENGLISH);
        	bundle = ResourceBundle.getBundle(resource , locale);
        }catch(Exception e){
            //if can not find the resource bundle. forgot it.
        }
    }

    public String getText(String key){
        //get the property value from the bundle
        String value = this.getString(bundle, key);
        if(value == null){
            value = this.getString(parent, key);
        }

        if(value == null) value = key;
        return value;
    }

    private String getString(ResourceBundle bundle , String key){
        String value = null;
        if(bundle != null){
            try{
                value = bundle.getString(key);
            }catch(Exception e){
                //forgot it
            }
        }
        return value;
    }
}
