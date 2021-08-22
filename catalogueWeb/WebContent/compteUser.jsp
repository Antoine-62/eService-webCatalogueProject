<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
	<jsp:include page="contenuUser.jsp" flush="true">
		<jsp:param name="utilisateur" value="${beanUser}"/>
		<jsp:param name="commandes" value="${beanCommandes}"/>
	</jsp:include>
</t:wrapper>