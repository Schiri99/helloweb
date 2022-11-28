<%@page import="com.example.helloweb.controllers.Controller"%>
<%@page import="com.example.helloweb.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Elenco libri</title>
</head>
<body>
<%
	Iterable<Book> books = (Iterable<Book>) request.getAttribute(Controller.BOOK_LIST);
	for(Book b : books){
		out.println("<p>"+ b.getTitle()+ "</p>");
	}
%>

</body>
</html>