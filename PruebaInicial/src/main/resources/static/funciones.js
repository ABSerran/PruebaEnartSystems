function eliminar(id) {
	
	swal({
  title: "¿Seguro que quieres eliminarlo?",
  text: "Una vez que lo elimines no podrás recuperarlo",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
 $.ajax({
 url:"/eliminar/"+id,
 success: function(res) {
 console.log(res);
 }
 
 
 })
    swal("Poof! Tu cliente ha sido eliminado", {
      icon: "success",
    }).then((ok)=>{
    	if(ok){
    	location.href="/";
    	}
    });
  } else {
    swal("Tu cliente está a salvo");
  }
});
	

}