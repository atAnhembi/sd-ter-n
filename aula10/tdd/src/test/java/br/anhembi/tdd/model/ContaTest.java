package br.anhembi.tdd.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// padrão de nome
// aoFazerX_dadoQue_Espero

//  Teste: preparação - ação - verificação

public class ContaTest {

    private Conta conta;

    @BeforeEach
    void setup() {
        int numeroConta = 123;
        conta = new Conta(numeroConta);
    }


    @Test
    void criarConta_numeroContaValido_contaCriadaSucesso(){
        int numeroConta = 123;

        Conta conta = new Conta(numeroConta);

        assertThat(conta).isNotNull();
    }
    
    @Test
    void criarConta_numeroContaValido_numeroContaSejaCorreto(){
        int numeroConta = 123;

        Conta conta = new Conta(numeroConta);

        assertThat(conta.getNumero()).isEqualTo(numeroConta);
    }

    @Test
    void criarConta_numeroContaValido_saldoSeraZero(){
        int numeroConta = 123;

        Conta conta = new Conta(numeroConta);

        assertThat(conta.getSaldo()).isEqualTo(0);
    }

    @Test
    void depositar_numeroContaValido_saldoSomaDeposito(){
        double valorDeposito = 100;

        conta.depositar(valorDeposito);

        assertThat(conta.getSaldo()).isEqualTo(valorDeposito);
    }

    @Test
    void depositar_numeroContaValidoValorInvalido_saldoNaoAltere(){
        double valorDeposito = -100;

        conta.depositar(valorDeposito);

        assertThat(conta.getSaldo()).isEqualTo(0);
    }

    @Test
    void sacar_numeroContaValidaValorValido_saldoCorreto(){
        double valorSaque = 100;
        double valorDiferenca = 50;
        conta.depositar(valorSaque + valorDiferenca);

        conta.sacar(valorSaque);

        assertThat(conta.getSaldo()).isEqualTo(valorDiferenca);
    }

    @Test
    void sacar_numeroContaValidaValorInValido_saldoSemAlteracao(){
        double valorSaque = -100;

        conta.sacar(valorSaque);

        assertThat(conta.getSaldo()).isEqualTo(0);
    }

    @Test
    void sacar_numeroContaValidaSaldoInsuficiente_saldoSemAlteracao(){
        double valorSaque = 100;

        boolean resultado =  conta.sacar(valorSaque);

        assertThat(conta.getSaldo()).isEqualTo(0);
        assertThat(resultado).isFalse();
    }


}
