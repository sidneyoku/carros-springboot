package com.example.carros;

import com.example.carros.api.exception.ObjectNotFoundException;
import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
import com.example.carros.domain.dto.CarroDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarrosApplicationTests {

	@Autowired
	private CarroService carroService;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void teste() {
//		Carro carro = new Carro();
//		carro.setNome("Fiesta");
//		carro.setTipo("compacto");
//
//		CarroDTO carroDTO = carroService.insert(carro);
//
//		assertNotNull(carroDTO);
//
//		Long id = carroDTO.getId();
//		assertNotNull(id);
//
//		Optional<CarroDTO> op = carroService.getCarroById(id);
//		assertTrue(op.isPresent());
//
//		carroDTO = op.get();
//		assertEquals(carro.getNome(), carroDTO.getNome());
//		assertEquals(carro.getTipo(), carroDTO.getTipo());
//
//		carroService.delete(id);
//
//		assertFalse(carroService.getCarroById(id).isPresent());
//	}

	/**
	 * Aula 54: ResponseStatus
	 */
	@Test
	public void teste() {
		Carro carro = new Carro();
		carro.setNome("Fiesta");
		carro.setTipo("compacto");

		CarroDTO carroDTO = carroService.insert(carro);

		assertNotNull(carroDTO);

		Long id = carroDTO.getId();
		assertNotNull(id);

		carroDTO = carroService.getCarroById(id);
		assertNotNull(carroDTO);

		assertEquals(carro.getNome(), carroDTO.getNome());
		assertEquals(carro.getTipo(), carroDTO.getTipo());

		carroService.delete(id);

		try {
			assertNull(carroService.getCarroById(id));
			fail("O carro não foi excluído");
		} catch (ObjectNotFoundException ex) {
			// OK
		}
	}

	@Test
	public void testeLista() {
		List<CarroDTO> lista = carroService.getCarros();

		assertEquals(30, lista.size());
	}

//	@Test
//	public void testeGet() {
//		Optional<CarroDTO> op = carroService.getCarroById(11L);
//		assertTrue(op.isPresent());
//
//		CarroDTO carroDTO = op.get();
//		assertEquals("Ferrari FF", carroDTO.getNome());
//	}

	/**
	 * Aula 54: RespnseStatus
	 */
	@Test
	public void testeGet() {
		CarroDTO carroDTO = carroService.getCarroById(11L);
		assertNotNull(carroDTO);
		assertEquals("Ferrari FF", carroDTO.getNome());
	}

	@Test
	public void testeTipo() {
		assertEquals(10, carroService.getCarroByTipo("esportivos").size());
		assertEquals(10, carroService.getCarroByTipo("classicos").size());
		assertEquals(10, carroService.getCarroByTipo("luxo").size());

		assertEquals(0, carroService.getCarroByTipo("xxx").size());
	}

}
