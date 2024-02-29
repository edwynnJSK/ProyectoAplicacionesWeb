package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import entities.Categoria;

class CategoriaTest {

	@Test
	void testGetAllOfIngresoType() {
		List<Categoria> categorias = Categoria.getAllOfIngresoType();	
		assertEquals(37, categorias.size());
	}

}
