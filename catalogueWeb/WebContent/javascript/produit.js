$(function() {	
	$('.produitEJBservlet').click(function(){
			let id = $(this).attr('id')
			alert(id)
	        $.ajax({
	        	url: "produitEJBservlet?id="+id,
	        	type: "get",
	            success: function(data) {
	                    if (data == "success") {
	                        alert("c'est un succès");
	                    }
	                    else {
	                        alert("error");
	                    }
	                }
	            });
	       })
	
})

function LoadData(id){
			alert(id)
	        /*$.ajax({
	        	url: "produitEJBservlet?id="+id,
	        	type: "POST",
	            data: { id: id },
	            success: function(data) {
	                    if (data == "success") {
	                        alert("c'est un succès");
	                    }
	                    else {
	                        alert("error");
	                    }
	                }
	            });*/
	}