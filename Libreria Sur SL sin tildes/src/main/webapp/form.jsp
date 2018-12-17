<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.name"/></title>
</head>
<body>
	<form:form modelAttribute="usuario" method="POST" action="login">
	<table>
		<tr><td><spring:message code="usuario.email"/></td><td><form:input path="email" /></td>
		<td><form:errors path="email" cssClass="error" /></td></tr>
		<tr><td><spring:message code="usuario.password"/></td><td><form:password path="password" /></td>
		<td><form:errors path="password" cssClass="error" /></td></tr>
		<tr><td><input type="submit" value="<spring:message code="accion.login"/>"/></td>
	</table>
	<form:errors path="id" cssClass="errorblock" element="div" />
	</form:form>
	<br>
	${msg}
</body>
</html>