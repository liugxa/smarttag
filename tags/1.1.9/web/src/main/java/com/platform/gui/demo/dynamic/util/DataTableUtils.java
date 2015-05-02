package com.platform.gui.demo.dynamic.util;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class DataTableUtils {

	public static List<Object> getTableDataFromFile(String fileName) throws Exception {
		if(fileName == null) throw new Exception("Please input the file name");
		
		List<Object> beans = new ArrayList<Object>();
		File file = new File(fileName);
		if(file.exists()){
			FileReader reader = new FileReader(file);
			StringBuffer str = new StringBuffer();	
			
			int c = reader.read();
			while(c != -1){
				if(c == 125){
					str.append(Character.toChars((char)c));
					Object bean = JSONSerializer.toJava(JSONObject.fromObject(str.toString()));
					beans.add(bean);
					str = new StringBuffer();
				}else{
					str.append(Character.toChars((char)c));
				}
				c = reader.read();
			}
		}else{
			throw new Exception("Can not file the file which name is " + fileName);
		}
		return beans;
	}
}
