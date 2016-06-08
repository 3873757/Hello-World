<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<div class="generic-container">
	<div class="well lead"><spring:message code="employee.edit.legend"/></div>
 	<form:form method="POST" modelAttribute="editEmployee" class="form-horizontal">
		<form:input type="hidden" path="id" id="id"/>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="number"><spring:message code="employee.edit.number.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="number" value="${number}" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="number" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="firstName"><spring:message code="employee.edit.firstName.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="firstName" value="${firstName}" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="firstName" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
		
        <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="lastName"><spring:message code="employee.edit.lastName.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="lastName" value="${lastName}" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="lastName" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
		
        <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="dateOfBirth"><spring:message code="employee.edit.dateOfBirth.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="dateOfBirth" value="${dateOfBirth}" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="dateOfBirth" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
		
		        <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="baseSalary"><spring:message code="employee.edit.baseSalary.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="baseSalary" value="${baseSalary}" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="baseSalary" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
		
        <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="email"><spring:message code="employee.edit.email.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="email" value="${email}" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="email" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
      
        <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="phone"><spring:message code="employee.edit.phone.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="phone" value="${phone}" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="phone" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
					

		<p><strong><spring:message code="employee.edit.address.label"/></strong></p>

           <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="address.street"><spring:message code="employee.edit.street.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="address.street" value="${address.street}" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="address.street" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>        
         
         <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="address.city"><spring:message code="employee.edit.city.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="address.city" value="${address.city}" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="address.city" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
	
	<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="address.state"><spring:message code="employee.edit.state.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="address.state" value="${address.state}" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="address.state" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
			
	   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="address.zipCode"><spring:message code="employee.edit.zipCode.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="address.zipCode" value="${address.zipCode}" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="address.zipCode" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>

      <div class="row">
		<div class="form-actions floatRight">
			<a><input type="submit"
				value="<spring:message code="employee.edit.submit.value"/>" /></a>
				 <a href="<spring:url value='/employees/list' />"><input type="button" value = "<spring:message
					code="employee.edit.cancel.value"></spring:message>"/></a>
		</div>
	</div>
	</form:form>
	</div>
		