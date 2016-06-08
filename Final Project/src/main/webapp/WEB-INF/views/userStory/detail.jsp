<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

	<div id="global">
			<fieldset>
				<legend><spring:message code="userStoryDetail.legend"/></legend>
			  	<spring:message code="userStoryDetail.userStoryNumber.label"/>${userStoryDetail.userStoryNumber} <br/>
			  	<spring:message code="userStoryDetail.name.label"/>${userStoryDetail.name} <br/>
			  	<spring:message code="userStoryDetail.description.label"/>${userStoryDetail.description} <br/>
			  	<spring:message code="userStoryDetail.startDate.label"/>${userStoryDetail.startDate} <br/>
		
			  			  	<form action='<spring:url value="/create"/>'>
			  		
			  	<a href="<spring:url value='/userStorys/list' />"> <spring:message code="go.to.list"></spring:message></a>
			  	</form>
			  	
			  	
			</fieldset>
		</div>
	