package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entities.Cuenta;

class CuentaTest {

	@Test
	void testGetById() {
		Cuenta cuenta = Cuenta.getById(2);
		assertEquals(300,cuenta.getTotal());
	}

	@Test
	void testUpdate() {
		// Crear una nueva instancia de Cuenta con valores específicos
        Cuenta cuenta = new Cuenta("Bco. Quito", 5000);
        
        
        // Llamar al método update para actualizar la cuenta
        boolean actualizado = cuenta.update(cuenta, 1); // Aquí asumimos que el ID de la cuenta a actualizar es 1
        
        // Verificar si la cuenta fue actualizada correctamente
        assertTrue(actualizado);
        
        // Obtener la cuenta actualizada de la base de datos
        Cuenta cuentaActualizada = Cuenta.getById(1); // Aquí asumimos que el ID de la cuenta a verificar es 1
        
        // Verificar si los valores actualizados coinciden con los valores esperados
        String nuevoNombreEsperado="Bco. Quito";
        int nuevoTotalEsperado = 5000;
        assertEquals(nuevoNombreEsperado, cuentaActualizada.getNombre());
        assertEquals(nuevoTotalEsperado, cuentaActualizada.getTotal());
	}
	
	@Test
	void testCreate() {
		Cuenta cuenta = new Cuenta("El Pacifico", 1500);
		assertEquals(true,Cuenta.crear(cuenta));
	}
	
	@Test
	void testDelete() {
		Integer idCuenta = 5;
		assertEquals(true,Cuenta.delete(idCuenta));
	}
}
