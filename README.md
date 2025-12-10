# Aplicação do Princípio de Substituição de Liskov (LSP)

Este projeto demonstra como corrigir uma violação do LSP no sistema de pedidos e fretes, removendo herança inadequada e aplicando o padrão Strategy.

## 1. Mau Design (Violação do LSP)

No design original, a classe `PedidoComFreteGratis` herdava de `Pedido`, mas alterava o comportamento esperado no cálculo de frete.  
Isso quebrava o LSP porque a classe derivada não mantinha o mesmo contrato da classe base.  
Como consequência, a classe cliente (`ProcessadorDePagamento`) precisava incluir condicionais para verificar o tipo de pedido, criando acoplamento e comportamento inconsistente.

## 2. Solução com Strategy (Atendendo ao LSP)

A responsabilidade de calcular frete foi removida da classe `Pedido` e separada em uma hierarquia própria, utilizando o padrão Strategy.  
Agora, todas as regras de frete seguem a mesma interface, garantindo substituição segura e previsível.

A solução inclui:

- Uma interface chamada `EstrategiaDeFrete`, que define o contrato para cálculo do valor final.
- Estratégias concretas como `FretePadrao` e `FreteGratis`, cada uma implementando sua própria lógica.
- A classe `Pedido` sem lógica de frete e sem necessidade de herança.
- A classe `ProcessadorDePagamento`, que recebe um `Pedido` e uma `EstrategiaDeFrete`, delegando o cálculo de forma independente do tipo de frete.

## 3. Resultado da Refatoração

Com a refatoração:

- O cálculo de frete fica isolado e fácil de estender.
- O cliente não utiliza condicionais e funciona com qualquer estratégia.
- A substituição entre `FretePadrao` e `FreteGratis` não altera o comportamento esperado.
- O sistema respeita o LSP, já que todas as estratégias seguem o mesmo contrato.
- A classe `Pedido` permanece estável e fechada para modificações desnecessárias.

Esta estrutura garante um design mais simples, claro e aderente ao princípio de Substituição de Liskov.
