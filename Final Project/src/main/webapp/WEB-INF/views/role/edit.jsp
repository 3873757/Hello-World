<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="role.create.title" /></title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<style type="text/css">
@import url("<spring:url value="/resource/css/bootstrap.min.css"/>");
</style>
<link href="<c:url value='/resource/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='resource/css/app.css' />" rel="stylesheet"></link>
</head>


	<div class="generic-container">
		<div class="well lead">
			<spring:message code="role.edit.legend" />
		</div>
		<form:form class="form-horizontal" modelAttribute="editRole"  method="POST">
			<form:input type="hidden" path="id" id="id" />

	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="roleNumber"><spring:message
					code="role.create.roleNumber.label" /></label>
			<div class="col-md-7">
				<form:input type="text" value="${editRole.roleNumber}" path="roleNumber" id="roleNumber"
					class="form-control input-sm" />
				<div class="has-error">
					<form:errors path="roleNumber"  class="help-inline" />
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="name"><spring:message
					code="role.create.name.label" /></label>
			<div class="col-md-7">
				<form:input type="text"  value="${editRole.name}" path="name" id="name"
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
				<form:input type="text" value="${editRole.label}" path="label" id="label"
					class="form-control input-sm" />
				<div class="has-error">
					<form:errors path="label"  class="help-inline" />
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="form-actions floatRight">
			<input type="submit"
				value="<spring:message code="role.edit.submit.value"/>" /> <a
				href="<c:url value='/roles/list' />"><input type="button" value="<spring:message
					code="role.edit.cancel.value"></spring:message>"/></a>
					
		</div>
	</div>

	</form:form>
	</div>
</body>
</html>
