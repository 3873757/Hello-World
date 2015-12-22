<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<%-- 				<h1> ${greeting} </h1> --%>
				<%-- 				<p> ${tagline} </p> --%>

				<security:authorize access="!isAuthenticated()">
					<img
						src="<spring:url value="/resource/images/mumimage3.jpg"  htmlEscape="true" />"
						alt="Picture not found!!!" />
						
						<img
						src="<spring:url value="/resource/images/mumimage2.jpg"  htmlEscape="true" />"
						alt="Picture not found!!!" />
						<img
						src="<spring:url value="/resource/images/mumimage6.jpg"  htmlEscape="true" />"
						alt="Picture not found!!!" />

					<img
						src="<spring:url value="/resource/images/mumimage4.jpg"  htmlEscape="true" />"
						alt="Picture not found!!!" />

					<h1 class = ".h1">Welcome to Spring Coders' MUMScrum Tool!!</h1>
					<h3 class = ".h3">This is a tool for managing an Agile/Scrum Project and its human resource.</h3>

					<a href="<spring:url value='/login' />"
						class="btn btn-lg btn-success btn-mini"> Login</a>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
  				<h3 class = ".h3">	Welcome:  <security:authentication property="principal.username" /> </h3>

					<a href="<spring:url value='/doLogout'/>"
						class="btn btn-default pull-right">Logout</a>
				</security:authorize>

			</div>



			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="<spring:url value="/employees/create"/>">Create
						Employe Record</a></li>
				<li><a href="<spring:url value="/employees/list"/>">Employees
						list</a></li>

				<%-- 				<li><a href="<spring:url value='/employees' />" class="btn btn-default"> --%>
				<!-- 					<span class="glyphicon-hand-left glyphicon"></span> Go to list -->
				<!-- 				</a></li> -->
			</security:authorize>


			<security:authorize access="hasRole('ROLE_DEV')">
				<li><a href="<spring:url value="/vendor/"/>">Estimate
						Development Effort</a></li>
				<li><a href="<spring:url value="/vendor/"/>">Update
						Development Effort</a></li>
			</security:authorize>


			<security:authorize access="hasRole('ROLE_TESTER')">
				<li><a href="<spring:url value="/vendor/"/>">Estimate Test
						Effort</a></li>
				<li><a href="<spring:url value="/vendor/"/>">Update Test
						Effort</a></li>
			</security:authorize>


			<security:authorize access="hasRole('ROLE_SM')">
				<li><a href="<spring:url value="/vendor/"/>">Create Sprint</a></li>
				<li><a href="<spring:url value="/vendor/"/>">Update Sprint</a></li>
				<li><a href="<spring:url value="/vendor/"/>">Read Sprint</a></li>
				<li><a href="<spring:url value="/vendor/"/>">view Sprint</a></li>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_PO')">
				<li><a href="<spring:url value="/addProductBL"/>">Create
						Product Backlog</a></li>
				<li><a href="<spring:url value="/addReleaseBL"/>">Create
						Release Backlog</a></li>
				<li><a href="<spring:url value="/addUserStory"/>">Create
						User Story</a></li>

				<li><a href="<spring:url value="/products"/>">List Product
						Backlog</a></li>
				<li><a href="<spring:url value="/releases"/>">List Release
						Backlog</a></li>
				<li><a href="<spring:url value="/vendor/"/>">Assign Scrum
						Master to Release Backlog</a></li>

			</security:authorize>






			<div class="container">
				<security:authorize access="isAnonymous()">
					<!-- WHICH ONE? depends on basic form OR CUSTOM -->
					<!--a href="<spring:url value='/spring_security_login' />" class="btn btn-default pull-right"> Login</a-->
					<%-- 					<a href="<spring:url value='/login' />" --%>
					<!-- 						class="btn btn-default pull-right"> Login</a> -->
				</security:authorize>

				<%-- 				<a href="<spring:url value='/employees' />" class="btn btn-default"> --%>
				<!-- 					<span class="glyphicon-hand-left glyphicon"></span> Go to list -->
				<!-- 				</a> -->
			</div>
			<%-- 	 			<div class="pull-left"> <h3>${SpecialBlurb}</h3> </div> --%>
		</div>
	</section>

</body>
</html>