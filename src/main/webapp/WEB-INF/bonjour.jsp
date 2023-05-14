<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%@ include file="menu.jsp" %>
		<p><c:out value="Bonjour JSTL !"/></p>
		<c:set var="nameBis" value="${ name }" scope="session"></c:set>
	    <p>Bonjour ${ empty name ? "vous" : nameBis } !</p>
	    <p>-------------------------------------------------------------</p>
	    <p>${ heure.equals("jour") ? "Bonjour" : "Bonsoir" } ${ noms[1] }</p>
	    <p>Auteur : ${ auteur.prenom } ${ auteur.nom }</p>
	    <c:set target="${ auteur }" property="prenom" value="Michael"/>
	    <p><c:out value="${ auteur.prenom }"/></p>
	    
	    <c:choose>
		    <c:when test="${ auteur.actif }">
		    	<p>Vous n'êtes très actif !</p>
		    </c:when>
		    <c:otherwise>
		    	<p>Vous n'êtes pas actif !</p>
		    </c:otherwise>
		</c:choose>
		
		<c:forTokens var="morceau" items="Un élément/Encore un autre élément/Un dernier pour la route" delims="/">
			<p><b>${ morceau }</b><c:out value="<b>${ morceau }</b>"/></p>
		</c:forTokens>
		
		<c:forEach var="i" begin="0" end="10" step="1">
			<p>Un message <c:out value="${ i }"/> fois !</p>
		</c:forEach>
		
		<c:forEach items="${ titres }" var="titre" varStatus="status">
			<p>Index : ${ status.index }, Titre n°${ status.count } : ${ titre } !</p>
		</c:forEach>
	    
		<p>
		    <%
		        for (int i = 0 ; i < 20 ; i++) {
		            out.println("Une nouvelle ligne !<br />");
		        }
		    %>
		</p>
		<c:if test="${ 50 > 10 }" var="ifResponse" scope="session">
			<p><b>${ ifResponse }</b></p>
		</c:if>
	</body>
</html>