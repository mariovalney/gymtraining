<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<%
String status = (String)request.getAttribute("status");
String nomeDoClienteo = (String)request.getAttribute("nomedocliente");
String emailDoCliente = (String)request.getAttribute("emaildocliente");
String idDoCliente = (String)request.getAttribute("iddocliente");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gym Training - Exclusão de Cadastro</title>
	</head>

	<body>
		<h1>Exclusão de Cadastro</h1>
		<a href="../">Voltar</a>
		<hr>
		<% if (status == "sucesso") { %>
		<h4>Cadastro Excluído com Sucesso.</h4>
		<% } else { %>
		<h4>Houve um erro! :(</h4>
		<p>Entre em contato com o Desenvolvedor ou tente novamente.</p>
		<% } %>
	</body>
</html>