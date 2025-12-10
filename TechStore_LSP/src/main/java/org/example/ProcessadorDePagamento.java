package org.example;

public class ProcessadorDePagamento {

    public double processar(Pedido pedido, EstrategiaDeFrete estrategia) {
        double valorFinal = estrategia.calcularValorFinal(pedido);

        if (valorFinal < pedido.getValorBruto()) {
            throw new IllegalStateException(
                    "Erro: o valor final não pode ser menor que o valor bruto."
            );
        }

        return valorFinal;
    }
}