<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/alteraEmpresa" var="link" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

	<c:import url="logout_partial.jsp" />

	<!-- Tomcat interpreta todo o código JSP. -->

	<form action="${ link }" method="post">
		Nome: <input type="text" name="nome" value="${ empresa.nome }" />
		
		Data Abertura: <input type="text" name="dataAbertura"
			value="<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" />">
		
		<input type="hidden" name="id" value="${ empresa.id }" /> 
		
		<input type="submit" />
	</form>
</body>
</html>