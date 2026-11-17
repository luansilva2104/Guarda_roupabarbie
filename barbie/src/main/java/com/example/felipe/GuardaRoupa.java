
package com.example.felipe;

public class GuardaRoupa {

    private double orcamento;

    public GuardaRoupa(double orcamento) {
        this.orcamento = orcamento;
    }
    /*
    ERRO:

    public double precoComDesconto(double preco, double percentual) {
        return preco - (preco * percentual / 100);
    }

    PROBLEMA:
    O sistema aceitava descontos menores que 0%
    ou maiores que 100%.
    */

    public double precoComDesconto(double preco, double percentual) {

        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Desconto inválido!");
        }
        return preco - (preco * percentual / 100);
    }
    /*
    ERRO:

    public boolean cabeNoOrcamento(double preco) {
        return preco < orcamento;
    }

    PROBLEMA:
    Não aceitava uma compra cujo valor fosse
    exatamente igual ao orçamento.
    */
    public boolean cabeNoOrcamento(double preco) {
        return preco <= orcamento;
    }

    public boolean ehDeGala(double preco) {
        return preco >= 200.0;
    }
    /*
    ERRO:

    public void registrarCompra(double preco) {
        this.orcamento = this.orcamento - preco;
    }

    PROBLEMA:
    Permitiria realizar compras acima do orçamento,
    deixando o saldo negativo.
    */
    public void registrarCompra(double preco) {
        if (preco > orcamento) {
            throw new IllegalArgumentException(
                    "Orçamento insuficiente!"
            );
        }
        this.orcamento -= preco;
    }
    public double getOrcamento() {
        return orcamento;
    }
}

