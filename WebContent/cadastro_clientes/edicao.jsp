<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.Date, com.gymtraining.dao.UsuarioDAO;"%>

<%
String status = (String)request.getAttribute("status");
String idDoCliente = (String)request.getAttribute("iddocliente");
String nomeDoClienteo = (String)request.getAttribute("nomedocliente");
String emailDoCliente = (String)request.getAttribute("emaildocliente");
Date dataDeNascimento = (Date)request.getAttribute("datanascimento");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gym Training - Cadastro de Clientes</title>
	</head>

	<body>
		<h1>Cadastro de Clientes</h1>
		<a href="../">Voltar</a>
		<hr>

		<form ACTION="./cadastro" METHOD="POST">
    			<fieldset style="display:inline-block; width: 45%;vertical-align: top;border:none;">
      				<label>
      					<p>Nome do Cliente:</p>
      					<input type="Text" name="nome" size="80" value="<%= nomeDoClienteo %>" required>
      				</label>
      				<label>
      					<p>E-mail do Cliente:</p>
      					<input type="mail" name="email" size="50" value="<%= emailDoCliente %>" required>
      				</label>
      				<label>
      					<p>Data de Nascimento:</p>
      					<input type="date" name="dataNascimento" value="<%= dataDeNascimento %>" required>
      				</label>
      				<input type="hidden" name="origem" value="edicao">
      				<input type="hidden" name="id" value="<%= idDoCliente %>">
    			</fieldset>
  				<p style="padding: 0 16px;"><input TYPE="submit" NAME="submit" VALUE="Enviar Cadastro"></p>
		</form>
	</body>
</html>