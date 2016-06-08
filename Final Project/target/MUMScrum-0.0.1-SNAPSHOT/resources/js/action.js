$(document).ready(function(){
	deleteItemById = function(id){
		$.ajax({
			url: '/MUMScrum/employees/delete/' + id,
			type: 'PUT',
			dataType: 'json',
			success: function(response){
				alert(response);
	 		 		location.reload(true);
			},
			error: function(){
				alert("An error occured.");
			}
		});	
	}  
});