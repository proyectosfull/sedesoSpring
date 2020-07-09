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

<!-- <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap/bootstrap.min.css" />'/> -->
<link rel="stylesheet"
	href="${ urlPublic }/css/bootstrap/bootstrap.min.css" />
</head>
<body>
	<sf:form action="${urlRoot}reportes" method="get">
		<div class="container">
			<h1>Resultado</h1>
			<c:if test="${resultado == 'OK'}">
				<div class="row">
					<div class="alert alert-success col-sm-12" role="alert">
						<h4 class="alert-heading">Excelente!</h4>
						<p>Archivos guardados éxitosamente!</p>
						<hr>

					</div>
				</div>
			</c:if>
			<c:if test="${resultado == 'NOK'}">
				<div class="row">
					<div class="alert alert-danger col-sm-12" role="alert">
						<h4 class="alert-heading">Error!</h4>
						<p>Servicio temporalmente no disponible</p>
						<hr>

					</div>
				</div>
			</c:if>
			<div class="row">
				<input class="btn btn-primary" type="submit" value="Regresar">
			</div>
		</div>
	</sf:form>

	

	<script src="${ urlPublic }/js/jquery/jquery3.4.1.js"></script>
	<script src="${ urlPublic }/js/popper/popper.js"></script>
	<script src="${ urlPublic }/js/bootstrap/bootstrap.min.js"></script>
</body>
</html>