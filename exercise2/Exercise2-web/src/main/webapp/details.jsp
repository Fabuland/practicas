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
		<h1>Details</h1>
		<div id="formularios">
			<form>
				<fieldset class="form-group">
					<div class="row">
						<legend class="col-form-label">Dimensions</legend>
						<div class="col-sm-10">
							<label for="width">Width:</label> <input type="text" id="width"
								name="width" class="form-control"> <label for="length">Length:</label>
							<input type="text" id="length" name="length" class="form-control">
							<label for="height">Height:</label> <input type="text"
								id="height" name="height" class="form-control">
						</div>

					</div>
				</fieldset>
				<fieldset class="form-group">
					<legend class="col-form-label">Engine Information</legend>
					<div class="row">

						<div class="col-sm-10">

							<label for="transmission">Transmission</label> <select
								class="custom-select" id="transmission">
								<option value="">Choose from</option>
								<%
									List<String> transmissions = (List<String>) request.getAttribute("transmissions");
								if (transmissions != null) {
									for (String t : transmissions) {
								%>
								<option value="<%=t%>"><%=t%></option>
								<%
									}
								}
								%>
							</select>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
		<%
			String filterMake = (String) request.getAttribute("filterMake");
		String filterYear = (String) request.getAttribute("filterYear");
		String id = (String) request.getAttribute("id");
		String pagei = (String) request.getAttribute("page");
		Car car = (Car) request.getAttribute("car");
		String carWidth = String.valueOf(car.getDimensions().getWidth());
		String carLength = String.valueOf(car.getDimensions().getLength());
		String carHeight = String.valueOf(car.getDimensions().getHeight());
		String carTransmission = (String) car.getEngineinformation().getTransmission();
		String carEngineType = (String) car.getEngineinformation().getEnginetype();
		String carHorsepower = String.valueOf(car.getEngineinformation().getEnginestatistics().getHorsepower());
		String carTorque = String.valueOf(car.getEngineinformation().getEnginestatistics().getTorque());
		String carHybrid = String.valueOf(car.getEngineinformation().isHybrid());
		String carForwardGears = String.valueOf(car.getEngineinformation().getNumberofforwardgears());
		String carDriveline = (String) car.getEngineinformation().getDriveline();
		String carMake = (String) car.getIdentification().getMake();
		String carModelYear = (String) car.getIdentification().getModelyear();
		String carModel = (String) car.getIdentification().getId();
		String carClassification = (String) car.getIdentification().getClassification();
		String carYear = String.valueOf(car.getIdentification().getYear());
		String carHighwayMpg = String.valueOf(car.getFuelinformation().getHighwaympg());
		String carCityMph = String.valueOf(car.getFuelinformation().getCitymph());
		String carFuelType = (String) car.getFuelinformation().getFueltype();
		%>
	</div>
</body>
</html>