<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

	
<%-- 		<form action="<spring:url value="/processLogin"></spring:url>" method="post"> --%>
<!-- 			<fieldset> -->
<%-- 				<legend><spring:message code="login.legend"/></legend> --%>
<!-- 				<p> -->
<%-- 				  	<c:if test="${not empty error}"> --%>
<!-- 						<div style="color : red;"> -->
<%-- 							<spring:message code="login.invalid.authantication"/><br/> --%>
<!-- 						</div> -->
<%-- 					</c:if> --%>
<!-- 				</p> -->
<!-- 				<p> -->
<%-- 					<label for="username"><spring:message code="login.username.label"/></label> --%>
<!-- 					<input placeholder="User Name" name='username' type="text"/> -->
<!-- 				</p> -->
<!-- 				<p> -->
<%-- 					<label for="password"><spring:message code="login.password.label"/></label> --%>
<!-- 					<input placeholder="Password" name='password' type="password" value=""/> -->
<!-- 				</p> -->
<!-- 				<p> -->
<%-- 					<input type="submit" value="<spring:message code="login.submit.value"/>"/> --%>
<!-- 				</p> -->
<!-- 			</fieldset> -->
<!--             input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" / -->
<%-- 		</form> --%>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					 <div class="panel-heading">
						<h3 class="panel-title"><spring:message code="login.legend"/></h3>
					 </div>
					<div class="panel-body">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<spring:message code="login.invalid.authantication"/><br/><br />
							</div>
						</c:if>
						<spring:url var="actionUrl" value="/processLogin"></spring:url>
						<form action="${actionUrl}"  method="post">
							<fieldset>
							<div class="form-group" >
								<label for="username"><spring:message code="login.username.label"/></label>
								<input  name='username' type="text"/>
							 </div>
							<div class="form-group">
								<label for="password"><spring:message code="login.password.label"/></label>
								<input  name='password' type="password"/>
							</div>
							<div class="form-group">
								<input class="btn btn-lg btn-success btn-mini" type="submit" value="Login"/>
							</div>
<!-- 								<input class="btn btn-lg btn-success btn-block" type="submit" value="Login"/> -->
							</fieldset>
						</form>
						</div>
					</div>
				</div>
			</div>
		</div>
