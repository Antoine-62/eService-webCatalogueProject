<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<body>
<script src="javascript/AjoutPanier.js"></script>
    <nav class="navCategories">
	<ul>
		<c:forEach var="aBean" items="${beanCategorie}">
			<li><a href="produitEJBservlet?id=${aBean.id}">${aBean.categorie}</a> </li>
		</c:forEach>			
	</ul>
</nav>
<c:set var="user" value="${beanCategorie2}" />
<c:choose> 
	<c:when test="${empty beanCategorie2}">
		<p>Veuillez selectionner une catégorie</p>	
	</c:when>
	<c:otherwise>
		<div class="List">
			<table>
				<c:forEach var="pBean" items="${beanCategorie2}">
			      	<tr>
			        	<td>${pBean.nom}</td>
			        	<td>${pBean.prix} $</td>
			        	<td>${pBean.description}</td>
			        	<td> 
			            	<button onclick="ajoutPanier(${pBean.id})">Ajouter au panier</button>
			            </td>
			        	</tr>
				</c:forEach>
			</table>
		</div>
	</c:otherwise>
</c:choose>
</body>