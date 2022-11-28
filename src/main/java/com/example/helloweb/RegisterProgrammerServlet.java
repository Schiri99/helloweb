package com.example.helloweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

/**
 * Servlet implementation class RegisterProgrammerServlet
 */
public class RegisterProgrammerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		String surname =request.getParameter("surname");
		String[] languages=request.getParameterValues("language");
		if(languages == null) {
			languages=new String [0];
		}
		LocalDate dob=LocalDate.parse(request.getParameter("dob"));
		
		/*
		 * se il programmatore ha meno di 30 anni deve conoscere almeno un linguaggio e quel linguaggio deve essere java 
		 * se il programmatore ha più di 30 anni dovrà conoscere 2 linguaggi e fra questi deve essere presente java
		 * se una delle due è vera stampiamo un messaggio che dirà il programmatore cicciopasticcio verrà promosso 
		 * se no stampiamo il programmatore verrà licenziato 
		 *  */
		Period period = Period.between( dob,LocalDate.now());
		int age = period.getYears();
		boolean isValidJunior=age<=30 && Arrays.asList(languages).contains("java");
		boolean isValidSenior=age>30 && Arrays.asList(languages).contains("java") && languages.length>=2;
		boolean promoted=isValidJunior || isValidSenior;
		String message = String.format("il programmatore %s %s e' stato %s ",name,surname,promoted? "promosso" : "licenziato" );
		PrintWriter pw =response.getWriter();
		pw.println("<p>" + message + "</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
