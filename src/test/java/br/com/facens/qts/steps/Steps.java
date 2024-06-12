package br.com.facens.qts.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class Steps {
    private String tipoCliente;
    private String reserva;
    private String resultado;

    @Given("que o cliente deseja alugar um carro de luxo")
    public void cliente_deseja_carro_luxo() {
        tipoCliente = "luxo";
    }

    @Given("que a reserva foi feita com antecedência de pelo menos uma semana")
    public void reserva_com_antecedencia() {
        reserva = "antecedencia";
    }

    @When("o sistema processar a reserva")
    public void processar_reserva() {
        if(tipoCliente.equals("luxo") && reserva.equals("antecedencia")) {
            resultado = "desconto especial";
        }
    }

    @Then("o sistema deve oferecer um desconto especial no valor total da locação")
    public void verificar_desconto() {
        assertEquals("desconto especial", resultado);
    }

    @Given("que o cliente deseja alugar um carro utilitário")
    public void cliente_deseja_carro_utilitario() {
        tipoCliente = "utilitario";
    }

    @Given("que não foi feita uma reserva prévia")
    public void sem_reserva_previa() {
        reserva = "sem reserva";
    }

    @When("o sistema processar a locação")
    public void processar_locacao() {
        if(tipoCliente.equals("utilitario") && reserva.equals("sem reserva")) {
            resultado = "encontrar veiculo, locação rápida, custo adicional";
        }
    }

    @Then("o sistema deve encontrar um veículo disponível")
    public void verificar_veiculo_disponivel() {
        assertTrue(resultado.contains("encontrar veiculo"));
    }

    @Then("o sistema deve processar a locação rapidamente")
    public void verificar_locacao_rapida() {
        assertTrue(resultado.contains("locação rápida"));
    }

    @Then("o sistema deve aplicar um custo adicional devido à demanda urgente")
    public void verificar_custo_adicional() {
        assertTrue(resultado.contains("custo adicional"));
    }
}
