


<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<style type="text/css">@import url("<spring:url value="/resource/css/main.css"/>");</style>
		<title><spring:message code="sprint.edit.title"/></title>
	</head>
	<body>
		<div id="global">
			<form:form modelAttribute="editProductBackLogRelease"  method="post">
				<fieldset>
					<legend><spring:message code="ProductBackLogRelease.edit.legend"/></legend>
	  	        	<p>
        				<form:errors path="*" cssStyle="color: red;"/>
        			</p>
				  	<div>
					  	<p>
				  			<label for = "releaseNumber"><spring:message code="ProductBackLogRelease.edit.releaseNumber.label"/></label>
						<form:input path="releaseNumber" value="${releaseNumber}" />
					
						
												</p>
					</div>
					<div>
					  	<p>
				  			<label for = "name"><spring:message code="ProductBackLogRelease.edit.name.label"/></label>
							<form:input path="name"  value="${name}"/>
							<form:errors path="name"  cssStyle="color: red;"/>
						</p>
					</div>
					<div>
					  	<p>
				  			<label for = "description"><spring:message code="ProductBackLogRelease.edit.description.label"/></label>
							<form:textarea path="description"  value="${description}" rows="5" cols="30"/>
							<form:errors path="description" cssStyle="color: red;"/>
						</p>
					</div>
	
					<div>
					  	<p>
				  			<label for = "startDate"><spring:message code="ProductBackLogRelease.edit.startDate.label"/></label>
							<form:input path="startDate"  value="${startDate}" />
							<form:errors path="startDate" cssStyle="color: red;"/>
						</p>
					</div>
						<div>
					  	<p>
				  			<label for = "endDate"><spring:message code="ProductBackLogRelease.edit.endDate.label"/></label>
							<form:input path="endDate"  value="${endDate}" />
							<form:errors path="endDate" cssStyle="color: red;"/>
						</p>
					</div>
					
					
					<div>
					  	<p>
							<input type="submit" value="<spring:message code="ProductBackLogRelease.edit.submit.value"/>"/>
							<a href='<spring:url value="/"/>'>Home</a>
						</p>
					</div>
					
				</fieldset>
			</form:form>
		</div>
	</body>
</html>