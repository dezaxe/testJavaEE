<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire</title>
</head>
<body>
	<%@ include file="menu.jsp" %>

	<c:if test="${ !empty form.resultat }"><p><c:out value="${ form.resultat }"></c:out></p></c:if>
	<c:if test="${ !empty erreur }"><p style="color:red;"><c:out value="${ erreur }"></c:out></p></c:if>
	
	<c:out value="${ login }"></c:out>
        
	<form method="post" action="form">
		<p>
		    <label for="nom">Nom : </label>
		    <input type="text" name="nom" id="nom" value="${ sessionScope.nom }" />
		</p>
	    <p>
		    <label for="prenom">Prenom : </label>
		    <input type="text" name="prenom" id="prenom" value="${ sessionScope.prenom }" />
		</p>
	    
	    <input type="submit" />
	</form>
	
	<form method="post" action="form">
		<p>
			<label for="login">Login : </label>
		    <input type="text" name="login" id="login" />
	    </p>
	    <p>
			<label for="pass">Password : </label>
		    <input type="password" name="pass" id="pass" />
	    </p>
	    <input type="submit" />
	</form>
        
</body>
</html>