<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
<jsp:include page="contenuCategories.jsp" flush="true">
    <jsp:param name="beanCategorie" value="${beanCategorie}"/>
</jsp:include>
</t:wrapper>