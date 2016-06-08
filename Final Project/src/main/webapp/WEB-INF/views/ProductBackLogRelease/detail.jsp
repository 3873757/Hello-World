<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>


	<div id="global">
			<fieldset>
				<legend><spring:message code="ReleaseBackLogDetail.legend"/></legend>
			  	<spring:message code="ReleaseBackLogDetail.number.label"/>${ReleaseBackLogDetail.releaseNumber} <br/>
			  	<spring:message code="ReleaseBackLogDetail.name.label"/>${ReleaseBackLogDetail.name} <br/>
			  	<spring:message code="ReleaseBackLogDetail.description.label"/>${ReleaseBackLogDetail.description} <br/>
			  	<spring:message code="ReleaseBackLogDetail.startDate.label"/>${ReleaseBackLogDetail.startDate} <br/>
			  	<spring:message code="ReleaseBackLogDetail.endDate.label" />${ReleaseBackLogDetail.endDate} <br/>
			  		<a href="<spring:url value='/ProductBackLogReleases/list' />"> <spring:message code="go.to.list"></spring:message></a>	  	
			  	
			</fieldset>
		</div>
	