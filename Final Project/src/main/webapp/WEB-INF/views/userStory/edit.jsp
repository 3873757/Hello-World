

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

		<div id="global">
			<form:form modelAttribute="edituserStorys" method="post">
				<fieldset>
					<legend><spring:message code="userStory.create.legend"/></legend>
	  	        	<!-- p>
        				<form:errors path="*" cssStyle="color: red;"/>
        			</p -->
        			
        				
        			
					<div>
						<p>
				  			<label for = "userStoryNumber"><spring:message code="userstory.create.userStoryNumber.label"/></label>
							<form:input path="userStoryNumber" value="${userStoryNumber}"/>
							<form:errors path="userStoryNumber" cssStyle="color: red;"/>
						</p>
					</div>
				  	
					<div>
					  	<p>
				  			<label for = "name"><spring:message code="userStory.create.name.label"/></label>
						
								<form:input path="name" value="${name}"/>
							<form:errors path="name"  cssStyle="color: red;"/>
						</p>
					</div>
	
					<div>
					  	<p>
				  			<label for = "description"><spring:message code="description.create.description.label"/></label>
							
								<form:input path="description" value="${description}"/>
							<form:errors path="description" cssStyle="color: red;"/>
						</p>
					</div>
	
					<div>
					  	<p>
				  			<label for = "initialTestEffort"><spring:message code="initialTestEffort.create.initialTestEffort.label"/></label>
							<form:input path="initialTestEffort" value="${initialTestEffort}"/>
							<form:errors path="initialTestEffort" cssStyle="color: red;"/>
						</p>
					</div>
	
					<div>
					  	<p>
				  			<label for = "initialDevelopmentEffort"><spring:message code="initialDevelopmentEffort.create.initialDevelopmentEffort.label"/></label>
							
							<form:input path="initialDevelopmentEffort" value="${initialDevelopmentEffort}"/>
							<form:errors path="initialDevelopmentEffort" cssStyle="color: red;"/>
						</p>
					</div>
	
					<div>
					  	<p>
				  			<label for = "currentTestEffort"><spring:message code="currentTestEffort.create.currentTestEffort.label"/></label>
						
										<form:input path="currentTestEffort" value="${currentTestEffort}"/>
							<form:errors path="currentTestEffort" cssStyle="color: red;"/>
						</p>
					</div>
	
					<div>
					  	<p>
				  			<label for = "currentDevelopmentEffort"><spring:message code="currentDevelopmentEffort.create.currentDevelopmentEffort.label"/></label>
			
							<form:input path="currentDevelopmentEffort" value="${currentDevelopmentEffort}"/>
							<form:errors path="currentDevelopmentEffort" cssStyle="color: red;"/>
						</p>
					</div>

					<div>
					  	<p>
				  			<label for = "createdDate"><spring:message code="createdDate.create.createdDate.label"/></label>
							
							<form:input path="createdDate" value="${createdDate}"/>
							<form:errors path="createdDate" cssStyle="color: red;"/>
						</p>
					</div>

					<div>
					  	<p>
				  			<label for = "startDate"><spring:message code="startDate.create.startDate.label"/></label>
							
							<form:input path="startDate" value="${startDate}"/>
							<form:errors path="startDate" cssStyle="color: red;"/>
						</p>
					</div>

					<div>
					  	<p>
				  			<label for = "dueDate"><spring:message code="dueDate.create.dueDate.label"/></label>
					
							<form:input path="dueDate" value="${dueDate}"/>
							<form:errors path="dueDate" cssStyle="color: red;"/>
						</p>
					</div>


<div>
					  	<p>
				  			<label for = "id"><spring:message code="dueDate.create.dueDate.label"/></label>
					
							<form:input path="id" value="${id}"/>
							<form:errors path="id" cssStyle="color: red;"/>
						</p>
					</div>
					
					
					
									  	
					<div id="button">
					  	<p>
							<input type="submit" value="<spring:message code="userStory.create.submit.value"/>"/>
							<a href='<spring:url value="/"/>'>Home</a>
						</p>
					</div>
				</fieldset>
			</form:form>
		</div>
