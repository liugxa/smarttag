package com.platform.gui.demo.request.service;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.platform.gui.demo.request.model.Request;

public class MockRequestService {

	public List<Request> getRequests() throws Exception{
		try{
		List<Request> requests = new ArrayList<Request>();
		//SimpleDateFormat format = new SimpleDateFormat();
		
		SAXReader reader = new SAXReader();
		Document doc = reader.read(this.getClass().getResource("/com/platform/gui/demo/request/service/mock.xml"));
		Element root = doc.getRootElement();
		Iterator iter = root.elementIterator();
		while(iter.hasNext()){
			Element element = (Element)iter.next();
			Request request = new Request();
			
			request.setId(Integer.parseInt(element.elementText("id")));
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			request.setDate(format.parse(element.elementText("date")));
			
			if(!element.elementText("machines").equals("")){
				request.setMachines(Integer.parseInt(element.elementText("machines")));
			}
			
			if(!element.elementText("memory").equals("")){
				request.setMemory(Integer.parseInt(element.elementText("memory")));
			}
			
			request.setName(element.elementText("name"));
			request.setStatus(element.elementText("status"));
			
			String desc = element.elementText("desc");
			for(int i=0;i<100;i++){
			}
			desc = desc + "<a href='http://www.google.com'>www.google.com</a>";
			request.setDesc(desc);
			request.setUser(element.elementText("user"));
			
			requests.add(request);
		}
		
		return requests;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void main(String[] args) throws Exception{
		try{
			//create the mock data
			Document doc = DocumentHelper.createDocument();
			Element root = doc.addElement("requests");
			
			Calendar cal = Calendar.getInstance();
			for(int i=0;i<50;i++){
				Element element = root.addElement("request");
				element.addElement("id").setText(i + "");
				
				cal.set(Calendar.DAY_OF_MONTH, Calendar.DAY_OF_MONTH + i);
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				element.addElement("date").setText(format.format(cal.getTime()));
				
				element.addElement("name").setText("name" + i);
				element.addElement("user").setText("user" + i);
				element.addElement("status").setText("Active");
				element.addElement("machines").setText((10 + i) + "");
				element.addElement("memory").setText((10 + i) + "");
				element.addElement("desc").setText("This is the " + i + "description");
			}
			
	        // lets write to a file
			OutputFormat format = OutputFormat.createPrettyPrint();
	        XMLWriter writer = new XMLWriter(new FileWriter("mock.xml") , format);
	        writer.write(doc);
	        writer.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
