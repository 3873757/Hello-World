


<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

		<div id="global">
			<form:form modelAttribute="editProductBackLog"  method="post">
				<fieldset>
					<legend><spring:message code="ProductBackLog.edit.legend"/></legend>
	  	        	<p>
        				<form:errors path="*" cssStyle="color: red;"/>
        			</p>
				  	<div>
					  	<p>
				  			<label for = "productId"><spring:message code="ProductBackLog.edit.productId.label"/></label>
						<form:input path="productId" value="${productId}" />
					
						</p>
					</div>
					<div>
					  	<p>
				  			<label for = "name"><spring:message code="ProductBackLog.edit.name.label"/></label>
							<form:input path="name"  value="${name}"/>
							<form:errors path="name"  cssStyle="color: red;"/>
						</p>
					</div>
					<div>
					  	<p>
				  			<label for = "description"><spring:message code="ProductBackLog.edit.description.label"/></label>
							<form:textarea path="description"  value="${description}" rows="5" cols="30"/>
							<form:errors path="description" cssStyle="color: red;"/>
						</p>
					</div>
	
					<div>
					  	<p>
				  			<label for = "dateCreated"><spring:message code="ProductBackLog.edit.dateCreated.label"/></label>
							<form:input path="dateCreated"  value="${dateCreated}" />
							<form:errors path="dateCreated" cssStyle="color: red;"/>
						</p>
					</div>
				
					
					
					<div>
					  	<p>
							<input type="submit" value="<spring:message code="ProductBackLog.edit.submit.value"/>"/>
						</p>
					</div>
					
				</fieldset>
			</form:form>
		</div>
	