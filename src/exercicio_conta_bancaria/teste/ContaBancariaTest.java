package exercicio_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_conta_bancaria.contas.ContaBancaria;


class ContaBancariaTest {

	ContaBancaria contaBancaria1;
	
	
	@BeforeEach
	public void inicializar() {

		contaBancaria1 = new ContaBancaria();

	}
	
	@Test
	public void contaBancaria_DepositarTest() {
		ContaBancaria ct = new ContaBancaria();
		ct.depositar(100.00);
		assertEquals(100.00, ct.getSaldoConta());
	}
	
	@Test
	public void contaBancaria_SacarTest() {
		ContaBancaria ct = new ContaBancaria("123", 100.00);
		ct.sacar(50.00);
		assertEquals(50.00, ct.getSaldoConta());
	}
	
	@Test
	public void contaBancaria_TransferirTest() {
		ContaBancaria ct = new ContaBancaria("123", 100.00);
		ct.transferencia(contaBancaria1, 50.00);
		assertEquals(50.00, ct.getSaldoConta());
		assertEquals(50.00, contaBancaria1.getSaldoConta());
	}
	
	@Test
	public void contaBancaria_SetterTest() {
		ContaBancaria ct = new ContaBancaria();
		ct.setIdentificadorConta("123");
		assertEquals("123", ct.getIdentificadorConta());
	}

}
