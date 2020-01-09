<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%-- <c:url value="/logout" var="link"/> --%>

<!DOCTYPE html>
<html>
	<body>
		
		<c:import url="logout_partial.jsp"></c:import>
		
		<c:if test="${ not empty empresa }">
			Empresa ${ empresa.nome } cadastrada com sucesso!
			<br />
		</c:if>
	
		
		Usuário Logado: ${ userLogged.login }
		<br/>
		<br/>
		<br/>

		Lista Empresas: <br />
		<ul>
		<c:forEach items="${ empresas }" var="empresa">
			<li>${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" />
				<a href="<c:url value="/mostraEmpresa?id=${ empresa.id }" />">Editar</a>
				<a href="<c:url value="/removeEmpresa?id=${ empresa.id }" />">Remover</a>
			</li>
		</c:forEach>
		</ul>
	</body>
</html>