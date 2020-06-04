<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="es">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<title>Cuernavaca</title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/" var="urlRoot" />

<!-- <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap/bootstrap.min.css" />'/> -->
<link rel="stylesheet"
	href="${ urlPublic }/css/bootstrap/bootstrap.min.css" />
</head>
<body>
	<div class="container-fluid bg-primary py-6">
		<div class="container text-white">
			<h1 class="display-3">
				<b>Descarga tu reporte!</b>
			</h1>
			<p class="lead">Solo ingresa tu nombre de usuario!</p>
		</div>
	</div>
	
		<div class="container">
			<div class="row">
				<div class="form-group col-2">
					<label for="exampleInputEmail1">Usuario:</label> <input type="text"
						class="form-control" id="usuario" aria-describedby="usuarioHelp">
					<small id="usuarioHelp" class="form-text text-muted">Use el
						usuario que creo en su aplicacion.</small>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-2">
					<button type="button" class="btn btn-primary" onclick="entrar()">Entrar</button>
				</div>
			</div>
		</div>

	<div class="container">
		<div id="resultContainer" style="display: none;">
			<hr />
			<h4 style="color: green;">Documentos</h4>
			<pre style="color: green;">
		     <code></code>
		    </pre>
		</div>
	</div>
	<script src="${ urlPublic }/js/utils/Utils.js"></script>
	<script src="${ urlPublic }/js/jquery/jquery3.4.1.js"></script>
	<script src="${ urlPublic }/js/popper/popper.js"></script>
	<script src="${ urlPublic }/js/bootstrap/bootstrap.min.js"></script>
</body>
</html>