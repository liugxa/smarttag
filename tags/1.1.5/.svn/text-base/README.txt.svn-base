
version 1.1.4
. Define a new javascript method("doCheckedRecords()") in tableGrid.ftl file
. Refactoring the DefaultListTableAction to support this new feature.
. Add the old jar file into repository.

version 1.1.2
. Refactoring the SmartColumnTag and SmartTableGrid
. The IDataColumn do not extends the IEnableDecorate interface
. Modify the logic to get the column decorate from java bean: IDataColumn > IDataRecordList

version 1.1.1
. IDataRecordList do not extends the IEnableFilter and IEnablePreference interfaces.
. modify the SmartListTable.tag and SmartTableGrid.tag file to get the data smartly.

version 1.1.0
. Support to define the data and column dynamic.
. Define the priority of JSP file, java bean, preference file.

version 1.0.3.1
. display the pagination by data size and the page size
. remove the "dataSize" parameter from context.parameter to context object
. modify the template files.
. define the check box name tableGridMultiple

version 1.0.3
. support to add a check box on the row.
. support a java script function - getCheckedRecords() to get all of the checked recodes.
. define a new property "primaryKey" in the pf:table
. refactoring the IEnableDecorate and IColumnDecorate interface



Environment

1. Check out all of the jar files from the cvs/integration/gui/incubator/cmgui/lib
2. Add it in your “WEB-INF/lib” folder of web application

3. Check out the images/styles file from the cvs/integration/gui/incubator/cmgui/lib/images and  , cvs/integration/gui/incubator/cmgui/lib/js
4. Put this images/styles into the "your web application" folder.

5. include the struts.xml file into your application.

you web application
	|--WEB-INF
	|	|--lib
	|	|	|--smarttag-1.0.1.jar
	|--images
	|   |--xxx.gif
	|--styles
	|   |--listTable.css
	|--js
	|	|--ajax.js
	|	|--xmlextras.js
	|xxxx.jsp
	|....


Development
1. User Guide

1.1 Define Action
	a)	Define action which extends the ListTableAction
	
			e.g. public class RequestAction extends ListTableAction<Request>{}

	b)	Implements the abstract the method which be define in the ListTableAction
			/**
			* Return the data record list object which implements the IDataRecordList interface. 
			* A DefaultDataRecordList object has been defined in the jar file.
			*/
			public IDataRecordList<Request> registRecordDataList() throws Exception{}
		
		You should:
		
		1) Define a POJO which implements the IDataRecordList interface, if u want to add the filter/preference function,
		implement the IEnableFilter/IEnablePreference interface.
		
		2) Return this bean in the "registRecordDataList" method.
			
1.2 Define the JSP file
	a)	Declare the tag in JSP
			add the "<%@ taglib prefix="pf" uri="http://www.platform.com/tags" %>" in the top of the JSP file.
		
	b)	Use the tag to display the list data in JSP
			e.g
			<pf:list action="/request/toList.action">  
			    <pf:table list="requests" cssClass="tableBasic">
			        <pf:column name="id" 	value="ID"/>
			        
			        //format the data
			        <pf:column name="date" 	value="Date" decorate="date" format="MM/dd/yyyy"/>
			        
			        //add a link
			        <pf:column name="name" 	value="Request Name" decorate="link", url="/request/toRequest.action"/>
			        <pf:column name="user" 	value="User"/>
			        <pf:column name="status" value="Status"/>
			        <pf:column name="machines" value="# of Machines"/>
			        
			        //use the default decorate
			        <pf:column name="memory" value="Memory Usage" decorate="percent"/>
			        
			        <pf:column name="desc" value="Description"/>
			        
			        //row action
			        <pf:action>
			        	//add the options
			           <pf:option label=”Action” name=”action”/>
			           <pf:option label=”----” name=”----”/>
			           <pf:option label=”Stop” name=”stop”/>
			        </pf:action>			        
			    </pf:table>
			</pf:list>


