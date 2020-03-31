<%@page import="com.practicas.model.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/script.js"></script>
<title>Exercise 2</title>
</head>
<body>

	<%
		String yearP = (String) request.getAttribute("year");
	if (yearP != null && !yearP.equals("null")) {
		if (yearP.equals("0")) {
			yearP = "null";
		}
	}
	String make = (String) request.getAttribute("make");
	String actualPage = (String) request.getAttribute("page");

	int pageT = 0;
	if(actualPage != null){
		pageT = Integer.valueOf(actualPage);
	}
	
	int next = -1;
	int prev = -1;
	
	if (pageT > 0) {
		prev = pageT - 1;
	}
	next = pageT + 1;
	/*if (actualPage == null) {
		actualPage = "0";
	}
	String make = (String) request.getAttribute("make");
	String yearP = (String) request.getAttribute("year");
	if (yearP == null) {
		yearP = 0;
	}
	int next = -1;
	int prev = -1;
	int firstPage = Integer.valueOf(actualPage);
	if (firstPage > 1) {
		prev = firstPage - 1;
	}
	next = firstPage + 1;*/
	List<String> makesL = (List<String>) request.getAttribute("makes");
	List<Integer> yearsL = (List<Integer>) request.getAttribute("years");
	List<Car> carsL = (List<Car>) request.getAttribute("cars");
	%>
	<input type="hidden" name="page" id="page" value="<%=actualPage%>" />
	<input type="hidden" name="makeFilterValue" id="makeFilterValue"
		value="<%=make%>" />
	<input type="hidden" name="yearFilterValue" id="yearFilterValue"
		value="<%=yearP%>" />
	<div class="container">

		<nav class="navbar navbar-expand-sm navbar-light" id="navbar">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Dropdown </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
				<form class="form-inline px-2">
					<input class="form-control mx-3" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
				<div class="mx-5">
					Claro/oscuro
					<button class="btn btn-dark" type="button" id="botonOscuro"
						onclick="modoOscuro()"></button>
				</div>
			</div>
		</nav>
		<h1>Coches</h1>

		<div class="row justify-content-between mb-3">
			<h4 class="col-sm-3">Filter from:</h4>
			<select class="col-sm-3 filterMake" id="select1">
				<%
					for (String makeI : makesL) {
				%>
				<option <%if (makeI.equals(make)) {%> selected <%}%>
					value="<%=makeI%>">
					<%=makeI%>
				</option>
				<%
					}
				%>

			</select> <select class="col-sm-3 filterYear" id="select2">
				<%
					for (Integer yearI : yearsL) {
				%>
				<option <%if (yearI.equals(yearP)) {%> selected <%}%>
					value="<%=yearI%>">
					<%=yearI%>
				</option>
				<%
					}
				%>

			</select>
		</div>
		<table
			class="table table table-striped table-light table-bordered table-hover"
			id="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Modelo</th>
					<th scope="col">Año</th>
					<th scope="col">Marca</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Car> cars = (List<Car>) request.getAttribute("cars");
				if (cars != null) {
					for (Car c : cars) {
				%>
				<tr>
					<th><%=c.getPk()%></th>
					<td><%=c.getIdentification().getId()%></td>
					<td><%=c.getIdentification().getYear()%></td>
					<td><%=c.getIdentification().getMake()%></td>
					<td>
						<button type="button" class="btn btn-default buttonDetails"
							id="<%=c.getPk()%>">
							<span class="fas fa-eye"></span>
						</button>
						<button type="button" class="btn btn-default">
							<span class="far fa-trash-alt"></span>
						</button>
					</td>
				</tr>
				<%
					}
				}
				%>
			</tbody>
		</table>

		<ul class="pagination" id="pagination">
			<li class="page-item" <%if (prev < 0) {%> <%}%>><a
				class="page-link" <%if (prev > 0) {%>
				href="./?action=pagination&page=<%=prev%>" <%}%> <%if (prev < 0) {%>
				tabindex="-1" aria-disabled="true" <%}%>>Previous</a></li>
			<%
				if (prev > 0) {
			%>
			<li class="page-item"><a class="page-link"
				href="./?action=pagination&page=<%=prev%>"><%=prev%></a></li>
			<%
				}
			%>
			<li class="page-item active" aria-current="page"><a
				class="page-link" href="#"><%=actualPage%> <span class="sr-only"><%=actualPage%></span></a></li>
			<%
				if (next > 0) {
			%>
			<li class="page-item"><a class="page-link"
				href="./?action=pagination&page=<%=next%>"><%=next%></a></li>
			<%
				}
			%>
			<li class="page-item"><a class="page-link"
				href="./?action=pagination&page=<%=next%>">Next</a></li>
		</ul>

	</div>



</body>
</html>