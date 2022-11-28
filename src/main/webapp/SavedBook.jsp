<%@page import="com.example.helloweb.model.Book"%>
<%@page import="com.example.helloweb.controllers.Controller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>libro inserito</title>
</head>
<body>
<%
Book b=(Book)request.getAttribute(Controller.BOOK_SAVED);
%>
	<h1>libro inserito</h1>
	<p>
		id : <%= b.getId()%></p>
	<p>
		title : <%= b.getTitle()%></p>
	<p>
		numero pagine : <%= b.getNumPages() %></p>
	<p>
		costo : <%= b.getCost() %></p>
	<p>
		autore : <%= b.getAuthor() %></p>
</body>
</html>