package exercicio_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_conta_bancaria.Banco;
import exercicio_conta_bancaria.contas.ContaCorrente;
import exercicio_conta_bancaria.contas.ContaEspecial;
import exercicio_conta_bancaria.contas.ContaPoupanca;

class BancoTest {

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
