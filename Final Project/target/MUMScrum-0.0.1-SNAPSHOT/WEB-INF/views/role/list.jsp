<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%-- <title><tiles:insertAttribute name="title" /></title> --%>
<title><spring:message code="role.list.title"></spring:message></title>
<style type="text/css">@import url("<spring:url value="/resource/css/bootstrap.min.css"/>");</style>
</head>
<body>     
	
		<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead"><spring:message code="role.list.legend"></spring:message></span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th><spring:message code="role.list.table.no"/></th>
				        <th><spring:message code="role.list.table.roleNumber"/></th>
				        <th><spring:message code="role.list.table.name"/></th>
				        <th><spring:message code="role.list.table.label"/></th>
				        <th><spring:message code="role.list.table.edit"/></th>
				        <th><spring:message code="role.list.table.delete"/></th>
	   		            <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${roles}" var="role" varStatus="count">
					<tr>
						<td>${count.index + 1}</td>
						<td>${role.roleNumber}</td>
						<td>${role.name}</td>
						<td>${role.label}</td>
						<td><a href="<spring:url  value="/roles/edit/${role.id}"/>" class="btn btn-success custom-width"><b><spring:message  code="role.list.table.edit"/></b></a></td>
						<td><a href="<spring:url  value="/roles/delete/${role.id}"/>" class="btn btn-danger custom-width"><b><spring:message code="role.list.table.delete"/></b></a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
		</div>
		</body>
		</html>