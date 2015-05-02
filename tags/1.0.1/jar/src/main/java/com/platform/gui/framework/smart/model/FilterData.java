package com.platform.gui.framework.smart.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterData {

	private List<FilterCondition> conditions;
	
	/**
	 * Get all of the filter names
	 * @return
	 * @throws Exception
	 */
	public List<String> getFilterNames() throws Exception{
		List<String> names = new ArrayList<String>();
		for(FilterCondition condition:conditions){
			if(condition != null) names.add(condition.getName());
		}
		return names;
	}
	
	/**
	 * Get all of the filter values
	 * @return
	 * @throws Exception
	 */
	public List<String> getFilterValues() throws Exception{
		List<String> values = new ArrayList<String>();
		for(FilterCondition condition:conditions){
			values.add(condition.getValue());
		}
		return values;
	}
	
	/**
	 * Get the filter result map
	 * @return
	 * @throws Exception
	 */
	public Map<String , String> getFilterResult() throws Exception{
		Map<String , String> result = new HashMap<String , String>();
		for(FilterCondition condition:conditions){
			result.put(condition.getLabel(), condition.getValue());
		}
		return result;
	}
	
	/**
	 * Get the filter's value by its name
	 * @param the name of the filter
	 * @return
	 * @throws Excetpion
	 */
	public String getFilterValue(String name) throws Exception{
		String value = null;
		for(FilterCondition condition:conditions){
			if(condition.getName().equals(name)){
				value = condition.getValue();
				break;
			}
		}
		return value;
	}
	
	/**
	 * the relation: < > <= >=
	 * @param the filter name
	 * @return
	 * @throws Exception
	 */
	public String getFilterRelation(String name) throws Exception{
		String relation = "=";
		for(FilterCondition condition:conditions){
			if(condition.getName().equals(name)){
				relation = condition.getRelation();
				break;
			}
		}
		return relation;
	}

	public List<FilterCondition> getConditions() {
		return conditions;
	}

	public void setConditions(List<FilterCondition> conditions) {
		this.conditions = conditions;
	}
}
