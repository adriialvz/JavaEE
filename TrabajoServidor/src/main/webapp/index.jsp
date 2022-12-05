<%@page import="Modelo.beans.Eventos"%>
<%@page import="Modelo.daos.EventoListImpl"%>
<%@page import="Modelo.daos.IntEvento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

		.esti{
			color:yellow;
		}
		.uno{
			display:inline;
		}
		.dos{
			display:inline;
			margin-left:100px;
		}
		body{
			background-color:grey;
		}
		.esti2{
			position:absolute;
			left:50.5%;
			
			text-align:center;
			background-color: blue;
			font-weight:bold;
			color:white;
		}
		.esti3{
			text-align:center;
			background-color: blue;
			font-weight:bold;
			color:white;
		}
		.esti4{
			position:absolute;
			left:25px;
		}
		.esti5{
			position:absolute;
			left:70px;
		}
		.esti6{
			position:absolute;
			left:155px;
		}
		
		.esti8{
			position:absolute;
			left:350px;
		}
		.esti9{
			position:absolute;
			left:430px;	
		}
		.bar{
			display:inline;
			margin-left:15px;
		}
		.acti{
			font-weight:bold;
			color:red;
		}
		
	

</style>
</head>
<body>




		<p class="bar"><a href="#">TIPOS</a></p>
		<p class="bar"><a href="#">EVENTOS</a></p>
		<p class="bar"><a href="#">USUARIOS</a></p>
		<p class="bar"><a href="#">EVENTOS/TIPO</a></p>
		<p class="bar"><a href="#">LOGIN</a></p>
		<p class="bar"><a href="#">REGISTRO</a></p>
		<p class="bar"><a href="#">SALIR</a></p>


	
	<h1 class="esti">LISTADO DE EVENTOS ACTIVOS</h1>
	
	
	<%String mensaje= (String)request.getAttribute("men");%>
				<h3>Mensaje: <%=mensaje%></h3>
	
	
	<h3><a href="form.jsp">NUEVO EVENTO</a></h3>

	<caption></caption><span class="esti2">OPCIONES</span> </caption>

	<!-- DEVUELVE UNA LISTA --> 
	<%List<Eventos> lista= (List<Eventos>)request.getAttribute("evento");%>


	<table border="2" class="uno">
	
		<caption class="esti3">  <span class="esti4">Id</span><span class="esti5">Nombre</span> <span class="esti6">Descripcion</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="esti10">Precio</span> <span class="esti8">Estado</span> <span class="esti9">Destacado</span></caption>
	
	
	<% for (Eventos ele: lista){ %>
	<tr>
		
		<td>&nbsp;&nbsp;&nbsp;&nbsp;<%= ele.getIdEvento() %>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td><%= ele.getNombre() %></td>
		<td><%= ele.getDescripcion() %></td>
		<td><%= ele.getPrecio() %></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= ele.getEstado() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= ele.getDestacado() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>

	</tr>
	
	
	
	<%} %>
	</table>
	
	
	<table border="2" class="dos">
	

		

	
	
	<% for (Eventos ele: lista){ %>
	<tr>
		<td><a href="evento?opcion=editar&id=<%= ele.getIdEvento() %>">Editar Evento</a></td>
		<td><a href="evento?opcion=eliminar&id=<%= ele.getIdEvento() %>">Eliminar Evento</a></td>
		<td><a href="evento?opcion=cancelar&id=<%= ele.getIdEvento() %>">Cancelar Evento</a></td>
	</tr>
	
	
	
	<%} %>
	</table>
	
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a class="acti" href="evento?opcion=activos">VER EVENTOS ACTIVOS</a>
	

</body>
</html>