package com.platform.gui.framework.smart.util;
import junit.framework.TestCase;

public class StringEscapeTest extends TestCase{

	public void testEscapeHtml(){
		String value = "aaa \u0009 ccc";
		System.out.println(StringEscape.escapeHtml(value));
	}
	
	public void testEscapeWhitespace(){
		String value = "aaa \u0009 ccc";
		System.out.println(StringEscape.escapeWhitspace(value));
	}
}
