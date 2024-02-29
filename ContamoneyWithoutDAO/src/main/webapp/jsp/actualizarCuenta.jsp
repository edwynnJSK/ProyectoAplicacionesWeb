<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Actualizar Cuenta</title>
<link type="text/css" rel="stylesheet" href="jsp/css/agregarCuenta.css">
<link type="text/css" rel="stylesheet" href="jsp/css/style.css">
<script
	src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
</head>

<body>
	<header class="header-principal">
		<button class="btn-regresar"
			onclick="window.location.href='ConfiguracionController?ruta=configurarCuenta'">
			<iconify-icon class="icono-boton" icon="mdi:arrow-left" width="20"></iconify-icon>
		</button>
		<button class="boton boton2 usuario_shortcut">
			<img src="https://picsum.photos/30" alt="imagen de usuario">
			<p>Usuario</p>
		</button>
	</header>
	<main>
		<div class="contenedor-agregar-cuenta">
			<p class="titulo">Actualizar Cuenta</p>
			<form class="form-agregar-cuenta"
				action="ConfiguracionController?ruta=actualizarCuenta" method="POST"
				id="form-cuenta">
				<input type="hidden" value="${cuenta.id}" name="idCuenta" />
				<div style="display: flex; margin-bottom: 10px;">
					<label for="idCuenta" style="padding-right: 20px;">ID</label>
					<div class="id_transaccion">${cuenta.id}</div>
				</div>
				<label>Nombre de Cuenta</label> <input type="text" name="nombre"
					class="txt-nombre-banco" value="${cuenta.nombre}" required> <label>Valor
					total de la Cuenta</label> <input type="number" name="total"
					class="txt-nombre-banco" value="${cuenta.total}" required>
				<button type="button" class="btn-agregar-cuenta" onclick="actualizar()">Actualizar
					Cuenta</button>
				<button type="button" class="btn-cancelar-cuenta"
					onclick="(window.location ='ConfiguracionController?ruta=configurarCuenta')">Cancelar</button>
			</form>
			<script>
				function actualizar() {
					document.getElementById('form-cuenta').action = 'ConfiguracionController?ruta=actualizarCuenta';
					document.getElementById('form-cuenta').submit();
				}
			</script>
		</div>
	</main>
</body>

</html>