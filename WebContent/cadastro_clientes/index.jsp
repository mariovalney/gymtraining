<%@ page import="com.gymtraining.beans.Usuario, com.gymtraining.dao.UsuarioDAO;" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gym Training - Gerenciamento de Clientes</title>
	</head>

	<body>
		<h1>Gerenciamento de Clientes</h1>
		<a href="../">Voltar</a>
		<hr>
		<div style="display:inline-block; width:45%; margin-right: 20px; border-right: 2px #000 solid">
			<form ACTION="./cadastro" METHOD="POST" ID="cadastro">
				<h3>Cadastrar Cliente</h3>
	    			<fieldset style="display:inline-block; width: 45%;vertical-align: top;border:none;">
	      				<label>
	      					<p>Nome do Cliente:</p>
	      					<input type="Text" name="nome" size="80" required>
	      				</label>
	      				<label>
	      					<p>E-mail do Cliente:</p>
	      					<input type="mail" name="email" size="50" required>
	      				</label>
	      				<label>
	      					<p>Data de Nascimento:</p>
	      					<input type="date" name="dataNascimento" required>
	      				</label>
	      				<input type="hidden" name="origem" value="cadastro">
	    			</fieldset>
	  				<p style="padding: 0 16px;"><input TYPE="submit" NAME="submit" VALUE="Enviar Cadastro"></p>
			</form>
		</div>
		<div style="display:inline-block; width:45%; vertical-align:top">
			<form ACTION="./edicao" METHOD="POST" ID="edicao">
				<h3>Editar Cliente</h3>
				<fieldset style="display:inline-block; width: 45%;vertical-align: top;border:none;">
	      				<label>
	      					<p>Selecione o Cliente:</p>
	      					<select NAME="id" size="1">
	<%
		UsuarioDAO dao = new UsuarioDAO();
		
		for(Usuario user : dao.getAllNames()){
			%>
			<option VALUE="<%= user.getId() %>"><%= user.getNome() %></option>
			<%		
		}
	%>
							</select>
						</label>
				</fieldset>
				<p style="padding: 0 16px;"><input TYPE="submit" NAME="submit" VALUE="Editar Cliente"></p>
			</form>
			<br>
			<hr>
			
			<form ACTION="./deletar" METHOD="POST" ID="edicao" style="display:inline-block; width:45%; vertical-align:top">
				<h3>Apagar Cliente</h3>
				<em>Esse processo é irreversível e irá excluir também os exercícios relacionados ao cliente.</em>
				<fieldset style="display:inline-block; width: 45%;vertical-align: top;border:none;">
	      				<label>
	      					<p>Selecione o Cliente:</p>
	      					<select NAME="id" size="1">
	<%
		for(Usuario user : dao.getAllNames()){
			%>
			<option VALUE="<%= user.getId() %>"><%= user.getNome() %></option>
			<%		
		}
	%>
							</select>
						</label>
				</fieldset>
				<p style="padding: 0 16px;"><input TYPE="submit" NAME="submit" VALUE="Apagar Cliente"></p>
			</form>
		</div>
	</body>
</html>