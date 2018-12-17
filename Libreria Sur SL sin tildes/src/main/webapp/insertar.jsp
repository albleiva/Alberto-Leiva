<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.name"/></title>
</head>
<body>
	<form:form modelAttribute="libro" method="GET" action="GuardarLibro">
		<form:hidden path="id"/>
		<table>
		<tr><td><spring:message code="libro.nombre"/></td><td><form:input path="nombre" /></td>
		<td><form:errors path="nombre" cssClass="error" /></td></tr>
		<tr><td><spring:message code="libro.editorial"/></td><td><form:input path="editorial" /></td>
		<td><form:errors path="editorial" cssClass="error" /></td></tr>
		<tr><td><spring:message code="libro.autor"/></td><td><form:input path="autor" /></td>
		<td><form:errors path="autor" cssClass="error" /></td></tr>
		<tr><td><spring:message code="libro.categoria"/></td><td><form:input path="categoria" /></td>
		<td><form:errors path="categoria" cssClass="error" /></td></tr>
		<tr><td><spring:message code="libro.edicion"/></td><td><form:input path="edicion" /></td>
		<td><form:errors path="edicion" cssClass="error" /></td></tr>
		<tr><td><spring:message code="libro.isbn"/></td><td><form:input path="isbn" /></td>
		<td><form:errors path="isbn" cssClass="error" /></td></tr>
		<tr><td><spring:message code="libro.descuento"/></td><td><form:input path="descuento" /></td>
		<td><form:errors path="descuento" cssClass="error" /></td></tr>
		<tr><td><spring:message code="libro.precio"/></td><td><form:input path="precio" /></td>
		<td><form:errors path="precio" cssClass="error" /></td></tr>
		<tr><td><input type="submit" value="<spring:message code="accion.guardar"/>"/></td>
		</table>
		<form:errors path="*" cssClass="errorblock" element="div" />
	</form:form>
	<br>
	${msg}
	<br>
	<a href="ListarLibro"><spring:message code="accion.listar"/></a>
</body>
</html>
	
	
