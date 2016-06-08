<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<li><a href="<spring:url value="/"/>"><spring:message code="home.page"></spring:message></a></li>
<li><a href="<spring:url value="/ProductBackLogReleases/"/>"><spring:message code="product.backlogs.releases.menu"></spring:message></a></li>
<li><a href="<spring:url value="/sprints/"/>"><spring:message code="product.backlogs.sprints.menu"></spring:message></a></li>
<li><a href="<spring:url value="/userStorys/"/>"><spring:message code="user.story.menu"></spring:message></a></li>
<!--<li><a href="<spring:url value="#"/>"><spring:message code="projects"></spring:message></a></li>-->
<li><a href="<spring:url value="/proccessLogout"/>"><spring:message code="logout"></spring:message></a></li>