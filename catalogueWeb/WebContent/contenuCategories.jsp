<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<body>
    <h1>Categories</h1>
    <c:forEach var="aBean" items="${beanCategorie}">
		Test ${aBean.categorie}
	</c:forEach>
</body>