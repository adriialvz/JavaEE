<%@page import="Modelo.beans.Empleado"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="grey">



				<h1>APLICACION DE GESTION DE EMPLEADOS</h1>
				
				<%String mensaje= (String)request.getAttribute("men");%>
				<h3>Mensaje: <%=mensaje%></h3>

				<!-- CONTROL + ESPACIO PARA IMPORTAR -->
				
			

				<p><a href="altaEmpleado.jsp">NUEVO EMPLEADO</a></p>   <!-- empleados?opcion=alta&id -->

				
				
				<!-- DEVUELVE UNA LISTA --> 
				<%List<Empleado> listilla= (List<Empleado>)request.getAttribute("empleados");%>


				<table border="2">
				
						<tr>
									<th>ID</th><th>NOMBRE</th><th>SALARIO</th><th>EDITAR</th><th>ELIMINAR</th>							
						</tr>
						
						
						<%for (Empleado ele:listilla){ %>
						<tr>
						
								<td><%=ele.getIdEmpleado()%></td>
								<td><%=ele.getNombre()%></td>
								<td><%=ele.getSalario()%></td>
								
								<td><a href="empleados?opcion=editar&id=<%=ele.getIdEmpleado()%>">EDITAR EMPLEADO</a></td>
								<td><a href="empleados?opcion=eliminar&id=<%=ele.getIdEmpleado()%>">ELIMINAR EMPLEADO</a></td>
								
						</tr>
						
						
						<%} %>
				</table>

</body>
</html>