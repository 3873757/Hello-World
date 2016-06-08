
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<h1>Create Release</h1>

<form:form modelAttribute="newProductBackLogRelease" method="POST">
	<table class="table table-hover">
	<form:input type="hidden" path="id" id="id" />
	    
				<tr>
				<td><label  for="pBacklog"><spring:message code="pBacklog.create.label" /></label></td>
				<td>
			
						<form:select name="id" path="productId">
							
							<form:options items="${ReleaseBacklogs}" itemLabel="name" itemValue="id"  />
							
						</form:select>
						
					
			<td>
			<tr>
	<tr>
	     <td>Release Number:</td>
	         <td><form:input type="text" path="releaseNumber" /> </td>
	         <form:errors path="releaseNumber" cssStyle="color: red;"/>
	     </tr>
	     <tr>
	         <td>Name:</td>
	         <td><form:input type="text" path="name" /> </td>
	         <form:errors path="name" cssStyle="color: red;"/>
	     </tr>
	     <tr>
	         <td>Description:</td>
	         <td><form:textarea type="text" path="description" rows="5" cols="30" /> </td>
	         <form:errors path="description" cssStyle="color: red;"/>
	     </tr>
	     <tr>
	         <td>Start Date:</td>
	         <td><form:input type="text" path="startDate" />MM/DD/YYYY </td>
	         <form:errors path="startDate" cssStyle="color: red;"/>
	     </tr>
	     <tr>
	         <td>Expected End Date:</td>
	         <td><form:input type="text" path="endDate" /> MM/DD/YYYY</td>
	         <form:errors path="endDate" cssStyle="color: red;"/>
	     </tr>

	     <tr> <td> <input type="submit" value="Create Release Backlog"/> </td></tr>	
     </table>
    
					
   </form:form>

</body>


