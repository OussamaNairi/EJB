function deleteProduct(index){
	swal({
		  title: "Are you sure?",
		  text: "Once deleted, you will not be able to recover this imaginary file!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
			if (willDelete) {
		
			 $.ajax({
				  type: "POST",
				  url: "ShopServlet",
				  data: {'delete' :'delete', 'index': index},
				  success:function(total){
					  $('#total').html(total);
					  $('#tr' +index).remove();
			  
		    swal("Poof! Your product  has been deleted!", {
		      icon: "success",
		    });
				  }
				  });
		  } else {
		    swal("Your product is safe!");
		  }
		  });
		
}