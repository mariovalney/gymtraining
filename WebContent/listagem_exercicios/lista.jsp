<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*, com.gymtraining.beans.Exercicio;"%>

<%
String status = (String)request.getAttribute("status");
String nomeDoCliente = (String)request.getAttribute("nomedocliente");
List<Exercicio> listaDeExercicio = (List<Exercicio>)request.getAttribute("listadeexercicios");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gym Training - Lista de Exercícios</title>
	</head>

	<body>
		<h1>Lista de Exercícios</h1>
		<a href="../">Voltar</a>
		<hr>
		<% if (status == "sucesso") { %>
		<h4>Lista de Exercícios de: <%= nomeDoCliente %></h4>

<%
	if (listaDeExercicio.isEmpty()) {
		%>
		<p>Não há exercícios cadastrados para esse usuário.</p>
		<%
	} else {
		%>
		<table border="1">
			<tr>
				<td style="padding: 10px 30px;">Nome do Exercício</td>
				<td style="padding: 10px 30px;">Descrição do Exercício</td>
			</tr>
		<%
		for (Exercicio exec : listaDeExercicio){
			%>
			<tr>
			<td style="padding: 10px 30px;"><%= exec.getNome() %></td>
			<td style="padding: 10px 30px;"><pre><%= exec.getDescricao() %></pre></tr>
			</tr>
			<%		
		}
		%>
		</table>
		<%
	}
%>		
		<% } else if (status == "unregistered"){ %>
		<h4>Ooops...</h4>
		<p>Parece que seu e-mail não está registrado conosco.</p>
		<% } else { %>
		<h4>Houve um erro! :(</h4>
		<p>Entre em contato com o Desenvolvedor</p>
		<% }%>
	</body>
</html>