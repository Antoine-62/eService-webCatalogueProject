<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html>
<body bgcolor="white">
<h1 class="titre">Votre profile</h1>
<div class="registration">
      <table border="0" align="center">
        <tr>
          <td align="right">
            Nom :
          </td>
          <td align="left">
            ${beanUser.getNom()}
          </td>
        </tr>
        <tr>
          <td align="right">
            Prénom :
          </td>
          <td align="left">
            ${beanUser.getPrenom()}
          </td>
        </tr>
        <tr>
          <td align="right">
            Email :
          </td>
          <td align="left">
            ${beanUser.getEmail()}
          </td>
        </tr>
        <tr>
          <td align="right">
            Téléphone :
          </td>
          <td align="left">
            ${beanUser.getTelephone()}
          </td>
        </tr>
      </table>
    </div>
    
    <h1 class="titre">Historique des commande</h1>
<c:set var="user" value="${beanCommandes}" />
<c:choose> 
	<c:when test="${empty beanCommandes}">
		<p>Vous n'avez encore rien commandé</p>	
	</c:when>
	<c:otherwise>
<c:forEach var="command" items="${beanCommandes}">
<div class="registration">
      <table border="0" align="center">
        <tr>
          <td align="right">
            Numéro de commande :
          </td>
          <td align="left">
            ${command.getNoConfirmation()}
          </td>
        </tr>
        <tr>
          <td align="right">
            Adresse de livraison : 
          </td>
          <td align="left">
            ${command.getAdresse()}, ${command.getCodepost()} ${command.getVille()} 
            ${command.getPays()}
          </td>
        </tr>
        <tr>
          <td align="right">
            Montant :
          </td>
          <td align="left">
            ${command.getMontant()}
          </td>
        </tr>
      </table>
    </div>
</c:forEach>
	</c:otherwise>
</c:choose>
  </body>