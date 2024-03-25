package exercicio_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_conta_bancaria.contas.ContaPoupanca;

class ContaPoupancaTest {
	String path = "contas.txt";
	List<ContaPoupanca> contas;
	ContaPoupanca contaPoupanca;
	
	@BeforeEach
	public void inicializar() {
		contas = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path)) ){
			String line = br.readLine();
			while(line != null) {
				String[] caracteres = line.split(",");
				if(caracteres[0].equals("3")) {
					contaPoupanca = new ContaPoupanca(caracteres[1], Double.parseDouble(caracteres[2]));
					contas.add(contaPoupanca);
				}
				line = br.readLine();
			}
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@Test
	public void contaPoupanca_ConstrutorVazioTest() {
		ContaPoupanca ct = new ContaPoupanca();
		assertEquals("", ct.getIdentificadorConta());
		assertEquals(0.0, ct.getSaldoConta());
	}
	
	@Test
	public void contaPoupanca_SacarSemSaldoDisponivel() {
		contas.get(1).sacar(300.00);
		assertEquals(100.00, contas.get(1).getSaldoConta());
	}
	
	@Test
	public void contaPoupanca_SacarCincoVezes() {
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		assertEquals(50.00, contas.get(1).getSaldoConta());
	}
	
	@Test
	public void contaPoupanca_SacarMaisDeCincoVezes() {
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		assertEquals(50.00, contas.get(1).getSaldoConta());
	}
	
	@Test
	public void contaPoupanca_SacarMaisDeCincoVezesMudandoMes() {
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		
		contas.get(1).setMes(4);
		
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		contas.get(1).sacar(10.0);
		assertEquals(0.0, contas.get(1).getSaldoConta());
	}

}
