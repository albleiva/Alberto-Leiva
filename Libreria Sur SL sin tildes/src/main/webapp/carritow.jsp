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

 <c:choose>
    <c:when test="${carrito.libro.size()==0}">
        <spring:message code="carrito.vacio"/>
        <br>
   </c:when>
   <c:otherwise>
	<form:form modelAttribute="carrito" method="POST" action="ConfirmarPedido">
		<table>
		<tr>
		    <th><spring:message code="carrito.nombre"/></th>
			<th><spring:message code="carrito.editorial"/></th>
			<th><spring:message code="carrito.autor"/></th>
			<th><spring:message code="carrito.categoria"/></th>
			<th><spring:message code="carrito.edicion"/></th>
			<th><spring:message code="carrito.isbn"/></th>
			<th><spring:message code="carrito.descuento"/></th>
			<th><spring:message code="carrito.precio"/></th>
		</tr>	
		<c:forEach items="${carrito.libro}" var="c">
			<tr>
				<td>${c.nombre}</td>
				<td>${c.editorial}</td>
				<td>${c.autor}</td>
				<td>${c.categoria}</td>
				<td>${c.edicion}</td>
				<td>${c.isbn}</td>
				<td>${c.descuento}</td>
				<td>${c.precio}</td>
			</tr>
		</c:forEach>
		<tr><td><input type="submit" value="<spring:message code="accion.comprar"/>"/></td>
		</table>
		<br>
	    <a href="ListarLibro"><spring:message code="accion.libros"/></a>
	    
	</form:form>
	</c:otherwise>
 </c:choose>
  <a href="Inicio"><spring:message code="accion.inicio"/></a>
</body>
</html>