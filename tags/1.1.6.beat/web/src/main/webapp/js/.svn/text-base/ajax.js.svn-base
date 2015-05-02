/**
* JSAjax object.
* @class This class object support the ajax function.
* @constructor
*/
function JSAjax(){

	this.loadData = function(_url , _xml , _async){
		var xmlHttp = XmlHttp.create();
		var date = new Date();
		var newUrl = _url;
		
		if (_url.indexOf("?") == -1) {
			newUrl = newUrl + "?";
		} else {
			newUrl = newUrl + "&";
		}
		
		newUrl = newUrl + "date=" + date.getTime();
		xmlHttp.open("POST" , newUrl , false);
		xmlHttp.setRequestHeader("context-type","text/xml;charset=utf-8");
		xmlHttp.send(_xml);
		
		//if the result is not an xml object, throw exception directly!
		if(xmlHttp.responseText != null && xmlHttp.responseText != ""){
			return xmlHttp.responseText;
		}else{
			return xmlHttp.responseXML;	
		}
	}

	this.postData = function(_url , _xml , _async){
		var xmlHttp = XmlHttp.create();
		var date = new Date();
		var newUrl = _url;
		
		if (_url.indexOf("?") == -1) {
			newUrl = newUrl + "?";
		} else {
			newUrl = newUrl + "&";
		}
		
		newUrl = newUrl + "date=" + date.getTime();
		xmlHttp.open("POST" , newUrl , false);
		xmlHttp.setRequestHeader("context-type","text/xml;charset=utf-8");
		xmlHttp.send(_xml);
		
		// return true or false;
		if(xmlHttp.responseText != null && xmlHttp.responseText != ""
			&& xmlHttp.responseXML != null && xmlHttp.responseXML != ""){
			 return true;
		}else{
			return false;	
		}
	}
	
	this.loadLocalData = function(_xml , _async){
		var xmlDoc = XmlDocument.create();
		xmlDoc.async = _async;
		xmlDoc.load(_xml);
		return xmlDoc;
	}
	

}