<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<div class="generic-container">
		<div class="panel panel-default">
		  	<div 
		  	   class="panel-heading"><span class="lead"><spring:message code="employee.list.legend"></spring:message></span>
		  	</div>
			<fieldset>
				<legend><spring:message code="employee.detail.legend"/></legend>
			  	<spring:message code="employee.detail.number.label"/>${employeeDetail.number} <br/>
			  	<spring:message code="employee.detail.firstName.label"/>${employeeDetail.firstName} <br/>
			  	<spring:message code="employee.detail.lastName.label"/>${employeeDetail.lastName} <br/>
			  	<spring:message code="employee.detail.dateOfBirth.label"/>${employeeDetail.dateOfBirth} <br/>
			  	<spring:message code="employee.detail.baseSalary.label"/>${employeeDetail.baseSalary} <br/>
			  	<spring:message code="employee.detail.email.label"/>${employeeDetail.email} <br/>
			  	<spring:message code="employee.detail.phone.label"/>${employeeDetail.phone} <br/>
			  	<spring:message code="employee.detail.street.label"/>${employeeDetail.address.street} <br/>
			  	<spring:message code="employee.detail.city.label"/>${employeeDetail.address.city} <br/>
			  	<spring:message code="employee.detail.state.label"/>${employeeDetail.address.state} <br/>
			  	<spring:message code="employee.detail.zipCode.label"/>${employeeDetail.address.zipCode} <br/>
			  	<spring:message code="employee.detail.username.label"/>${employeeDetail.user.username} <br/>
			  	
			  	<a href="<spring:url value='/employees/create'/>">
			  		<input type = "button" value ="<spring:message code="employee.detail.submit.value"/>"/>
			  	</a>
			</fieldset>
	    </div>
	</div>
	
	
	
