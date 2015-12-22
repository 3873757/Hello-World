<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
		
		<div id="global">
			<fieldset>
				<legend><spring:message code="ProductBackLog.List.legend"/></legend>
			  	<table style="width:100%">
				  <tr>
				  	<td><b><spring:message code="ProductBackLog.list.table.no"/></b></td>
                    <td><b><spring:message code="ProductBackLog.list.table.producId"/></b></td>
				    <td><b><spring:message code="ProductBackLog.list.table.name"/></b></td> 
				    <td><b><spring:message code="ProductBackLog.list.table.description"/></b></td>	
				    <td><b><spring:message code="ProductBackLog.list.table.dateCreated"/></b></td> 
				    		  
				    <td><b><spring:message code="ProductBackLog.list.table.edit"/></b></td>
				    <td><b><spring:message code="ProductBackLog.list.table.delete"/></b></td>
				  </tr>
				  <c:forEach items="${ReleaseBacklogs}" var="ReleaseBacklogs" varStatus="count">
			  		<tr>
						<td>${count.index + 1}</td>
	                 	<td>${ReleaseBacklogs.productId}</td> 
						<td>${ReleaseBacklogs.name}</td> 
						<td>${ReleaseBacklogs.description}</td>
						<td>${ReleaseBacklogs.dateCreated}</td> 
					
						<spring:url var="urlUpdate" value="/ReleaseBacklogs/edit">
							<spring:param name="id" value="${ReleaseBacklogs.id}"/>
						</spring:url>
						<td><a href="${urlUpdate}"><b><spring:message code="ProductBackLog.list.table.edit"/></b></a></td>
						<!-- spring:url var="urlDelete" value="/employees/delete/${employee.id}"/ -->
						<td><a href="#" onClick="deleteItemById(${ReleaseBacklogs.id});"><b><spring:message code="ProductBackLog.list.table.delete"/></b></a></td>
	
						</tr>
				  </c:forEach>
				</table>
			</fieldset>
		</div>
	


