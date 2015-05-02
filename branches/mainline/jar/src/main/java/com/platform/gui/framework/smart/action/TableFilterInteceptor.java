package com.platform.gui.framework.smart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.platform.gui.framework.smart.SmartConstants;


public class TableFilterInteceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
    public String intercept(ActionInvocation invocation) throws Exception {
        try{
            HttpServletRequest request = ServletActionContext.getRequest();
        	HttpSession session = request.getSession();
        	
        	//find the filter data in request
            String page = request.getParameter(SmartConstants.PARAMS_PAGE);
            String sortBy = request.getParameter(SmartConstants.PARAMS_SORT_BY);
            String sortOrder = request.getParameter(SmartConstants.PARAMS_SORT_ORDER);
            
            //if can not find the parameters of "page/sortBy/sortOrder"
            //or the "clearSession" is set to true(filter function)
            //then remove the attribute "checkedRecords" from session
            if(page == null && sortBy == null && sortOrder == null){
                //remove filter data   
                session.removeAttribute(SmartConstants.FILTER_DATA);
            }else{
            	//set the filter into session
            	Object obj = ServletActionContext.getValueStack(request).findValue(SmartConstants.FILTER_DATA);
            	if(obj != null){
            		session.setAttribute(SmartConstants.FILTER_DATA , obj);
            	}
            }
            return invocation.invoke();
        }catch(Exception e){
            throw e;
        }
    }
}