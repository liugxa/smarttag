package com.platform.gui.framework.smart.action;

import java.io.PrintWriter;
import java.util.HashSet;

import net.sf.json.JSONSerializer;

public class DefaultListTableAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Get the checked record list
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String doGetCheckedRecords() throws Exception{
		HashSet<String> checkedSet = new HashSet<String>();
		Object cr = this.getSession().getAttribute("checkedRecords");
		if(cr != null) checkedSet = (HashSet<String>)cr;
		
		PrintWriter writer = this.getServletResponse().getWriter();
		writer.write(JSONSerializer.toJSON(checkedSet).toString());
		
		return NONE;
	}
	
	/**
	 * Record the l
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String doCheckRecord() throws Exception{
		String record = this.getServletRequest().getParameter("record");
		
		HashSet<String> checkedSet = new HashSet<String>();
		Object cr = this.getSession().getAttribute("checkedRecords");
		if(cr != null) checkedSet = (HashSet<String>)cr;
		
		//save the checked list into session or other cache
		checkedSet.add(record);
		this.getSession().setAttribute("checkedRecords", checkedSet);
		return NONE;
	}

	/**
	 * Record the l
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String doUnCheckRecord() throws Exception{
		String record = this.getServletRequest().getParameter("record");
		
		HashSet<String> checkedSet = new HashSet<String>();
		Object cr = this.getSession().getAttribute("checkedRecords");
		if(cr != null) checkedSet = (HashSet<String>)cr;
		
		checkedSet.remove(record);
		this.getSession().setAttribute("checkedRecords", checkedSet);
		return NONE;
	}
}
