<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<html>
<head>
<title>Le magasin de la patate!</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<style><%@include file="/WEB-INF/css/wrapper.css"%></style>
</head>
<body>
<nav>
	<ul>
		<li><a href = "catalogueServlet">Accueil</a> </li>
		<li><a href = "catalogueEJBServlet">Categories</a> </li>			
		<li><a href = "">Votre panier</a></li>						
	</ul>
</nav>
  <jsp:doBody/>
 <footer>
	<p>Ce projet a été dans le cadre d'un projet informatique de l'EILCO :</p>
	<a href = "http://www.eilco-ulco.fr/">Eilco</a>
</footer>
</body></html>