package com.platform.gui.framework.smart.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.util.FilterDataUtil;

public class FilterDataInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		//remove the filter data at the first time.
		FilterDataUtil.removeFilterData(request);
		
		//after this, set the filter data into session
		Object obj = invocation.getStack().findValue(SmartConstants.FILTER_DATA);
		if(obj != null) FilterDataUtil.saveFilterData(request, (FilterData)obj);
		
		return invocation.invoke();
	}
}
