<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Byte Stream Replacer</title>
</head>
<body>
	<c:forEach items="${changes}" var="change">		
		<li>Zmiany w pliku: ${change.path}  - ${change.counter} ${change.polishNameForChanges}</li>
	</c:forEach>
	<br>
	<c:forEach items="${unreadables}" var="unreadable">
		<li>Nie można odczytać pliku: ${unreadable.path}</li>
	</c:forEach>
	<br>
	<a href="/return">Powrót</a>
</body>
</html>