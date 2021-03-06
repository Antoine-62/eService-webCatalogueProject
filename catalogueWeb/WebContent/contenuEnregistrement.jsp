<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html>
<body bgcolor="white">
<h1 class="titre">Rejoignez notre club de patate!</h1>
<div class="registration">
    <html:form action="validerEnregistrement">
      <table border="0" align="center">
        <tr>
          <td align="right">
            Nom :
          </td>
          <td align="left">
            <html:text property="nom" size="40" maxlength="40"/>
          </td>
        </tr>
        <tr>
          <td align="right">
            Pr�nom :
          </td>
          <td align="left">
            <html:text property="prenom" size="40" maxlength="40"/>
          </td>
        </tr>
        <tr>
          <td align="right">
            Email :
          </td>
          <td align="left">
            <html:text property="email" size="40" maxlength="40"/>
          </td>
        </tr>
        <tr>
          <td align="right">
            T�l�phone :
          </td>
          <td align="left">
            <html:text property="phone" size="40" maxlength="40"/>
          </td>
        </tr>
        <tr>
          <td align="right">
            Mot de passe :
          </td>
          <td align="left">
            <html:text property="password" size="40" maxlength="40"/>
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