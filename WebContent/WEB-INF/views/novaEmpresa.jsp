<%
	String nomeEmpresa = "Alura";
	System.out.println(nomeEmpresa);
%>

<html>
<body>
	<%-- coment�rio em JSP aqui --%>
	<%--Empresa <% out.println(nomeEmpresa); %> cadastrada com sucesso! --%>
	
	Empresa <%= nomeEmpresa %> cadastrada com sucesso!
</body>
</html>