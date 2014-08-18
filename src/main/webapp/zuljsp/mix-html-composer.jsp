<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.zkoss.org/jsp/zul" prefix="z" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<z:zkhead/>
</head>
<body>
	<z:page>
		<z:button label="Test Button" width="100px" onClick="showMyMessage()"/>
		
    	<z:zscript>
			public void showMyMessage(){
		          Messagebox.show("Test Buttons work", "Information", Messagebox.OK, Messagebox.INFORMATION);
		    }
			
    	</z:zscript>
		<h2>JS Error when clicking the above button</h2>
	</z:page>
	
	<z:page>
		<z:div apply="support.zuljsp.MessageboxComposer">
		<z:button label="Test Button" width="100px" />
		<h2>JS Error when clicking the above button</h2>
		
		</z:div>
	</z:page>
</body>
</html>