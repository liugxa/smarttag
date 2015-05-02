package com.platform.gui.demo.request.model;

import java.util.ArrayList;
import java.util.List;

import com.platform.gui.demo.request.service.MockRequestService;
import com.platform.gui.framework.smart.comparator.SortOrder;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.inter.IEnableFilter;
import com.platform.gui.framework.smart.inter.IEnablePreference;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.util.Sorter;

public class RequestDataRecordList implements IDataRecordList<Request> , 
				IEnableFilter<Request> , IEnablePreference{

	private static final long serialVersionUID = 1L;

	private Sorter<Request> sort = new Sorter<Request>();
	
	private MockRequestService service = new MockRequestService();
	
	public RequestDataRecordList() throws Exception{
		super();
	}

	public Integer getFilterRecordSize(FilterData filterData) throws Exception {
		return this.getAllFilterRecords(filterData).size();
	}
	
	/**
	 * Filter data
	 */
	public List<Request> getAllFilterRecords(FilterData filterData) throws Exception{
		List<Request> result = new ArrayList<Request>();
		List<Request> requests = service.getRequests();
		List<String> filterNames = filterData.getFilterNames();
		for(String fn:filterNames){
			//TODO: use the regex to match the value
			String fv = filterData.getFilterValue(fn);
			if(fv != null){
				//find all of the request list which name is same with the condition's value
				for(Request request:requests){
					String name = request.getName();
					if(name.indexOf(fv) != -1) result.add(request);
				}
			}
		}
		return result;
	}
	/**
	 * Filter data
	 */
	public List<Request> getAllFilterRecords(FilterData filterData , String sortBy, SortOrder sortOrder) throws Exception{
		List<Request> result = this.getAllFilterRecords(filterData);
		sort.sort(result, sortBy , sortOrder);
		return result;
	}

	/**
	 * Filter data
	 */
	public List<Request> getFilterRecords(FilterData filterData , Integer startIndex , Integer endIndex , String sortBy, SortOrder sortOrder) throws Exception{
		List<Request> result = this.getAllFilterRecords(filterData);
		result = result.subList(startIndex , endIndex);
		sort.sort(result, sortBy , sortOrder);
		return result;
	}

	public List<Request> getAllRecords() throws Exception {
		List<Request> requests = service.getRequests();
		return requests;
	}
	
	public List<Request> getAllRecords(String sortBy, SortOrder sortOrder) throws Exception {
		List<Request> requests = this.getAllRecords();
		return requests;
	}

	public Integer getAllRecordSize() throws Exception {
		return this.getAllRecords().size();
	}

	public List<Request> getRecords(Integer startIndex, Integer endIndex,String sortBy, SortOrder sortOrder) throws Exception {
		List<Request> requests = this.getAllRecords();
		requests = requests.subList(startIndex, endIndex);
		sort.sort(requests, sortBy , sortOrder);
		return requests;
	}

	public PreferenceConfigure getPreferenceConfigure() throws Exception {
		PreferenceConfigure configure = new PreferenceConfigure();
		configure.setPageSize(10);
		return configure;
	}

	public PreferenceConfigure savePreferenceConfigure() throws Exception {
		return null;
	}
}
