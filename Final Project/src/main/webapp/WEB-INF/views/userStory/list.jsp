<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

		<div id="global">
			<fieldset>
				<legend><spring:message code="userStorys.List.legend"/></legend>
			  	<table style="width:100%">
				  <tr>
                    <td><b><spring:message code="userStorys.list.table.no"/></b></td> 
                    <td><b><spring:message code="userStorys.list.table.Id"/></b></td> 
                    <td><b><spring:message code="userStorys.list.table.userStoryNumber"/></b></td>
				    <td><b><spring:message code="userStorys.list.table.name"/></b></td> 
				    <td><b><spring:message code="userStorys.list.table.description"/></b></td>	
				    <td><b><spring:message code="userStorys.list.table.startDate"/></b></td> 
				   
				    
				    
				    
				    <td><b><spring:message code="userStorys.list.table.edit"/></b></td>
                                    
				 
				  </tr>
				  <c:forEach items="${userStory}" var="userStory" varStatus="count">
			  		<tr>
						<td>${count.index + 1}</td>
						<td>${userStory.id}</td>
	                 	<td>${userStory.userStoryNumber}</td> 
						<td>${userStory.name}</td> 
						<td>${userStory.description}</td>
						<td>${userStory.startDate}</td>
				
						<spring:url var="urlSprint" value="/userStorys/edit/${release.id}">
							
								<spring:param name="Releaseid" value="${release.id}"/>
								<spring:param name="id" value="${userStory.id}"/>
						</spring:url>
						<td><a href="${urlSprint}"><b><spring:message code="userStorys.list.table.sprint"/></b></a></td>
					
						
						<spring:url var="urlUpdate" value="/userStorys/edits/${sprint.id}">
							
								<spring:param name="sprintid" value="${sprint.id}"/>
								<spring:param name="id" value="${userStory.id}"/>
						</spring:url>
						
						<td><a href="${urlUpdate}"><b><spring:message code="userStorys.list.table.edit"/></b></a></td>
						
							
									  	</tr>
				  </c:forEach>
				</table>
			</fieldset>
		</div>


		
