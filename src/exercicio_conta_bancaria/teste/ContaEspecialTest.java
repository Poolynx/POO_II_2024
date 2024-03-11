package exercicio_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_conta_bancaria.contas.ContaEspecial;



class ContaEspecialTest {

	
	ContaEspecial contaEspecial1;
	ContaEspecial contaEspecial2;

	@BeforeEach
	public void inicializar() {

		contaEspecial1 = new ContaEspecial("3", 100.0, 50.00);
		contaEspecial2 = new ContaEspecial();

	}
	
	@Test
	public void contaEspecial_ConstrutorVazioTest() {
		ContaEspecial ct = new ContaEspecial();
		assertEquals("", ct.getIdentificadorConta());
		assertEquals(0.0, ct.getSaldoConta());
		assertEquals(0.0, ct.getLimiteEspecial());
	}
	
	@Test
	public void contaEspecial_SetterTest() {
		ContaEspecial ct = new ContaEspecial();
		ct.setLimiteEspecial(200.00);
		assertEquals(200.0, ct.getLimiteEspecial());
	}
	
	@Test
	public void contaEspecial_SacarComSaldoPositivoTest() {
		contaEspecial1.sacar(50.00);
		assertEquals(50.00, contaEspecial1.getSaldoConta());
	}
	
	@Test
	public void contaEspecial_SacarComSaldoNegativoMasLimitePositivoTest() {
		contaEspecial1.sacar(150.00);
		assertEquals(-50.00, contaEspecial1.getSaldoConta());
	}
	
	@Test
	public void contaEspecial_SacarComSaldoNegativoMasLimiteNegativoTest() {
		contaEspecial1.sacar(200.00);
		assertEquals(100.00, contaEspecial1.getSaldoConta());
	}
	
	@Test
	public void contaEspecial_TransferirComSaldoPositivoTest() {
		contaEspecial1.transferencia(contaEspecial2, 70.00);
		assertEquals(30.00, contaEspecial1.getSaldoConta());
		assertEquals(70.00, contaEspecial2.getSaldoConta());
	}
	
	@Test
	public void contaEspecial_TransferirComSaldoNegativoMasLimitePositivoTest() {
		contaEspecial1.transferencia(contaEspecial2, 150.00);
		assertEquals(-50.0, contaEspecial1.getSaldoConta());
		assertEquals(150.00, contaEspecial2.getSaldoConta());
	}
	
	@Test
	public void contaEspecial_TransferirComSaldoNegativoLimiteEstourado() {
		contaEspecial1.transferencia(contaEspecial2, 200.00);
		assertEquals(100.0, contaEspecial1.getSaldoConta());
		assertEquals(0.0, contaEspecial2.getSaldoConta());
	}

}
