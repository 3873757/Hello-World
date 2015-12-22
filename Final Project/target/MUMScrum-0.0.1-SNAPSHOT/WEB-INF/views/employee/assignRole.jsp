<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<div class="generic-container">
		<div class="well lead">
			<spring:message code="Assigning.role.to"></spring:message> ${empRole.employee.firstName} ${empRole.employee.lastName} 
			<br/><spring:message code="existing.roles"></spring:message>
			<c:forEach var="role" items="${userRoles}" >
			  <div>
			  	${role.label}	<br/>
			  </div> 
			</c:forEach>
		</div>
		<form:form class="form-horizontal" modelAttribute="empRole" method="POST">
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="role.id"></label>
					<div class="col-md-7">
						<form:select name="role" path="role.id">
							<form:option value="0">--Select Role-- </form:option>
							<form:options items="${roles}" itemLabel="label" itemValue="id" />
						</form:select>
						<div class="has-error">
					<form:errors path="role.id" class="help-inline" />
				</div>
					</div>
				</div>
			</div>

	<div class="row">
		<div class="form-group col-md-12">
<%-- 			<label class="col-md-3 control-lable" for="employee.id"><spring:message --%>
<%-- 					code="sprint.create.sprintNumber.label" /></label> --%>
			<div class="col-md-7">
				<form:hidden  path="employee.id" value="${empRole.employee.id}"
					class="form-control input-sm" />
				<div class="has-error">
					<form:errors path="employee.id" class="help-inline" />
				</div>
			</div>
		</div>
	</div>


	<div class="row">
		<div class="form-actions floatRight">
			<a><input type="submit"
				value="<spring:message code="assign.role.submit.value"/>" /></a>
			<a href="<spring:url value='/employees/list' />"><input type="button" value = "<spring:message
					code="assign.role.cancel.value"></spring:message>"/></a>
			</div>
	</div>

	</form:form>
	</div>