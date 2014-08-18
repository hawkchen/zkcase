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
		<h2>JS Error when clicking the button below</h2>
		<z:button label="Test Button error"onClick="showMyMessage()"/>
		<div>
		mix in html
		</div>
    	<z:zscript>
			public void showMyMessage(){
		          Messagebox.show("Test Buttons work", "Information", Messagebox.OK, Messagebox.INFORMATION);
		    }
    	</z:zscript>
	</z:page>
	
	<z:page>
		<h2>No Error clicking the button below</h2>
		<z:button label="Test Button correct"  onClick="showMyMessage()"/>
		
    	<z:zscript>

			public void showMyMessage(){
		          Messagebox.show("Test Buttons work", "Information", Messagebox.OK, Messagebox.INFORMATION);
		    }
			
    	</z:zscript>
	</z:page>
</body>
</html>