<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead"><spring:message code="employee.list.legend"></spring:message></span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th><spring:message code="employee.list.table.no"/></th>
				        <th><spring:message code="employee.list.table.number"/></th>
				        <th><spring:message code="employee.list.table.name"/></th>
				        <th><spring:message code="employee.list.table.email"/></th>
				        <th><spring:message code="employee.list.table.phone"/></th>
				        <th><spring:message code="employee.list.table.assign.role"/></th>
				        <th><spring:message code="employee.list.table.edit"/></th>
				        <th><spring:message code="employee.list.table.delete"/></th>
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${employees}" var="employee" varStatus="count">
					<tr>
						<td>${count.index + 1}</td>
						<td>${employee.number}</td>
						<td>${employee.firstName} ${employee.lastName}</td>
						<td>${employee.email}</td>
						<td>${employee.phone}</td>
						<td><a href="<spring:url  value="/employees/assignRole/${employee.id}"/>" class="btn btn-primary custom-width"><b><spring:message  code="employee.list.table.assign.role"/></b></a></td>
						<td><a href="<spring:url  value="/employees/edit/${employee.id}"/>" class="btn btn-success custom-width"><b><spring:message  code="employee.list.table.edit"/></b></a></td>
						<td><a href="<spring:url  value="/employees/delete/${employee.id}"/>" class="btn btn-danger custom-width"><b><spring:message code="employee.list.table.delete"/></b></a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
   	</div>
		