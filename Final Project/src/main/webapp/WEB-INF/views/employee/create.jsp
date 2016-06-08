
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<div class="generic-container">
	<div class="well lead"><spring:message code="employee.create.legend"/></div>
 	<form:form method="POST" modelAttribute="newEmployee" class="form-horizontal">
		<form:input type="hidden" path="id" id="id"/>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="number"><spring:message code="employee.create.number.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="number" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="number" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="firstName"><spring:message code="employee.create.firstName.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="firstName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="firstName" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
		
        <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="lastName"><spring:message code="employee.create.lastName.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="lastName"  class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="lastName" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
		
        <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="dateOfBirth"><spring:message code="employee.create.dateOfBirth.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="dateOfBirth" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="dateOfBirth" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
		
		        <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="baseSalary"><spring:message code="employee.create.baseSalary.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="baseSalary"  class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="baseSalary" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
		
        <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="email"><spring:message code="employee.create.email.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="email"  class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="email" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
      
        <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="phone"><spring:message code="employee.create.phone.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="phone"  class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="phone" cssStyle="color:red"  class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
					

		<p><strong><spring:message code="employee.create.address.label"/></strong></p>

           <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="address.street"><spring:message code="employee.create.street.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="address.street"  class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="address.street" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>        
         
         <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="address.city"><spring:message code="employee.create.city.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="address.city"  class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="address.city" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
			
	 <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="address.state"><spring:message code="employee.create.state.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="address.state"  class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="address.state" cssStyle="color:red"  class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>
	
	   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="address.zipCode"><spring:message code="employee.create.zipCode.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="address.zipCode" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="address.zipCode" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>


<p><strong><spring:message code="employee.create.user.label"/></strong></p>

           <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="user.username"><spring:message code="employee.create.username.label"/></label>
				<div class="col-md-7">
					<form:input type="text" path="user.username"  class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="user.username" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>        
         
         <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="user.password"><spring:message code="employee.create.password.label"/></label>
				<div class="col-md-7">
					<form:input type="password" path="user.password"  class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="user.password" cssStyle="color:red" class="help-inline"/>
					</div>
				</div>
		      </div>
			</div>

      <div class="row">
		<div class="form-actions floatRight">
			<a><input type="submit"
				value="<spring:message code="employee.create.submit.value"/>" /></a>
				 <a href="<spring:url value='/list' />"><input type="button" value = "<spring:message
					code="employee.create.cancel.value"></spring:message>"/></a>
		</div>
	</div>
	</form:form>
	</div>

	