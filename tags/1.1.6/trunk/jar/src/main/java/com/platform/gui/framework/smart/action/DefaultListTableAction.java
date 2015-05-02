package com.platform.gui.framework.smart.action;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import net.sf.json.JSONSerializer;

public class DefaultListTableAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	
	private String records;
	
	/**
	 * Get the checked record list
	 * @return
	 * @throws Exception
	 */
	public String doGetCheckedRecords() throws Exception{
		PrintWriter writer = this.getServletResponse().getWriter();
	
		Set<String> checkedSet = this.getCheckedRecords();
		writer.write(JSONSerializer.toJSON(checkedSet).toString());
		return NONE;
	}
	
	/**
	 * unRecord the checked
	 * @return
	 * @throws Exception
	 */
	public String doUnCheckRecords() throws Exception{
		Set<String> checkedSet = this.getCheckedRecords();
		String[] rs = this.getAllRecords();
		for(int i=0;i<rs.length;i++){
			checkedSet.remove(rs[i]);
		}
		this.getSession().setAttribute("checkedRecords", checkedSet);
		return NONE;
	}

	/**
	 * Record all of the checked.
	 * @return
	 * @throws Exception
	 */
	public String doCheckRecords() throws Exception{
		Set<String> checkedSet = this.getCheckedRecords();
		String[] rs = this.getAllRecords();
		for(int i=0;i<rs.length;i++){
			checkedSet.add(rs[i]);
		}
		this.getSession().setAttribute("checkedRecords", checkedSet);
		return NONE;
	}
	
	/**
	 * Get checked records from session. 
	 * if can not find it, return a empty set.
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private Set<String> getCheckedRecords() throws Exception{
		HashSet<String> checkedSet = new HashSet<String>();
		Object cr = this.getSession().getAttribute("checkedRecords");
		if(cr != null) checkedSet = (HashSet<String>)cr;
		return checkedSet;
	}
	
	private String[] getAllRecords(){
		String[] result = new String[0];
		if(records != null){
			result = records.split(",");
		}
		return result;
	}
	
	public String getRecords() {
		return records;
	}

	public void setRecords(String records) {
		this.records = records;
	}
}
