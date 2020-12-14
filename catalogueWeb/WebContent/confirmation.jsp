<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
	<jsp:include page="contenuConfirmation.jsp" flush="true">
		<jsp:param name="MonPanier" value="${MonPanier}"/>
	</jsp:include>
</t:wrapper>