<%@ page pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
 <h1> <c:out value="Bonjour" /> </h1>
 
 <c:if test="${!empty nom }"><p><c:out value="Morning M./Mme ${nom} }" /></p></c:if>
 <form method="post" action="test">
 
 	<label for="nom">Nom : </label>
 	<input type = "text" name= "nom" id="nom"/>
 	
 	<label for="password">Password : </label>
 	<input type = "password" name= "password" id="password"/>
 	
 	<input type="submit" />
 </form>
 
 <c:if test="${! nom== 'hateam' && password== 'hateam' }"><p><c:out value="Login Successful M./Mme ${nom} }" /></p></c:if>
 
 <!-- dans le action c'est le lien du path du xml qui pointe vers la servlet -->
 
  <!-- mettre en place un formulaire d'authentification avec un mot de passe par defaut connu et enregistre dans le code -->
  
</body>
</html>