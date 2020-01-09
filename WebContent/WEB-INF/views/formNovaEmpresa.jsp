<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/novaEmpresa" var="link" />

<html>
<head>
	<meta charset="ISO-8859-1">
	<title> </title>
</head>
	
	<body>
		<c:import url="logout_partial.jsp"></c:import>
		
		<form action="${ link }" method="post">
			Nome: <input type="text" name="nome" />
			Data Abertura: <input type="text" name="dataAbertura">
			
			<input type="submit" />
		</form>
	</body>
</html>