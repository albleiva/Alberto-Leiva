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
    <c:when test="${empty lista}">
        <spring:message code="pedidos.vacio"/>
   </c:when>
   <c:otherwise>
    <spring:message code="usuario"/> ${usuario.nombre} ${usuario.apellidos}
    <br>
      <table>
		<tr>
			<th><spring:message code="pedido.fechaCompra"/></th>
			<th><spring:message code="pedido.cantidad"/></th>
			<th><spring:message code="pedido.importe"/></th>
		</tr>
		<tr>
		<c:forEach items="${lista}" var="l">
			<tr>
				<td><fmt:formatDate value="${l.fechaCompra}" pattern="dd/MM/yyyy" var="fechaCompra" />
		 	    <c:out value="${fechaCompra}"/></td>
				<td><c:out value="${l.cantidad}"/></td>
				<td><c:out value="${l.importe}"/></td>
			</tr>
		</c:forEach>
		</tr>
	   </table>
     
   </c:otherwise>
  </c:choose>
    <br>
   <a href="Inicio"><spring:message code="accion.inicio"/></a>
</body>
</html>