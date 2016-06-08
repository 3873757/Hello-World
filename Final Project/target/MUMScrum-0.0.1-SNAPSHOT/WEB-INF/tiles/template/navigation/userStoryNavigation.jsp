<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<li><a href="<spring:url value="/"/>"><spring:message code="home.page"></spring:message></a></li>
<li><a href="<spring:url value="/userStorys/create"/>"><spring:message code="userStory.create.menu"></spring:message></a></li>
<li><a href="<spring:url value="/userStorys/list"/>"><spring:message code="userStory.edit.menu"></spring:message></a></li>
<li><a href="<spring:url value="/userStorys/list"/>"><spring:message code="userStory.list.menu"></spring:message></a></li>
<li><a href="<spring:url value="/sprints/"/>"><spring:message code="sprint.menu"></spring:message></a></li>
<!--<li><a href="<spring:url value="#"/>"><spring:message code="projects"></spring:message></a></li>-->
<li><a href="<spring:url value="/proccessLogout"/>"><spring:message code="logout"></spring:message></a></li>