package org.example;

public class Main {
    public static void main(String[] args) {

        Pedido pedido1 = new Pedido(100.0);
        Pedido pedido2 = new Pedido(200.0);

        EstrategiaDeFrete fretePadrao = new FretePadrao(20.0);
        EstrategiaDeFrete freteGratis = new FreteGratis();

        ProcessadorDePagamento processador = new ProcessadorDePagamento();

        double total1 = processador.processar(pedido1, fretePadrao);
        System.out.println("Pedido com Frete Padrão: R$ " + total1);

        double total2 = processador.processar(pedido2, freteGratis);
        System.out.println("Pedido com Frete Grátis: R$ " + total2);

    }
}