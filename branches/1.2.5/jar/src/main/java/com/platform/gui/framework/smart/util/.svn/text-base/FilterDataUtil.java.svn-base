package com.platform.gui.framework.smart.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.model.FilterData;

public class FilterDataUtil {
	
	/**
	 * Get Filter data from the page context
	 * @param pageContext
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static FilterData getFilterData(PageContext pageContext){
		FilterData filterData = null;
		HttpSession session = pageContext.getSession();
		
		String name = pageContext.getRequest().getParameter(SmartConstants.PARAM_NAME);
		Map<String , FilterData> root = (Map<String, FilterData>) session.getAttribute(SmartConstants.FILTER_DATA);
		
		if(root != null) filterData = root.get(name);
		return filterData;
	}
	
	
	public static void removeFilterData(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		//if can not find the parameters of "page/sortBy/sortOrder"
		//or the "clearSession" is set to true(filter function)
		//then remove the attribute "checkedRecords" from session
		String page = request.getParameter(SmartConstants.PARAMS_PAGE);
		String sortBy = request.getParameter(SmartConstants.PARAMS_SORT_BY);
		String sortOrder = request.getParameter(SmartConstants.PARAMS_SORT_ORDER);
		
		if(page == null && sortBy == null && sortOrder == null){
			//remove filter data
			session.removeAttribute(SmartConstants.FILTER_DATA);
		}
	}
	
	public static void saveFilterData(HttpServletRequest request , FilterData filterData){
		Map<String , FilterData> root = new HashMap<String , FilterData>();
		HttpSession session = request.getSession();
		
		String name = request.getParameter(SmartConstants.PARAM_NAME);
		root.put(name, filterData);
		
		session.setAttribute(SmartConstants.FILTER_DATA , root);
	}
}
