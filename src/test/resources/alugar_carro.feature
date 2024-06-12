Feature: Alugar carro para viagem

  Como um cliente de uma locadora de carros
  Eu quero alugar um carro para minha viagem
  Para que eu possa ter uma experiência de locação satisfatória

  Scenario: Cliente deseja alugar um carro de luxo com antecedência
    Given que o cliente deseja alugar um carro de luxo
    And que a reserva foi feita com antecedência de pelo menos uma semana
    When o sistema processar a reserva
    Then o sistema deve oferecer um desconto especial no valor total da locação

  Scenario: Cliente necessita alugar um carro utilitário de última hora
    Given que o cliente deseja alugar um carro utilitário
    And que não foi feita uma reserva prévia
    When o sistema processar a locação
    Then o sistema deve encontrar um veículo disponível
    And o sistema deve processar a locação rapidamente
    And o sistema deve aplicar um custo adicional devido à demanda urgente
