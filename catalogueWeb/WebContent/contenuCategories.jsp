<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<body>
<script src="javascript/produit.js"></script>
    <nav class="navCategories">
	<ul>
		<c:forEach var="aBean" items="${beanCategorie}">
			<li><a href="produitEJBservlet?id=${aBean.id}">${aBean.categorie}</a> </li>
		</c:forEach>			
	</ul>
</nav>
<div class="List">
    <table>
    	<c:forEach var="pBean" items="${beanCategorie2}">
        	<tr>
        		<td>${pBean.nom}</td>
        		<td> 
                    <form name="university" method="post" action="Faculties.php">
                        <button value = ${pBean.id}>Ajouter au panier</button>
                    </form>
                </td>
        	</tr>
		</c:forEach>
	</table>
</div>
</body>