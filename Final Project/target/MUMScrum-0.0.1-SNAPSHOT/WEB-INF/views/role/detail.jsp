<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Confirmation Page</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<div class="generic-container">
	<div class="alert alert-success lead">
    	The ${roleDetail.name} is successfully created.
	</div>
			<fieldset>
				<legend><spring:message code="role.detail.legend"/></legend>
			  	<spring:message code="role.detail.roleNumber.label"/>${roleDetail.roleNumber} <br/>
			  	<spring:message code="role.detail.name.label"/>${roleDetail.name} <br/>
			  	<spring:message code="role.detail.label.label"/>${roleDetail.label} <br/><span class="well floatRight">
		<a href="<spring:url value='/roles/list' />"> <spring:message code="go.to"></spring:message><spring:message code="role.list"></spring:message></a>
	</span>
</fieldset>
		
</div>
