<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



	<div class="generic-container">
		<div class="well lead">
			<spring:message code="role.create.legend" />
		</div>
		<form:form class="form-horizontal" modelAttribute="newRole" method="POST">
			<form:input type="hidden" path="id" id="id" />

	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="roleNumber"><spring:message
					code="role.create.roleNumber.label" /></label>
			<div class="col-md-7">
				<form:input type="text" path="roleNumber" id="roleNumber"
					class="form-control input-sm" />
				<div class="has-error">
					<form:errors path="roleNumber" class="help-inline" />
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="name"><spring:message
					code="role.create.name.label" /></label>
			<div class="col-md-7">
				<form:input type="text" path="name" id="name"
					class="form-control input-sm" />
				<div class="has-error">
					<form:errors path="name" class="help-inline" />
				</div>
			</div>
		</div>
	</div>
<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="label"><spring:message
					code="role.create.label.label" /></label>
			<div class="col-md-7">
				<form:input type="text" path="label" id="label"
					class="form-control input-sm" />
				<div class="has-error">
					<form:errors path="label" class="help-inline" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="form-actions floatRight">
			<input type="submit"
				value="<spring:message code="role.create.submit.value"/>" /> <a
				href="<c:url value='/roles/list' />"><input type="button" value="<spring:message
					code="role.create.cancel.value"></spring:message>"/></a>
		</div>
	</div>

	</form:form>
	</div>

