<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<html>
<head>
<title>Le magasin de la patate!</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<style><%@include file="/WEB-INF/css/wrapper.css"%></style>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<nav>
	<ul>
		<li><a href = "catalogueServlet">Accueil</a> </li>
		<li><a href = "catalogueEJBServlet">Categories</a> </li>			
		<li><a href = "PanierServlet">Votre panier</a></li>
		<c:set var="user" value="${beanUser}" />
		<c:choose> 
		  <c:when test="${empty user}">
		  	<li><a href = "Inscription">Inscription</a></li>	
			<li><a href = "login">Se connecter</a></li>		
		  </c:when>
		  <c:otherwise>
		    <li><a href = "user">Mon compte</a></li>
		   	<li><a href = "logout">Déconnexion</a></li>
		  </c:otherwise>
		</c:choose>
	</ul>
</nav>
<div class="wrapper">
  <jsp:doBody/>
</div>
 <footer>
	<p>Ce projet a été dans le cadre d'un projet informatique de l'EILCO :</p>
	<a href = "http://www.eilco-ulco.fr/">Eilco</a>
</footer>
</body></html>