<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

			
			<h1><spring:message code="welcome"/> ${username} <spring:message code="welcome.to.role.page"/></h1>
			
			<p><spring:message code="role.available.roles"></spring:message></p>
			
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
			