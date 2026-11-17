package com.example.felipe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class GuardaRoupaTest {

    private GuardaRoupa guarda;

    @BeforeEach
    void configurar() {
        guarda = new GuardaRoupa(500);
    }
    @Test
    @DisplayName("Deve rejeitar desconto maior que 100%")
    void deveRejeitarDescontoMaiorQue100() {
        assertThrows(IllegalArgumentException.class, () -> {
            guarda.precoComDesconto(200, 110);
        });
    }
    @Test
    @DisplayName("Deve rejeitar desconto negativo")
    void deveRejeitarDescontoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            guarda.precoComDesconto(200, -10);
        });
    }
    @Test
    @DisplayName("Deve aceitar compra com valor exato do orçamento")
    void deveAceitarCompraComValorExatoDoOrcamento() {
        assertTrue(guarda.cabeNoOrcamento(500));
    }

    @Test
    @DisplayName("Deve rejeitar compra acima do orçamento")
    void deveRejeitarCompraAcimaDoOrcamento() {
        assertThrows(IllegalArgumentException.class, () -> {
            guarda.registrarCompra(600);
        });
        assertEquals(500, guarda.getOrcamento());
    }

    @Test
    @DisplayName("Deve descontar o valor da compra do orçamento")
    void deveDescontarCompraDoOrcamento() {
        guarda.registrarCompra(100);
        assertEquals(400, guarda.getOrcamento());
    }
}
