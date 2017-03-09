<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Byte Stream Replacer</title>
<link href="resources/css/mainWindow.css" rel="stylesheet">
</head>
<body>
	<form:form action="startReplaceOperation" modelAttribute="operationProxyObject" method="POST">
		<h4>${path}</h4>
		<form:input type="text" id="path" path="path" required="true" /><br> 
		<h4>${extension}</h4>
		<form:input type="text" id="extension" path="extension" required="true" /><br>
		<h4>${howToInput}</h4>
		<input type="radio" name="inputRadio" id="fromFileRadio">${fromFile}
		<input type="radio" name="inputRadio" id="byHandRadio">${byHand}
		<input type="radio" name="inputRadio" id="numericRadio">${numeric}<br>
		<h4 class="inputFromFile">${streamAName} z pliku</h4> <form:input type="text" id="streamANameFromFile" path="fileA" disabled="true"/>
		<h4 class="inputFromFile">${streamBName} z pliku</h4> <form:input type="text" id="streamBNameFromFile" path="fileB" disabled="true"/>
		<h4 class="inputByHand">${streamAName} ręcznie (String)</h4> <form:input type="text" id="streamANameByHand" path="inputByHandA" disabled="true"/>
		<h4 class="inputByHand">${streamBName} ręcznie (String)</h4> <form:input type="text" id="streamBNameByHand" path="inputByHandB" disabled="true"/>
		<h4 class="inputNumeric">${streamAName} ${numeric}</h4> <form:input type="text" id="streamANameNumeric" path="numericA" disabled="true"/>
		<h4 class="inputNumeric">${streamBName} ${numeric}</h4> <form:input type="text" id="streamBNameNumeric" path="numericB" disabled="true"/>
		<br>		
		<input type="submit" value="Submit" >
	</form:form>
	<script src="resources/js/mainWindow.js"></script>
</body>
</html>