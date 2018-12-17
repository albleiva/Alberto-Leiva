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
	<table>
		<tr>
			<th><spring:message code="libro.nombre"/></th>
			<th><spring:message code="libro.editorial"/></th>
			<th><spring:message code="libro.autor"/></th>
			<th><spring:message code="libro.categoria"/></th>
			<th><spring:message code="libro.edicion"/></th>
			<th><spring:message code="libro.isbn"/></th>
			<th><spring:message code="libro.descuento"/></th>
			<th><spring:message code="libro.precio"/></th>
			<c:if test="${sessionUser.tipoUsuario.id==1}">
				<th><spring:message code="accion.eliminar"/></th>
			</c:if>
			<th><spring:message code="accion.comprar"/></th>
		</tr>
		<c:forEach items="${lista}" var="l">
			<tr>
			<c:choose>
			  <c:when test="${sessionUser.tipoUsuario.id==1}">
					<td><a href="BuscarLibro?id=${l.id}">${l.nombre}</a></td>
			  </c:when>
			  <c:otherwise>
					<td>${l.nombre}</td>
			  </c:otherwise>	
			 </c:choose>
				<td>${l.editorial}</td>
				<td>${l.autor}</td>
				<td>${l.categoria}</td>
				<td>${l.edicion}</td>
				<td>${l.isbn}</td>
				<td>${l.descuento}</td>
				<td>${l.precio}</td>
				<c:if test="${sessionUser.tipoUsuario.id==1}">
				  <td><a href="BorrarLibro?id=${l.id}" onclick="return confirm('<spring:message code="accion.confirmar"/>')"><spring:message code="accion.eliminar"/></a></td>
				</c:if>
				<td><a href="Comprar?id=${l.id}"><spring:message code="accion.comprar"/></a></td>		
			</tr>
		</c:forEach>
	</table>
	<br>
	 <a href="Inicio"><spring:message code="accion.inicio"/></a>
	<br>
	 <a href="OrdenarNombre"><spring:message code="accion.ordenarNombre"/></a>
	<br>
	 <a href="OrdenarEditorial"><spring:message code="accion.ordenarEditorial"/></a>
	<br>
	<a href="OrdenarAutor"><spring:message code="accion.ordenarAutor"/></a>
	<br>
	<a href="OrdenarCategoria"><spring:message code="accion.ordenarCategoria"/></a>
	<br>
	<a href="OrdenarPrecioAsc"><spring:message code="accion.ordenarPrecioAsc"/></a>
	<br>
	<a href="OrdenarPrecioDes"><spring:message code="accion.ordenarPrecioDes"/></a>
	<br>
	<c:if test="${sessionUser.tipoUsuario.id==1}">
	  <a href="InsertarLibro"><spring:message code="accion.insertarLibro"/></a>
	</c:if>
</body>
</html>
