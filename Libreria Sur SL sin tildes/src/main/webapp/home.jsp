<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.name"/></title>
</head>
<body>


	<a href="ListarLibro"><spring:message code="accion.listarLibro"/></a><br>
	<a href="Carrito"><spring:message code="accion.carrito"/></a><br>
	<c:if test="${sessionUser.tipoUsuario.id==1}">
		<a href="BuscarApellidosNombrePedido"><spring:message code="accion.listarPedidos"/></a>
	<br>
	</c:if>
	<br>
	<a href="Inicio?lang=es"><spring:message code="idioma.es"/></a>
	<a href="Inicio?lang=en"><spring:message code="idioma.en"/></a>
</body>
</html>