
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<h1>Create Product BackLog</h1>
<form:form modelAttribute="newProductBackLog" method="POST">
	<table class="table table-hover">

	
					
					
	<tr>
	     <td>ProductBackLogNumber:</td>
	         <td><form:input path="productId" /> </td>
	         <form:errors path="productId" cssStyle="color: red;"/>
	     </tr>
	     <tr>
	         <td>Name:</td>
	         <td><form:input type="text" path="name" /> </td>
	         <form:errors path="name" cssStyle="color: red;"/>
	     </tr>
	     <tr>
	         <td>Description:</td>
	         <td><form:textarea type="text" path="description"  rows="5" cols="30"/> </td>
	         <form:errors path="description" cssStyle="color: red;"/>
	     </tr>
	     <tr>
	         <td>Date Created:</td>
	         <td><form:input type="text" path="dateCreated" />MM/DD/YYYY </td>
	         <form:errors path="dateCreated" cssStyle="color: red;"/>
	     </tr>
	    

	     <tr> <td> <input type="submit" value="Create Product Backlog"/> </td></tr>	
     </table>
       </form:form>
</body>


