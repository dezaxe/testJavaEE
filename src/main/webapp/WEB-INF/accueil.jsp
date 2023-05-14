<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accueil</title>
	</head>
	<body>
		<%@ include file="menu.jsp" %>
		<p>Bienvenue sur mon site !</p>
		<c:if test="${ !empty erreur }"><p style="color:red;"><c:out value="${ erreur }"></c:out></p></c:if>
		<ul>
			<c:forEach var="utilisateur" items="${ utilisateurs }">
				<li><c:out value="${ utilisateur.prenom }"/> <c:out value="${ utilisateur.nom }"/></li>
			</c:forEach>
		</ul>
	</body>
</html>