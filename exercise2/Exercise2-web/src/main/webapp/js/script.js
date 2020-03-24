
function modoOscuro() {
  var body = document.body;
  body.classList.toggle("modo-oscuro");
  
  if($("#table").hasClass("table-dark")){
		$("#table").addClass("table-light");
		$("#table").removeClass("table-dark");
	  }else{
		  $("#table").removeClass("table-light");
		  $("#table").addClass("table-dark");
	  }
  if($("#navbar").hasClass("navbar-dark")){
		$("#navbar").addClass("navbar-light");
		$("#navbar").removeClass("navbar-dark");
	  }else{
		  $("#navbar").removeClass("navbar-light");
		  $("#navbar").addClass("navbar-dark");
	  }
  if($("#botonOscuro").hasClass("btn-dark")){
		$("#botonOscuro").addClass("btn-light");
		$("#botonOscuro").removeClass("btn-dark");
	  }else{
		  $("#botonOscuro").removeClass("btn-light");
		  $("#botonOscuro").addClass("btn-dark");
	  }
}
  
