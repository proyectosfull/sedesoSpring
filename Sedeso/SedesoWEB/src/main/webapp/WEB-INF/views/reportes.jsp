<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!doctype html>
<html lang="es">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<title>Cuernavaca - Subir Reporte</title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/" var="urlRoot" />
<c:set var="baseurl" value="https://23.82.16.144:8080/SEDESO/"></c:set>
<!-- <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap/bootstrap.min.css" />'/> -->
<link rel="stylesheet"
	href="${ urlPublic }/css/bootstrap/bootstrap.min.css" />
</head>
<body>
	<sf:form action="${urlRoot}reportes/upload"
		enctype="multipart/form-data" method="post">
		<div class="container-fluid  py-6" style="background-color: darkred">
			<div class="container text-white">
				<h1 class="display-3">
					<b>Envía tu reporte!</b>
				</h1>
				<p class="lead">Carga tus datos y envia el reporte.</p>
			</div>
		</div>

		<div class="container">

			<div class="row">
				<div class="form-group col-sm-6 col-md-6 col-lg-6">
					<label for="text">Ingresa tu Usario:</label> <input type="text"
						class="form-control" placeholder="Usuario" id="usuario"
						name="usuario" required>
				</div>
			</div>
			<div class="row">
				<hr width=100% color="green">
			</div>
			<div class="row">
				<div class="form-group col-sm">
					<label for="text">Nombre del Beneficiario:</label> <input
						type="text" class="form-control"
						placeholder="Nombre del Beneficiario" id="nombBenef"
						name="nombBenef">
				</div>
				<div class="form-group col-sm">
					<label for="text">Teléfono de Contacto:</label> <input type="text"
						class="form-control" placeholder="Teléfono de Contacto"
						id="telContact" name="telContact">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm">
					<label for="email">Correo Electrónico:</label> <input type="email"
						class="form-control" placeholder="Correo Electrónico" id="email"
						name="email">
				</div>
				<div class="form-group col-sm">
					<label for="text">Prioridad:</label> <input type="text"
						class="form-control" placeholder="Prioridad" id="prioridad"
						name="prioridad">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm">
					<label for="text">Beneficiarios en el domicilio</label> <input
						type="text" class="form-control"
						placeholder="Beneficiarios en el domicilio" id="beneficiariosDom"
						name="beneficiariosDom">
				</div>
				<div class="form-group col-sm">
					<label for="text">Observaciones del Visitador</label> <input
						ype="text" class="form-control"
						placeholder="Observaciones del Visitador" id="observVisit"
						name="observVisit">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm">
					<label for="text">Latitud:</label> <input type="text"
						class="form-control" placeholder="Latitud" id="lat" name="lat">
				</div>
				<div class="form-group col-sm">
					<label for="text">Longitud:</label> <input ype="text"
						class="form-control" placeholder="Longitud" id="long" name="long">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm">
					<label for="text">Nombre:</label> <input type="text"
						class="form-control" placeholder="Nombre" id="nombre"
						name="nombre">
				</div>
				<div class="form-group col-sm">
					<label for="text">Metros:</label> <input ype="text"
						class="form-control" placeholder="Metros" id="metros"
						name="metros">
				</div>
				<div class="form-group col-sm">
					<label for="text">Domicilio:</label> <input ype="text"
						class="form-control" placeholder="Domicilio" id="domicilio"
						name="domicilio">
				</div>
			</div>

			<div class="row">
				<hr width=100% color="green">
			</div>
			<div class="row">
				<div class="form-group col-sm">
					<label for="exampleInputEmail1">Evidencias:</label>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm col-md-6 col-lg-4">
					<input type="file" name="fotoUno" id="fotoUno"
						aria-describedby="usuarioHelp"> <small id="usuarioHelp"
						class="form-text text-muted">Seleccione primera foto</small>
				</div>
				<div class="form-group col-sm col-md-6 col-lg-4">
					<input type="file" name="fotoDos" id="fotoDos"
						aria-describedby="usuarioHelp"> <small id="usuarioHelp"
						class="form-text text-muted">Seleccione la segunda foto</small>
				</div>

				<div class="form-group col-sm col-md-6 col-lg-4">
					<input type="file" name="fotoTres" id="fotoTres"
						aria-describedby="usuarioHelp"> <small id="usuarioHelp"
						class="form-text text-muted">Seleccione la tercera foto</small>
				</div>

			</div>
			<div class="row">
				<hr width=100% color="green">
			</div>

			<div class="row">
				<div class="form-group col-sm col-md-6 col-lg-6">
					<input type="file" name="fotoCuatro" id="fotoCuatro"
						aria-describedby="usuarioHelp"> <small id="usuarioHelp"
						class="form-text text-muted">Seleccione un video</small>
				</div>
				<div class="form-group col-sm col-md-6 col-lg-6">
					<input type="file" name="fotoCinco" id="fotoCinco"
						aria-describedby="usuarioHelp"> <small id="usuarioHelp"
						class="form-text text-muted">Seleccione audio</small>
				</div>
			</div>

			<div class="form-group form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" required> Estoy de
					acuerdo que los datos que se enviaran son los correctos.
				</label>
			</div>
			<input type="submit" value="Guardar cambios" class="btn btn-primary" />
		</div>

	</sf:form>


	<div id="resultContainer" style="display: none;">
		<hr />
		<h4 style="color: green;">JSON Response From Server</h4>
		<pre style="color: green;">
    <code></code>
   </pre>
	</div>
	<script src="${ urlPublic }/js/utils/Utils.js"></script>
	<script src="${ urlPublic }/js/jquery/jquery3.4.1.js"></script>
	<script src="${ urlPublic }/js/popper/popper.js"></script>
	<script src="${ urlPublic }/js/bootstrap/bootstrap.min.js"></script>
</body>
</html>