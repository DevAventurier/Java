<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form method="post" action="Formulaire">
 
 	<label for="nom">Nom : </label>
 	<input type = "text" name= "nom" id="nom"/>
 	
 	<label for="prenom">Prenom : </label>
 	<input type = "text" name= "prenom" id="pxcrenom"/>
 	
 	<input type="submit" />
 </form>
 
 <ul>
	 <c:forEach>
	 	<li><c:out value="${utilisateur.nom}"/> <c:out value="${utilisateur.prenom}"/></li>
	 </c:forEach>
 </ul>
 
</body>
</html>