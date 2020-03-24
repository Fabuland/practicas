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

	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light" id="navbar">
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
				<form class="form-inline px-5">
					<input class="form-control mx-3" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
				<div class="m-5">
					Claro/oscuro
					<button class="btn btn-dark" type="button" id="botonOscuro"
						onclick="modoOscuro()"></button>
				</div>
			</div>
		</nav>
		<h1 class="pb-5">Coches</h1>

		<div class="row justify-content-between mb-3">
			<h4 class="col-sm-3">Filter from:</h4>
			<select class="col-sm-3 form-control" id="select1">
				<option value="">- Brand -</option>
				<%
					List<String> brands = (List<String>) request.getAttribute("makes");
				if (brands != null) {
					for (String b : brands) {
				%>
				<option value="<%=b%>"><%=b%></option>
				<%
					}
				}
				%>

			</select> <select class="col-sm-3 form-control" id="select2">
				<option value="">- Years -</option>
				<%
					List<Integer> years = (List<Integer>) request.getAttribute("years");
				if (years != null) {
					for (Integer y : years) {
				%>
				<option value="<%=y%>"><%=y%></option>
				<%
					}
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
						<button type="button" class="btn btn-default">
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
	</div>

</body>
</html>