2. Developer User
	2.1. Decorate the column value, the smart tag support three solutions to render the column.
	
		Solution1: user the default decorates
			the smart tag has support some of the default decorate. It inludes: percent , number , link and date. 
			you just only use them into your JSP file and do not need to implement any interfaces.
				<pf:list action="/request/toList.action">  
				    <pf:table list="requests" cssClass="tableBasic">
				        <pf:column name="id" 	value="ID"/>
				        
				        //format the data
				        <pf:column name="date" 	value="Date" decorate="date" format="MM/dd/yyyy"/>
				        
				        //add a link
				        <pf:column name="name" 	value="Request Name" decorate="link", url="/request/toRequest.action"/>
				        <pf:column name="user" 	value="User"/>
				        <pf:column name="status" value="Status"/>
				        <pf:column name="machines" value="# of Machines"/>
				        
				        //use the default decorate
				        <pf:column name="memory" value="Memory Usage" decorate="percent"/>
				        
				        <pf:column name="desc" value="Description"/>
				        
				        //row action
				        <pf:action>
				        	//add the options
				           <pf:option label=”Action” name=”action”/>
				           <pf:option label=”----” name=”----”/>
				           <pf:option label=”Stop” name=”stop”/>
				        </pf:action>			        
				    </pf:table>
				</pf:list>		
		
		Solution2: define the decorate into the data record list.
			a) define a decorate which implement the IColumnDecorate.
				public interface IColumnDecorate {
					/**
					 * Decorate the column value.
					 * Some of the default decorate has been implements in the tag jar file. 
					 * NumberColumnDecorate,DateColumnDecorate,PrecentColumnDecorate,URLColumnDecorate.
					 * 
					 * And you can return these default decorates by use 
					 * ColumnDecorateFactory.getDecorateFromBean
					 * 
					 * @param column
					 * @return String
					 * @throws Exception
					 */
					public String decorate(Object column) throws Exception;
				}
	     
			b) implements the IEnableDecorate interface in your data record list
				
				public interface IEnableDecorate {
					/**
					 * Get the column decorate object
					 * @param columnName
					 * @return
					 * @throws Exception
					 */
					public IColumnDecorate getColumnDecorate(String columnName);
				}
	
			c) In the JSP file, you do not need to declare it again.
		
		
		Solution3: define it the IDataColumn object
			a) define a POJO which implement the IDataColumn interface
				public interface IDataColumn extends IEnableDecorate {
					public List<DataColumn> getDataColumn() throws Exception;
				}
				
			b) extends the ListTableAction and overwrite the registerDataColumn() method.
				/**
				 * Return the data column which implement the IDataColumn interface.
				 * 
				 * NOTE
				 * user can choice to define the column information in JSP file,implement the interface 
				 * or define it into the preference file.
				 * 
				 * PRIORITY
				 * Preference > JSP file > interface.
				 */
				public IDataColumn registDataColumn() throws Exception{
					return null;
				}
			c) In the JSP file, directly use the <pf:table/>
		
		
 	2.2  Define the dynamic row action.
 		a) implement the IEnableAction interface in your java bean.
			public interface IEnableAction {
				List<String> getActions() throws Exception;
			}

3 FAQ
	a)	How to define the row action?
		[A] use “pf:action” into the “pf:table” elements
			<pf:list action="/request/toList.action">
			    <pf:table list="requests" cssClass="tableBasic">
			        <pf:column name="id" value="ID"/>
			        <pf:column name="date" value="Date" format="MM/dd/yyyy"/>
			        <pf:column name="name" value="Request Name" url="/request/toRequest.action"/>
			        <pf:column name="user" value="User"/>
			        <pf:column name="status" value="Status"/>
			        <pf:column name="machines" value="# of Machines"/>
			        <pf:column name="memory" value="Memory Usage" decorate="percent"/>
			        <pf:column name="desc" value="Description"/>
			        
			        //row action
			        <pf:action>
			        	//add the options
			           <pf:option label=”Action” name=”action”/>
			           <pf:option label=”----” name=”----”/>
			           <pf:option label=”Stop” name=”stop”/>
			        </pf:action>
			    </pf:table>
			</pf:list>

	b)	How to define the javascript function of the row action? 
 		[A] define a javascript function which named "tableGridRowAction(_select)" in you JSP file to rewriter the default one.

	c)  How to add the filter?
		[A] use the "pf:filter" element to define it.

	    <pf:list action="/request/toList.action"> 
			<pf:filter>
				<pf:section label="Find this host">
	          		<pf:element label="Request Name" name="name" type="input"/>
	          		<pf:button label="Find"/>
	       		</pf:section>
	
	       		<pf:section label="Filter hosts by" isDefault="true">
	          		<pf:element label="Request State" name="state" type="select" value="Any"/>
	          		<pf:element label="Request Date"  name="date" type="select" value="Any"/>
	          		<pf:element label="# of Machines" name="machines" type="input" value="Any"/>
	          		<pf:button label="Filter"/>
	       		</pf:section>
	   		</pf:filter>
	
		    <pf:table list="requests" cssClass="tableBasic">
		        <pf:column name="id" value="ID"/>
		        <pf:column name="date" value="Date" format="MM/dd/yyyy"/>
		        <pf:column name="name" value="Request Name" url="/request/toRequest.action"/>
		        <pf:column name="user" value="User"/>
		        <pf:column name="status" value="Status"/>
		        <pf:column name="machines" value="# of Machines"/>
		        <pf:column name="memory" value="Memory Usage" decorate="percent"/>
		        <pf:column name="desc" value="Description"/>
		        
		        //row action
		        <pf:action>
		        	//add the options
		           <pf:option label=”Action” name=”action”/>
		           <pf:option label=”----” name=”----”/>
		           <pf:option label=”Stop” name=”stop”/>
		        </pf:action>
		    </pf:table>
	</pf:list>

	d) How to disable the filter/preference function?
		a) define a java been which only implements IEnablePagination interface
		b) remove the filter/preference elements from the JSP file.
		

	