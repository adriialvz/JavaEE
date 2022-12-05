<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Modelo.beans.Eventos"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.daos.EventoListImpl"%>
<%@page import="Modelo.daos.IntEvento" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    
    
    	<h1>FORMULARIO DE ALTA DE EVENTOS</h1>

        <form action="evento?opcion=alta" method="post">
            <p><input type="text" name="idEvento" >IdEvento</p>
            <p><input type="text" name="nombre" >Nombre</p>
            <p><input type="text" name="precio" >Precio</p>
            <p><input type="text" name="descripcion" >Descripcion</p>
            <p><input type="text" name="descripcion" >Estado</p>
            <p><input type="text" name="destacado" >Destacado</p>
            <p><input type="text" name="idTipo" >Tipo</p>
            
           

            <p><input type="submit" value="Enviar"></p>

        </form>
        
        

</body>
</html>