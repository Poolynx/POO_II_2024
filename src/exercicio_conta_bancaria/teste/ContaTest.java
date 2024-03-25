package exercicio_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_conta_bancaria.Banco;
import exercicio_conta_bancaria.contas.ContaBancaria;
import exercicio_conta_bancaria.contas.ContaCorrente;
import exercicio_conta_bancaria.contas.ContaEspecial;
import exercicio_conta_bancaria.contas.ContaPoupanca;

class ContaTest {
	
	ContaCorrente contaCorrente1;
	ContaCorrente contaCorrente2;
	ContaEspecial contaEspecial1;
	ContaPoupanca contaPoupanca1;
	Banco banco;
	
	@BeforeEach
	public void inicializar() {
		contaCorrente1 = new ContaCorrente("1", 100.0);
		contaCorrente2 = new ContaCorrente("2", 0.0);
		contaEspecial1 = new ContaEspecial("3", 100.0, 50.00);
		contaPoupanca1 = new ContaPoupanca("4", 100.00);
		banco = new Banco();
		banco.addConta(contaCorrente1);
		banco.addConta(contaCorrente2);
		banco.addConta(contaEspecial1);
		banco.addConta(contaPoupanca1);
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
		ct.transferencia(contaCorrente2, 50.00);
		assertEquals(50.00, ct.getSaldoConta());
		assertEquals(50.00, contaCorrente2.getSaldoConta());
	}
	
	@Test
	public void contaBancaria_SetterTest() {
		ContaBancaria ct = new ContaBancaria();
		ct.setIdentificadorConta("123");
		assertEquals("123", ct.getIdentificadorConta());
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
		contaEspecial1.transferencia(contaCorrente2, 70.00);
		assertEquals(30.00, contaEspecial1.getSaldoConta());
		assertEquals(70.00, contaCorrente2.getSaldoConta());
	}
	
	@Test
	public void contaEspecial_TransferirComSaldoNegativoMasLimitePositivoTest() {
		contaEspecial1.transferencia(contaCorrente2, 150.00);
		assertEquals(-50.0, contaEspecial1.getSaldoConta());
		assertEquals(150.00, contaCorrente2.getSaldoConta());
	}
	
	@Test
	public void contaEspecial_TransferirComSaldoNegativoLimiteEstourado() {
		contaEspecial1.transferencia(contaCorrente2, 200.00);
		assertEquals(100.0, contaEspecial1.getSaldoConta());
		assertEquals(0.0, contaCorrente2.getSaldoConta());
	}
	
	@Test
	public void contaPoupanca_ConstrutorVazioTest() {
		ContaPoupanca ct = new ContaPoupanca();
		assertEquals("", ct.getIdentificadorConta());
		assertEquals(0.0, ct.getSaldoConta());
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
	
	@Test
	public void banco_ConstrutorCheioTest() {
		Banco bancoCheio = new Banco(contaPoupanca1);
		assertEquals(1, bancoCheio.getContas().size());
	}
	
	@Test
	public void banco_AdicionarSemNomeRepetido() {
		banco.addConta(new ContaCorrente("5", 10.00));
		assertEquals(5, banco.getContas().size());
	}
	
	@Test
	public void banco_AdicionarNomeRepetido() {
		banco.addConta(new ContaCorrente("1", 10.00));
		assertEquals(4, banco.getContas().size());
	}

}
