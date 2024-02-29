<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Agregar Cuenta</title>
<link type="text/css" rel="stylesheet" href="css/agregarCuenta.css">
<link type="text/css" rel="stylesheet" href="css/style.css">
<script
	src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
</head>

<body>
	<header class="header-principal">
		<button class="btn-regresar"
			onclick="(window.location ='/ContamoneyWithoutDAO/ConfiguracionController?ruta=configurarCuenta')">
			<iconify-icon class="icono-boton" icon="mdi:arrow-left" width="20"></iconify-icon>
		</button>
		<button class="boton boton2 usuario_shortcut">
			<img src="https://picsum.photos/30" alt="imagen de usuario">
			<p>Usuario</p>
		</button>
	</header>
	<main>
		<div class="contenedor-agregar-cuenta">
			<p class="titulo">Agregar Cuenta</p>
			<form class="form-agregar-cuenta" method="POST" id="form-cuenta">
				<label for="nombre">Nombre de Cuenta</label> <input type="text"
					name="nombre" class="txt-nombre-banco"
					placeholder="Nombre de Cuenta" required> <label for="total">Valor
					total de la Cuenta</label> <input type="number" name="total"
					class="txt-nombre-banco" placeholder="Valor total de la Cuenta" required>
				<button type="button" class="btn-agregar-cuenta" onclick="agregar()">Agregar
					Cuenta</button>
				<button type="button" class="btn-cancelar-cuenta"
					onclick="(window.location ='/ContamoneyWithoutDAO/ConfiguracionController?ruta=configurarCuenta')">Cancelar</button>
			</form>
			<script>
				function agregar() {
					document.getElementById('form-cuenta').action = '/ContamoneyWithoutDAO/ConfiguracionController?ruta=crearCuenta';
					document.getElementById('form-cuenta').submit();
				}
			</script>
		</div>
	</main>
</body>

</html>