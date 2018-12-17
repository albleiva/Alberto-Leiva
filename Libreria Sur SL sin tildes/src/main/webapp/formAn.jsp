<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
<title><spring:message code="app.name"/></title>
</head>
<body>
	<form:form modelAttribute="usuario" method="GET" action="BuscarAnp">
		<spring:message code="usuario.apellidos"/><form:input path="apellidos"/>
		<form:errors path="apellidos" cssClass="error"/><br>
		<spring:message code="usuario.nombre"/><form:input path="nombre"/>
		<form:errors path="nombre" cssClass="error"/><br>
		<input type="submit" value="<spring:message code="accion.buscar"/>"/>
	
	</form:form>
	<br>
	<a href="Inicio"><spring:message code="accion.inicio"/></a>
</body>
</html>
	
	
