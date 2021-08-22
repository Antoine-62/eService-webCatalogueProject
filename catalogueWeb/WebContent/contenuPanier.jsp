<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<body>
<h1 class="titre">Contenu de votre pannier</h1>
<c:set var="user" value="${beanCategorie2}" />
<c:choose> 
	<c:when test="${empty beanCategorie2}">
		<p>Votre panier est vide</p>	
	</c:when>
	<c:otherwise>
		<div class="List">
		    <table>
		    	<c:forEach var="pBean" items="${MonPanier}">
		        	<tr>
		        		<td>${pBean.nom}</td>
		        	</tr>
				</c:forEach>
			</table>
			<a href = "confirmationCommande">Valider votre panier</a>
		</div>
	</c:otherwise>
</c:choose>
</body>