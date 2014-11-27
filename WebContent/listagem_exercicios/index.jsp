<%@ page import="com.gymtraining.beans.Usuario, com.gymtraining.dao.UsuarioDAO;" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gym Training - Listagem de Exercícios</title>
	</head>

	<body>
		<h1>Listagem de Exercícios</h1>
		<a href="../">Voltar</a>
		<hr>

		<form ACTION="./lista" METHOD="POST">
    			<fieldset style="display:inline-block; width: 45%;vertical-align: top;border:none;">
      				<label>
      					<p>Qual o seu e-mail?</p>
      					<input TYPE="mail" NAME="email" ALIGN="left" SIZE="50" required>
      				</label>
				</fieldset>
  				<p style="padding: 0 16px;"><input TYPE="submit" NAME="submit" VALUE="Ver Exercícios"></p>
		</form>
	</body>
</html>