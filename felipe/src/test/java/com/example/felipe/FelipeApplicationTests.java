package com.example.felipe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FelipeApplicationTests {

	@Test
	void contextLoads() {
	}

}

class GuardaRoupaTest {

	@Test
	void deveRejeitarDescontoMaiorQue100() {
		GuardaRoupa guarda = new GuardaRoupa(500);

		assertThrows(IllegalArgumentException.class, () -> {
			guarda.precoComDesconto(200, 110);
		});
	}

	@Test
	void deveAceitarCompraComValorExatoDoOrcamento() {
		GuardaRoupa guarda = new GuardaRoupa(100);

		assertTrue(guarda.cabeNoOrcamento(100));
	}

	@Test
	void deveRejeitarCompraAcimaDoOrcamento() {
		GuardaRoupa guarda = new GuardaRoupa(100);

		assertThrows(IllegalArgumentException.class, () -> {
			guarda.registrarCompra(150);
		});

		assertEquals(100, guarda.getOrcamento());
	}
}
	