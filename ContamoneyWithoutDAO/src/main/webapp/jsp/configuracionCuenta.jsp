<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Configuracion Cuenta</title>
<link rel="stylesheet" href="css/style1.css">
<script
	src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>

<!--Icons-->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body>
	<!-- nav -->
	<header class="header_pagina_principal">
		<button class="boton boton2 usuario_shortcut">
			<img src="https://picsum.photos/30" alt="imagen de usuario">
			<p>Usuario</p>
		</button>
		<div>
			<a href="DashboardController?ruta=ver"> <iconify-icon class="icono"
					icon="carbon:view-filled" width="18"></iconify-icon> <span>Dashboard</span>
			</a>
		</div>
	</header>

	<main class="main_pagina_principal">
		<!-- Lista de cuentas -->
		<div
			style="width: 100%; display: flex; justify-content: space-between;">
			<div>
				<header class="header_contenedor">
					<h2
						style="margin-bottom: 50px; padding-left: 100px; margin-top: 100px;">Cuentas</h2>
				</header>
			</div>

			<div>
				<section class="boton d-flex justify-content-end">
					<button type="button" class="btn" style="margin-top: 100px;"
						onclick="window.location.href='ConfiguracionController?ruta=verAgregarCuenta'">
						<i class="bi bi-plus-circle-fill"></i><br> Nuevo
					</button>
				</section>
			</div>
		</div>
		<div class="contenedor_default grid_abajo">

			<main id="transacciones" class="mostrar">
				<div class="transaccion">
					<div class="header_contenedor">
						<h3>ID</h3>
					</div>
					<div class="header_contenedor" style="width: 200px;">
						<h3>Nombre de la cuenta</h3>
					</div>
					<div class="header_contenedor">
						<h3>Total</h3>
					</div>
					<div class="header_contenedor">
						<h3>Acciones</h3>
					</div>
				</div>
				<c:forEach items="${cuentas}" var="cuenta">
					<div class="transaccion">
						<div class="id_transaccion">${cuenta.id}</div>
						<div class="transaccion_info">
							<p>${cuenta.nombre}</p>
						</div>
						<div class="transaccion_monto">
							<h4>${cuenta.total}</h4>
						</div>
						<div class="acciones">
							<a href="ConfiguracionController?ruta=verActualizar&idCuenta=${cuenta.id}"><i
								class="bi bi-pencil-square"></i>Actualizar</a>|<a href="ConfiguracionController?ruta=eliminarCuenta&idCuenta=${cuenta.id}"><i
								class="bi bi-trash-fill"></i>Eliminar</a>
						</div>
					</div>
				</c:forEach>
			</main>
		</div>
		</div>
	</main>
</body>

</html>