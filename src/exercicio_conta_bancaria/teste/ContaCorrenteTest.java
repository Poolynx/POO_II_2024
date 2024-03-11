package exercicio_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_conta_bancaria.contas.ContaCorrente;

class ContaCorrenteTest {
	
	ContaCorrente contaCorrente1;
	ContaCorrente contaCorrente2;
	
	@BeforeEach
	public void inicializar() {
		contaCorrente1 = new ContaCorrente("1", 100.0);
		contaCorrente2 = new ContaCorrente("2", 0.0);

	}

	@Test
	public void contaCorrente_ConstrutorVazioTest() {
		ContaCorrente ctCorrente = new ContaCorrente();
		assertEquals("", ctCorrente.getIdentificadorConta());
		assertEquals(0.0, ctCorrente.getSaldoConta());
	}
	
	@Test
	public void contaCorrente_SacarComSaldoPositivoTest() {
		contaCorrente1.sacar(50.00);
		assertEquals(50.00, contaCorrente1.getSaldoConta());
	}

	@Test
	public void contaCorrente_SacarSaldoNegativoTest() {
		contaCorrente1.sacar(150.00);
		assertEquals(100.00, contaCorrente1.getSaldoConta());
	}
	
	@Test
	public void contaCorrente_TransferirSaldoPositivoTest() {
		contaCorrente1.transferencia(contaCorrente2, 50.0);
		assertEquals(50.00, contaCorrente1.getSaldoConta());
		assertEquals(50.00, contaCorrente2.getSaldoConta());
	}
	
	@Test
	public void contaCorrente_TransferirSaldoNegativoTest() {
		contaCorrente1.transferencia(contaCorrente2, 150.0);
		assertEquals(100.00, contaCorrente1.getSaldoConta());
		assertEquals(0.0, contaCorrente2.getSaldoConta());
	}

}
