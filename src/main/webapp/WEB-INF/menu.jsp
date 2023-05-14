<ul>
	<li><a href="/test/">Accueil</a></li>
	<li><a href="/test/bonjour">Bonjour</a></li>
	<li><a href="/test/form">Formulaire</a></li>
	<li><a href="/test/fichier">Fichier</a></li>
	<li><a href="/test/swanne">Question Swanne !</a></li>
</ul>

<c:if test="${ !empty sessionScope.nom && !empty sessionScope.prenom }"><p><c:out value="Bonjour, vous vous appelez ${ sessionScope.prenom } ${ sessionScope.nom }" /></p></c:if>