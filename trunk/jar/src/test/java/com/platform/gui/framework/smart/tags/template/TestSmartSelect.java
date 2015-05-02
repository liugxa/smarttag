package com.platform.gui.framework.smart.tags.template;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.platform.gui.framework.smart.tags.model.SmartOption;
import com.platform.gui.framework.smart.tags.model.SmartSelect;

public class TestSmartSelect extends TestCase{
	
	public void testTableGrid(){
		try{
			SmartSelect select = new SmartSelect();
			select.setId("select0");
			//select.setValue("");
			select.setReadonly(false);
			
			List<SmartOption> ops = new ArrayList<SmartOption>();
			
			SmartOption[] options = new SmartOption[5];
			options[0] = new SmartOption("option0" , "option0");
			options[1] = new SmartOption("option1" , "option1");
			options[2] = new SmartOption("option2" , "option2");
			options[3] = new SmartOption("option3" , "option3");
			options[4] = new SmartOption("option4" , "option4");
			
			for(SmartOption option:options){
				ops.add(option);
			}
			select.setOptions(ops);
			
			select.setOnclick("selectOnClick(this);");
			select.setOnblur("selectOnBlur(this);");
			System.out.println(select.getHtml());
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
