<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN_PAGE</title>
</head>
<body>

	<center><h3>Account Successfully Created ....... Use the form bellow to Log-In</h3></center>
	
	<!DOCTYPE html>
<html>
<head>
	<title>Formulaire de connexion</title>
	<style>
		body {
			background-color: #f2f2f2;
			font-family: Arial, sans-serif;
		}
		form {
			background-color: #ffffff;
			border-radius: 10px;
			box-shadow: 0px 0px 10px #888888;
			margin: 50px auto;
			padding: 20px;
			width: 400px;
		}
		h1 {
			color: #333333;
			font-size: 24px;
			margin-bottom: 20px;
			text-align: center;
		}
		input[type="text"], input[type="password"] {
			border: none;
			border-radius: 5px;
			box-shadow: 0px 0px 5px #888888;
			display: block;
			font-size: 16px;
			margin: 10px auto;
			padding: 10px;
			width: 100%;
		}
		input[type="submit"] {
			background-color: #333333;
			border: none;
			border-radius: 5px;
			color: #ffffff;
			cursor: pointer;
			display: block;
			font-size: 16px;
			margin: 20px auto 0px;
			padding: 10px;
			width: 100%;
		}
		input[type="submit"]:hover {
			background-color: #555555;
		}
	</style>
</head>
<body>
	<form class="c-form" action="login" method="post">
		<h1>Connexion</h1>
		<label for="username">Nom d'utilisateur:</label>
		<input type="text" id="username" name="username" required>
		<label for="motdepasse">Mot de passe:</label>
		<input type="password" id="motdepasse" name="motdepasse" required>
		<input type="checkbox" name="check"> Se souvenir de moi
		<input type="submit" value="Se connecter">
	</form>
</body>
</html>
	
	
</body>
</html>