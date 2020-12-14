function ajoutPanier(id){
	$.ajax({
			url : 'ajoutPanierServlet',
			data : {
				id : id
			},
			success : function(responseText) {
				alert(responseText)
			}
		});
}
