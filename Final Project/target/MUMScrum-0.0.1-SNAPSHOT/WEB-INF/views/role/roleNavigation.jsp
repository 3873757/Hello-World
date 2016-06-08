
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<li><a href="<spring:url value="/employees/list"/>"><spring:message code="home.page"></spring:message></a></li>
<li><a href="<spring:url value="/roles/create"/>"><spring:message code="role.add.new.role"></spring:message></a></li>
<%-- <li><a href="<spring:url value="/roles/edit"/>"><spring:message code="role.edit"></spring:message></a></li> --%>
<li><a href="<spring:url value="/roles/list"/>"><spring:message code="role.list.roles"></spring:message></a></li>
<li><a href="<spring:url value="/employees/"/>"><spring:message code="role.employee.page"></spring:message></a></li>
<li><a href="<spring:url value="/proccessLogout"/>"><spring:message code="logout"></spring:message></a></li>