<%@page import="java.util.List"%>
<%@page import="Modelo.beans.Eventos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<% Eventos evento = (Eventos)request.getAttribute("evento");%>
	
	<p>Descripcion : <%= evento.getDescripcion() %></p>
	<p> Precio: <%= evento.getPrecio()%></p>
	<p> Nombre: <%= evento.getNombre()%></p>
	<p> Estado: <%= evento.getEstado()%></p>
	
	
	

	
	
	
</body>
</html>