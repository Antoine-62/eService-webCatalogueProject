<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html>
<body bgcolor="white">
<h1 class="titre">Valiser votre commande</h1>
<div class="login">
    <html:form action="validerLogin">
      <table border="0" align="center">
        <tr>
          <td align="right">
            Email :
          </td>
          <td align="left">
            <html:text property="email" size="20" maxlength="20"/>
            <td style="color:red;"><html:errors  property="email"/></td>
          </td>
        </tr>
          <td align="right">
            Mot de passe :
          </td>
          <td align="left">
            <html:text property="password" size="20" maxlength="20"/>
            <td style="color:red;"><html:errors  property="password"/></td>
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