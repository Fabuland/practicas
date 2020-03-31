function modoOscuro() {
	var body = document.body;
	body.classList.toggle("modo-oscuro");

	if ($("#table").hasClass("table-dark")) {
		$("#table").addClass("table-light");
		$("#table").removeClass("table-dark");
	} else {
		$("#table").removeClass("table-light");
		$("#table").addClass("table-dark");
	}
	if ($("#navbar").hasClass("navbar-dark")) {
		$("#navbar").addClass("navbar-light");
		$("#navbar").removeClass("navbar-dark");
	} else {
		$("#navbar").removeClass("navbar-light");
		$("#navbar").addClass("navbar-dark");
	}
	if ($("#botonOscuro").hasClass("btn-dark")) {
		$("#botonOscuro").addClass("btn-light");
		$("#botonOscuro").removeClass("btn-dark");
	} else {
		$("#botonOscuro").removeClass("btn-light");
		$("#botonOscuro").addClass("btn-dark");
	}
}

$(document).ready(
		function() {
			$('.filterYear').change(
					function() {
						var valor = $(this).children("option:selected").val();
						location.href = './?action=filters&filterYear=' + valor
								+ '&filterMake=' + $('#makeFilterValue').val()
								+ '&page=0';
					});
			$('.filterMake').change(
					function() {
						var valor = $(this).children("option:selected").val();
						location.href = './?action=filters&filterYear='
								+ $('#yearFilterValue').val() + '&filterMake='
								+ valor + '&page=0';
					});
		});

$('.buttonDetails')
		.click(
				function() {
					var id = this.id;
					location.href = "./?action=pagination&filterYear=<%=yearP%>&filterMake=<%=make%>&page=<%=actualPage%>&id="
							+ id;
				});