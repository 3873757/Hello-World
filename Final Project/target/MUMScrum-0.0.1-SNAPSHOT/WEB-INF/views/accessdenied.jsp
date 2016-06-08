<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

	
	
	
		<div class="generic-container">
	<div class="alert alert-warning lead">
	<h3>    
	   <spring:message code="accessdenied.message"></spring:message>
   </h3>
   </div>
	<span class="well floatRight">
		 <a href="<spring:url value="/login"/>"><spring:message code="home.page"></spring:message></a>
	</span>
</div>
	
