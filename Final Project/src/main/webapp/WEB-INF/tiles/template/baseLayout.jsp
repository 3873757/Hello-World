<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%-- <title><tiles:insertAttribute name="title" /></title> --%>
<tiles:importAttribute name="title" />
<title><spring:message code="${title}"></spring:message></title>
<style type="text/css">@import url("<spring:url value="/resource/css/main.css"/>");</style>
<style type="text/css">@import url("<spring:url value="/resource/css/bootstrap.min.css"/>");</style>
</head>
<body>     
<div id="wrapper">  
       <div id="header">
       			
				<tiles:insertAttribute name="header" />			
       </div>
		
		<div >
			<ul id="navigation" class="nav nav-pills pull-center">
				<tiles:insertAttribute name="navigation" />
			</ul>
		</div>


		<!--div class="jumbotron">
			
			<h1>
			
				<tiles:insertAttribute name="heading" />
			</h1>
			<p>
				<tiles:insertAttribute name="tagline" />
			</p>
		</div>
		<div>
			
		</div-->

		<div  id="content">
			<tiles:insertAttribute name="content" />
		</div>
	   <div id="footer">
	  			<tiles:insertAttribute name="footer" />
		</div>
</div>
</body>
</html>
