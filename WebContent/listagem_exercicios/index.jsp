<%@ page import="com.gymtraining.beans.Usuario, com.gymtraining.dao.UsuarioDAO;" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gym Training - Listagem de Exerc�cios</title>
	</head>

	<body>
		<h1>Listagem de Exerc�cios</h1>
		<a href="../">Voltar</a>
		<hr>

		<form ACTION="./lista" METHOD="POST">
    			<fieldset style="display:inline-block; width: 45%;vertical-align: top;border:none;">
      				<label>
      					<p>Qual o seu e-mail?</p>
      					<input TYPE="mail" NAME="email" ALIGN="left" SIZE="50" required>
      				</label>
				</fieldset>
  				<p style="padding: 0 16px;"><input TYPE="submit" NAME="submit" VALUE="Ver Exerc�cios"></p>
		</form>
	</body>
</html>