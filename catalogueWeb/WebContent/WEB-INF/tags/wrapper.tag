<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<html>
<head>
<title>Login page</title>
<style><%@include file="/WEB-INF/css/wrapper.css"%></style>
</head>
<body>
<header>
La boutique du ch'nord
</header>
<nav>
	<ul>
		<li><a href = "catalogueServlet">Accueil</a> </li>
		<li><a href = "produitEJBservlet">Categories</a> </li>			
		<li><a href = "catalogueEJBServlet">Votre panier</a></li>						
	</ul>
</nav>
  <jsp:doBody/>
 <footer>
	<p>Ce projet a été dans le cadre d'un projet informatique de l'EILCO :</p>
	<a href = "http://www.eilco-ulco.fr/">Eilco</a>
</footer>
</body></html>