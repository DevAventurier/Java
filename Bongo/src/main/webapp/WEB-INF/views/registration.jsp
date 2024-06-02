<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Création de compte</title>
	<style>
		body {
			background-color: #f2f2f2;
			font-family: Arial, sans-serif;
		}
		form {
			background-color: #fff;
			border-radius: 5px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
			margin: 50px auto;
			padding: 20px;
			width: 500px;
		}
		input[type=text], input[type=password] {
			border: none;
			border-radius: 3px;
			box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.1);
			display: block;
			font-size: 16px;
			margin: 10px 0;
			padding: 10px;
			width: 100%;
		}
		input[type=submit] {
			background-color: #4CAF50;
			border: none;
			border-radius: 3px;
			color: #fff;
			cursor: pointer;
			font-size: 16px;
			margin-top: 20px;
			padding: 10px;
			width: 100%;
		}
		input[type=submit]:hover {
			background-color: #3e8e41;
		}
	</style>
</head>
<body>
	<form class="c-form" action="<%= request.getContextPath()%>/register" method="post">
		<h2>Créer un compte</h2>
		<label for="nom">Nom:</label>
		<input type="text" id="nom" name="nom" required>
		<label for="prenom">Prénom:</label>
		<input type="text" id="prenom" name="prenom" required>
		<label for="username">Nom d'utilisateur:</label>
		<input type="text" id="username" name="username" required>
		<label for="motdepasse">Mot de passe:</label>
		<input type="password" id="motdepasse" name="motdepasse" required>
		<input type="submit" value="Créer un compte">
	</form>
	<script>
		// Ajoutez ici votre code JavaScript pour rendre la page dynamique
	</script>
</body>
</html>
