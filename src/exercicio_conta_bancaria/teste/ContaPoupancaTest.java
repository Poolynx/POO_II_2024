package exercicio_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_conta_bancaria.contas.ContaPoupanca;

class ContaPoupancaTest {


	ContaPoupanca contaPoupanca1;

	
	@BeforeEach
	public void inicializar() {
		contaPoupanca1 = new ContaPoupanca("4", 100.00);
	}
	
	@Test
	public void contaPoupanca_ConstrutorVazioTest() {
		ContaPoupanca ct = new ContaPoupanca();
		assertEquals("", ct.getIdentificadorConta());
		assertEquals(0.0, ct.getSaldoConta());
	}
	
	@Test
	public void contaPoupanca_SacarSemSaldoDisponivel() {
		contaPoupanca1.sacar(300.00);
		assertEquals(100.00, contaPoupanca1.getSaldoConta());
	}
	
	@Test
	public void contaPoupanca_SacarCincoVezes() {
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		assertEquals(50.00, contaPoupanca1.getSaldoConta());
	}
	
	@Test
	public void contaPoupanca_SacarMaisDeCincoVezes() {
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		assertEquals(50.00, contaPoupanca1.getSaldoConta());
	}
	
	@Test
	public void contaPoupanca_SacarMaisDeCincoVezesMudandoMes() {
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		
		contaPoupanca1.setMes(4);
		
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		contaPoupanca1.sacar(10.0);
		assertEquals(0.0, contaPoupanca1.getSaldoConta());
	}

}
