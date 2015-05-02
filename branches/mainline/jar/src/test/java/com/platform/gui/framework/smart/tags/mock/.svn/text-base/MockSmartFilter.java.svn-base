package com.platform.gui.framework.smart.tags.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.model.SmartButton;
import com.platform.gui.framework.smart.tags.model.SmartElement;
import com.platform.gui.framework.smart.tags.model.SmartFilter;
import com.platform.gui.framework.smart.tags.model.SmartFilterResult;
import com.platform.gui.framework.smart.tags.model.SmartInput;
import com.platform.gui.framework.smart.tags.model.SmartOption;
import com.platform.gui.framework.smart.tags.model.SmartSection;
import com.platform.gui.framework.smart.tags.model.SmartSelect;

public class MockSmartFilter extends SmartFilter {

	public MockSmartFilter(SmartTableContext context){
		this.setContext(context);
		this.setName("filter");
		this.setLabel("Smart Filter");
		this.setSections(this.getSmartSections(context));
		this.setResult(this.getSmartResult(context));
		
	}
	
	private List<SmartSection> getSmartSections(SmartTableContext context){
		List<SmartSection> sections = new ArrayList<SmartSection>();
		
		//option group 0
		SmartSection section0 = new SmartSection();
		section0.setContext(context);
		section0.setId(0);
		section0.setName("find");
		section0.setLabel("Section Find");
		section0.setIsDefault(true);
		
		List<SmartElement> elements0 = new ArrayList<SmartElement>();
		
		//add input
		SmartInput input = new SmartInput();
		input.setContext(context);
		input.setId(0);
		input.setName("name");
		input.setLabel("Request Name");
		input.setValue("Any");
		input.setParent(section0);
		
		elements0.add(input);
		section0.setElements(elements0);
		
		SmartButton button = new SmartButton();
		button.setContext(context);
		button.setId(0);
		button.setName("find");
		button.setLabel("Find");
		button.setParent(section0);
		
		section0.setButton(button);
		sections.add(section0);
		
		//option group 1;
		SmartSection section1 = new SmartSection();
		section1.setContext(context);
		section1.setId(1);
		section1.setName("filter");
		section1.setLabel("Section Filter");
		section1.setIsDefault(false);
		
		List<SmartElement> elements1 = new ArrayList<SmartElement>();
		
		SmartSelect select0 = new SmartSelect();
		select0.setContext(context);
		select0.setId(0);
		select0.setName("status");
		select0.setLabel("Request State");
		select0.setValue("Any");
		
		select0.setParent(section1);
		select0.setOptions(this.getSmartOptions(context , select0));
		
		SmartSelect select1 = new SmartSelect();
		select1.setContext(context);
		select1.setId(1);
		select1.setName("date");
		select1.setLabel("Request Date");
		select1.setValue("Any");
		
		select1.setParent(section1);
		select1.setOptions(this.getSmartOptions(context , select1));

		SmartSelect select2 = new SmartSelect();
		select2.setContext(context);
		select2.setId(2);
		select2.setName("machines");
		select2.setLabel("# of Machines");
		select2.setValue("Any");
		
		select2.setParent(section1);
		select2.setOptions(this.getSmartOptions(context , select2));
		
		elements1.add(select0);
		elements1.add(select1);
		elements1.add(select2);
		section1.setElements(elements1);
		
		SmartButton button1 = new SmartButton();
		button1.setContext(context);
		button1.setName("filter");
		button1.setLabel("Filter");
		button1.setParent(section1);
		section1.setButton(button1);
		sections.add(section1);
		
		return sections;
	}

	private List<SmartOption> getSmartOptions(SmartTableContext context , SmartElement parent){
		List<SmartOption> options = new ArrayList<SmartOption>();
		SmartOption option0 = new SmartOption();
		option0.setContext(context);
		option0.setName("any");
		option0.setLabel("Any");
		option0.setSelected(true);
		option0.setParent(parent);

		SmartOption option1 = new SmartOption();
		option1.setContext(context);
		option1.setName("----");
		option1.setLabel("----");
		option1.setSelected(false);
		option1.setParent(parent);

		SmartOption option2 = new SmartOption();
		option2.setContext(context);
		option2.setName("start");
		option2.setLabel("Start");
		option2.setSelected(false);
		option2.setParent(parent);

		SmartOption option3 = new SmartOption();
		option3.setContext(context);
		option3.setName("stop");
		option3.setLabel("Stop");
		option3.setSelected(false);
		option3.setParent(parent);

		options.add(option0);
		options.add(option1);
		options.add(option2);
		options.add(option3);

		return options;
	}
	private SmartFilterResult getSmartResult(SmartTableContext context){
		//set filter result
		SmartFilterResult result = new SmartFilterResult();
		Map<String , String> elements = new HashMap<String , String>();
		elements.put("Request State" , "State0");
		elements.put("Request Date" , "2/18/2009");
		elements.put("# of Machines" , "199");
		result.setElements(elements);
		return result;
	}
}
