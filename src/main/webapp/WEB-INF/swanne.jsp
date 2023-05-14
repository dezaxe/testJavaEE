<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
        
	<form method="post" action="swanne">
		<p>
		    <label for="animal">Quel est ton animal préféré ? </label>
		    <input type="text" name="animal" id="animal" value="" />
		</p>
	    <p>
		    <label for="couleur">Quelle est ta couleur préférée ? </label>
		    <input type="text" name="couleur" id="couleur" value="" />
		</p>
		<p>
		    <label for="nombre">Quel est ton nombre préféré ? </label>
		    <input type="number" name="nombre" id="nombre" value="" />
		</p>
	    
	    <input type="submit" />
	</form>
	
	<c:if test="${ !empty animal && !empty couleur && !empty nombre}">
		<p>
			<c:out value="As tu déjà vu un(e) ${ animal } ${ couleur } avec ${ nombre } patte(s) ?">
			</c:out>
		</p>
	</c:if>
        
</body>
</html>