package com.platform.gui.framework.smart.util;

import org.apache.commons.lang.StringEscapeUtils;

public class StringEscape {
	/**
	 * Escape the value by use the StringEscapeUtils class
	 * @param value
	 * @return
	 */
	public static String escapeHtml(String s){
		String r = s;
		if(s != null) r = StringEscapeUtils.escapeHtml(s);
		return r;
	}
	
	public static String escapeWhitspace(String s){
		String r = s;
		
		if(s != null){
			/*
			//escape the white space to &nbsp;
			StringBuffer strBuffer = new StringBuffer();
			char[] chars = s.toCharArray();
			for(char c:chars){
				if(Character.isWhitespace(c)){
					strBuffer.append("&nbsp;"); 
				}else{
					strBuffer.append(c);
				}
			}
			
			r = strBuffer.toString();
			*/
			
			r = s.replaceAll("  ", " &nbsp;");
		}
		return r;
	}
}
