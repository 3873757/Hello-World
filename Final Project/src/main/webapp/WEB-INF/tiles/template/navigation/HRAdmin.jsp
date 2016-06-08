<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<li><a href="<spring:url value="/"/>"><spring:message code="home.page"></spring:message></a></li>
<li><a href="<spring:url value="/employees/create"/>"><spring:message code="employee.create.menu"></spring:message></a></li>
<li><a href="<spring:url value="/employees/list"/>"><spring:message code="employee.edit.menu"></spring:message></a></li>
<li><a href="<spring:url value="/employees/list"/>"><spring:message code="employee.list.menu"></spring:message></a></li>
<!--<li><a href="<spring:url value="#"/>"><spring:message code="projects"></spring:message></a></li>-->
<li><a href="<spring:url value="/proccessLogout"/>"><spring:message code="logout"></spring:message></a></li>