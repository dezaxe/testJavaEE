<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fichier</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	
	<c:if test="${ !empty fichier }"><p><c:out value="Le fichier ${ fichier } (${ description }) a bien �t� upload�."></c:out></p></c:if>
	
	<form method="post" action="fichier" enctype="multipart/form-data">
		<p>
			<label for="description">Description du fichier : </label>
			<input type="text" name="description" id="description"/>
		</p>
		<p>
			<label for="fichier">Fichier � envoyer : </label>
			<input type="file" name="fichier" id="fichier"/>
		</p>
		<input type="submit"/>
	</form>

</body>
</html>