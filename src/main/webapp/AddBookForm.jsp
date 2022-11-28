<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Book</title>
</head>
<body>
	<form method="POST" action="savebook.do" >
	<label for="title"> titolo</label>
	<input name="title" type="text" id="title">
	
	<label for="numPages">numero pagine</label>
	<input name="numPages" type="number" id="numPages">
	<br>
	<label for="cost">costo</label>
	<input name="cost" type="text" id="cost">
	
	<label for="author">Autore</label>
	<input name="author" type="text" id="author">
	<br>
	<input type="submit" value="aggiungi">
	</form >
</body>
</html>