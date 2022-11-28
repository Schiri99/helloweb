<%@ page import="java.time.LocalDate,java.time.Period,java.util.Arrays" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>analizza programmatore</title>
</head>
<body>
<h1>valutazione programmatore</h1>
<%= LocalDate.now() %>
<%
	for(int i=0;i<10;i++){
		out.println("<p>helloworld</p>");
	}

	for(int i=0;i<10;i++){
%>
		<p>helloworld</p>
<%
	}
%>
<%
	String name = request.getParameter("name");
	String surname = request.getParameter("surname");
	String[] languages = request.getParameterValues("language");
	if (languages == null) {
		languages = new String[0];
	}
	LocalDate dob = LocalDate.parse(request.getParameter("dob"));
	
	Period period = Period.between(dob, LocalDate.now());
	int age = period.getYears();
	boolean isValidJunior = age <= 30 && Arrays.asList(languages).contains("java");
	boolean isValidSenior = age > 30 && Arrays.asList(languages).contains("java") && languages.length >= 2;
	boolean promoted = isValidJunior || isValidSenior;
	
%>
<p>il programmatore e' stato <%= promoted? "promosso" : "licenziato" %></p>
</body>
</html>