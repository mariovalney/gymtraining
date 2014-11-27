<%@ page import="com.gymtraining.beans.Usuario, com.gymtraining.dao.UsuarioDAO;" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gym Training - Cadastro de Exercícios</title>
	</head>

	<body>
		<h1>Cadastro de Exercícios</h1>
		<a href="../">Voltar</a>
		<hr>

		<form ACTION="./cadastro" METHOD="POST">
    			<fieldset style="display:inline-block; width: 45%;vertical-align: top;border:none;">
      				<label>
      					<p>Nome do Exercício:</p>
      					<input TYPE="Text" NAME="nome" ALIGN="left" SIZE="50" required>
      				</label>
      				<label>
      					<p>Selecione o Cliente:</p>
      					<select NAME="id_cliente" size="1" required>
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
    			<fieldset style="display:inline-block; width: 45%;vertical-align: top;border:none;">
  					<p>Descrição do Exercício (max 200)</p>
  					<textarea NAME="descricao" ROWS="10" style="width: 100%;"></textarea>
  				</fieldset>
  				<p style="padding: 0 16px;"><input TYPE="submit" NAME="submit" VALUE="Cadastrar Exercício"></p>
		</form>
	</body>
</html>