<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
    

		<div id="global">
			<fieldset>
				<legend><spring:message code="sprint.list.legend"/></legend>
			  	<table style="width:100%">
				  <tr>
				  	<td><b><spring:message code="sprint.table.no"/></b></td>
				  	<td><b><spring:message code="sprint.table.no"/></b></td>
				    <td><b><spring:message code="sprint.table.name"/></b></td>
				    <td><b><spring:message code="sprint.table.description"/></b></td> 
				    <td><b><spring:message code="sprint.table.createdDate"/></b></td>
				    <td><b><spring:message code="sprint.table.edit"/></b></td>
				    <td><b><spring:message code="sprint.list.table.assign"/></b></td>
				    <td><b><spring:message code="sprint.table.delete"/></b></td>
				  </tr>
				  <c:forEach items="${sprints}" var="sprint" varStatus="count">
			  		<tr>
						<td>${count.index + 1}</td>
						<td>${sprint.sprintNumber}</td>
						<td>${sprint.name}</td> 
						<td>${sprint.description}</td>
						<td>${sprint.createdDate}</td>
						<spring:url var="urlUpdate" value="/sprints/edit">
							<spring:param name="id" value="${sprint.id}"></spring:param>
						</spring:url>
						<td><a href="${urlUpdate}">Edit</a></td>
						
						
						<spring:url var="urlAssaign" value="/userStorys/lists/${sprint.id}">
							<spring:param name="sprintid" value="${sprint.id}"/>
						</spring:url>

						<td><a href="${urlAssaign}"><b><spring:message code="sprint.list.table.assign"/></b></a></td>
						
						
						
						<spring:url var="urlDelete" value="/sprints/delete">
							<spring:param name="id" value="${sprint.id}"></spring:param>
						</spring:url>
						<td><a href="${urlDelete}">Delete</a></td>
				  	</tr>
				  </c:forEach>
				</table>
			</fieldset>
		</div>
		
		
		
<!-- 		<div class="generic-container"> -->
<!-- 		<div class="panel panel-default"> -->
<!-- 			  Default panel contents -->
<%-- 		  	<div class="panel-heading"><span class="lead"><spring:message code="sprint.list.legend"></spring:message></span></div> --%>
<!-- 			<table class="table table-hover"> -->
<!-- 	    		<thead> -->
<!-- 		      		<tr> -->
<%-- 				        <th><spring:message code="sprint.table.no"/></th> --%>
<%-- 				        <th><spring:message code="sprint.table.number"/></th> --%>
<%-- 				        <th><spring:message code="sprint.table.name"/></th> --%>
<%-- 				        <th><spring:message code="sprint.table.description"/></th> --%>
<%-- 				        <th><spring:message code="sprint.table.edit"/></th> --%>
<%-- 				        <th><spring:message code="sprint.table.delete"/></th> --%>
<!-- 				        <th width="100"></th> -->
<!-- 				        <th width="100"></th> -->
<!-- 					</tr> -->
<!-- 		    	</thead> -->
<!-- 	    		<tbody> -->
<%-- 				<c:forEach items="${sprints}" var="sprint" varStatus="count"> --%>
<!-- 					<tr> -->
<%-- 						<td>${count.index + 1}</td> --%>
<%-- 						<td>${sprint.sprintNumber}</td> --%>
<%-- 						<td>${sprint.name}</td> --%>
<%-- 						<td>${sprint.description}</td>						 --%>

<%-- 						<td><a href="<spring:url  value="/sprints/edit/${sprint.id}"/>" class="btn btn-success custom-width"><b><spring:message  code="sprint.table.edit"/></b></a></td> --%>
						
<%-- 						<td><a href="<spring:url  value="/sprints/delete/${sprint.id}"/>" class="btn btn-danger custom-width"><b><spring:message code="sprint.table.delete"/></b></a></td> --%>
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>
<!-- 	    		</tbody> -->
<!-- 	    	</table> -->
<!-- 		</div> -->
<!-- 		</div> -->
<!-- 		</body> -->
<!-- 		</html> -->
	