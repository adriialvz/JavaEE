
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Bienvenido a Productos App</h1>
	
	<h2>Opciones Productos</h2>

	
	<p><a href="productos?opcion=novedades">Novedades</a></p>
	<p><a href="familias?opcion=todas">Familia</a></p>
	
	<h2>Listado de productos</h2>
	 
		<h3>Mensajes : ${requestScope.mensaje}</h3>
	 
	<h3><a href="FormAltaProducto.jsp">Nuevo Producto</a></h3>
	<table border="2">
	<tr>
	<th>Id</th><th>Descripcion</th><th>precio</th><th>familia</th><th>Editar</th><th>Eliminar</th>
	</tr>
	<c:forEach var="ele" items="${requestScope.listaProductos }">
		<tr>
		
		<td>${ele.idProducto}</td>
		<td>${ele.descripcion}</td>
		<td>${ele.precioUnitario}</td>
		<td>${ele.familia.descripcion}</td>
		<td><a href="productos?opcion=editar&id=${ele.idProducto }">Editar Producto</a></td>
		<td><a href="productos?opcion=eliminar&id=${ele.idProducto }">Eliminar Producto</a></td>
		</tr>
	
	</c:forEach>
	</table>
</body>
</html>