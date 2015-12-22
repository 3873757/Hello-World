<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

		<div id="global">
			<fieldset>
				<legend><spring:message code="productbacklogrelease.List.legend"/></legend>
			  	<table style="width:100%">
				  <tr>
				  	<td><b><spring:message code="ProductBackLogRelease.list.table.no"/></b></td>
                    <td><b><spring:message code="productbacklogrelease.list.table.releaseNumber"/></b></td>
				    <td><b><spring:message code="productbacklogrelease.list.table.name"/></b></td> 
				    <td><b><spring:message code="productbacklogrelease.list.table.description"/></b></td>	
				    <td><b><spring:message code="productbacklogrelease.list.table.startDate"/></b></td> 
				    <td><b><spring:message code="productbacklogrelease.list.table.endDate"/></b></td>			  
				    		  
				    <td><b><spring:message code="productbacklogrelease.list.table.edit"/></b></td>
				    <td><b><spring:message code="productbacklogrelease.list.table.Assaign"/></b></td>
				    <td><b><spring:message code="productbacklogrelease.list.table.delete"/></b></td>
				  </tr>
				  <c:forEach items="${productbacklogreleases}" var="productbacklogrelease" varStatus="count">
			  		<tr>
						<td>${count.index + 1}</td>
	                 	<td>${productbacklogrelease.releaseNumber}</td> 
						<td>${productbacklogrelease.name}</td> 
						<td>${productbacklogrelease.description}</td>
						<td>${productbacklogrelease.startDate}</td> 
						<td>${productbacklogrelease.endDate}</td>
						<spring:url var="urlUpdate" value="/ProductBackLogReleases/edit">
							<spring:param name="id" value="${productbacklogrelease.id}"/>
						</spring:url>
						
						<td><a href="${urlUpdate}"><b><spring:message code="ProductBackLogRelease.list.table.edit"/></b></a></td>
						
							<spring:url var="urlAssaign" value="/userStorys/list/${productbacklogrelease.id}">
							<spring:param name="releaseid" value="${productbacklogrelease.id}"/>
						</spring:url>
						
						
						
						<td><a href="${urlAssaign}"><b><spring:message code="ProductBackLogRelease.list.table.Assaign"/></b></a></td>
						
						<!-- spring:url var="urlDelete" value="/employees/delete/${employee.id}"/ -->
						<td><a href="#" onClick="deleteItemById(${productbacklogrelease.id});"><b><spring:message code="ProductBackLogRelease.list.table.delete"/></b></a></td>
	
										  	</tr>
				  </c:forEach>
				</table>
			</fieldset>
		</div>
	