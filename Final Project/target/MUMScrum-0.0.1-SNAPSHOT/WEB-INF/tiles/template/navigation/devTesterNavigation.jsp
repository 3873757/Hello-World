<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<li><a href="<spring:url value="/"/>"><spring:message code="home.page"></spring:message></a></li>
<li><a href="<spring:url value="/sprints/create"/>"><spring:message code="sprint.create.menu"></spring:message></a></li>
<li><a href="<spring:url value="/sprints/list"/>"><spring:message code="sprint.edit.menu"></spring:message></a></li>
<li><a href="<spring:url value="/sprints/list"/>"><spring:message code="sprint.list.menu"></spring:message></a></li>
<li><a href="<spring:url value="/userStorys/"/>"><spring:message code="user.story.menu"></spring:message></a></li>
<!--<li><a href="<spring:url value="#"/>"><spring:message code="projects"></spring:message></a></li>-->
<li><a href="<spring:url value="/proccessLogout"/>"><spring:message code="logout"></spring:message></a></li>