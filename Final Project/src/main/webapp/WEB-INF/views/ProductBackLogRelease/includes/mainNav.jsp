<section>
	<ul style="display: inline; margin-left: 15px; font-size: large;">
		<li style="display: inline;  margin-left: 15px;"><a href="http://localhost:8080/MumScrum/">Home</a></li>
<!-- 		<li><a href="http://localhost:8080/MumScrum/createUserStory">Create User Story</a></li> -->
<!-- 		<li><a href="http://localhost:8080/MumScrum/userStoriesList/1">User Story List</a></li> -->
		
		<sec:authorize access="hasRole('ROLE_PRODUCT_OWNER')" >
        	<li style="display: inline;  margin-left: 15px;"><a href="http://localhost:8080/MumScrum/productBacklogCreate">Create Product Backlog</a></li>
        	<li style="display: inline;  margin-left: 15px;"><a href="http://localhost:8080/MumScrum/productBacklogList/1"> List of product Backlogs</a></li>	
   		 </sec:authorize>
		
		<sec:authorize access="hasRole('ROLE_SCRUM_MASTER')" >
        	<li style="display: inline;  margin-left: 15px;"><a href="http://localhost:8080/MumScrum/releaseBacklogList/1"> List of product Backlogs</a></li>	
   		 </sec:authorize>
		
				
		 <li style="display: inline;  margin-left: 15px;"><a href="/MumScrum/login">logout</a></li>
	</ul>
</section>
<br>
<br>
