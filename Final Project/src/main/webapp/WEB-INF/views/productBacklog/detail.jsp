<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

	<div id="global">
			<fieldset>
				<legend><spring:message code="productBacklogDetail.legend"/></legend>
			  	<spring:message code="productBacklogDetail.productId.label"/>${productBacklogDetail.productId} <br/>
			  	<spring:message code="productBacklogDetail.name.label"/>${productBacklogDetail.name} <br/>
			  	<spring:message code="productBacklogDetail.description.label"/>${productBacklogDetail.description} <br/>
			  	<spring:message code="productBacklogDetail.datecreated.label"/>${productBacklogDetail.dateCreated} <br/>
	
			  	<a href='<spring:url value="/ReleaseBacklogs/list"/>'>Go to product Backlog List</a>
			</fieldset>
		</div>
	