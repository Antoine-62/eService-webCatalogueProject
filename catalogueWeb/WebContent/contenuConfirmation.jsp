<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html>
<body bgcolor="white">
<h1 class="titre">Valiser votre commande</h1>
<div class="registration">
    <html:form action="validerCommande">
      <table border="0" align="center">
        <tr>
          <td align="right">
            Adresse :
          </td>
          <td align="left">
            <html:text property="adresse" size="40" maxlength="40"/>
          </td>
        </tr>
        <tr>
          <td align="right">
            Code postal :
          </td>
          <td align="left">
            <html:text property="code" size="40" maxlength="40"/>
          </td>
        </tr>
        <tr>
          <td align="right">
            Ville :
          </td>
          <td align="left">
            <html:text property="ville" size="40" maxlength="40"/>
          </td>
        </tr>
        <tr>
          <td align="right">
            Pays :
          </td>
          <td align="left">
            <html:text property="pays" size="40" maxlength="40"/>
          </td>
        </tr>
        <tr>
          <td align="right">
            <html:submit property="submit" value="Submit"/>
          </td>
          <td align="left">
            <html:reset/>
          </td>
        </tr>
      </table>
    </html:form>
 </div>
  </body>