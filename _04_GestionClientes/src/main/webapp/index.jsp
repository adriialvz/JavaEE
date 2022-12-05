<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>





					<h1>PRIMERA APLICACION CLIENTES</h1>
					<h1>MANDAMOS INFORMACION DE SERVELT A JSP</h1>
						
						
						
	
					<!--NOMBRE DEL ATRIBUTO DEL SERVLET. IMPRIME EL OBJETO PASADO-->
					<p>${Mensaje}</p>	
					<p>${client}</p>
					
					
					<!-- ACCEDEMOS A LOS ATRIBUTOS DE CLIENTE CONO SI FUERAN PUBLICOS -->
					<p>${client.username}</p>
					
					
					
					
					
					
					
					
					
					<!-- OTRA FORMA DE ACCEDER!!! OJO ES CON getAttribute -->   
					<%
					String mensa=(String)request.getAttribute("Mensaje");
					%>		
					
					<%=
						mensa
					%>
					
				


</body>
</html>