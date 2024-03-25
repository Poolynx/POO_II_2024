package exercicio_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_conta_bancaria.contas.ContaBancaria;


class ContaBancariaTest {
	String path = "contas.txt";
	List<ContaBancaria> contas;
	ContaBancaria contaBancaria;
	
	@BeforeEach
	public void inicializar() {
		contas = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path)) ){
			String line = br.readLine();
			while(line != null) {
				String[] caracteres = line.split(",");
				contaBancaria = caracteres[0].equals("0") ? new ContaBancaria(caracteres[1], Double.parseDouble(caracteres[2])) : null;
				contas.add(contaBancaria);
				line = br.readLine();
			}
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@Test
	public void contaBancaria_DepositarTest() {
		contas.get(0).depositar(100.00);
		assertEquals(100.00, contas.get(0).getSaldoConta());
	}
	
	@Test
	public void contaBancaria_SacarTest() {
		contas.get(1).sacar(50.00);
		assertEquals(50.00, contas.get(1).getSaldoConta());
	}
	
	@Test
	public void contaBancaria_TransferirTest() {
		
		contas.get(1).transferencia(contas.get(0), 50.00);
		assertEquals(50.00, contas.get(0).getSaldoConta());
		assertEquals(50.00, contas.get(1).getSaldoConta());
	}
	
	@Test
	public void contaBancaria_SetterTest() {
		contas.get(1).setIdentificadorConta("123");
		assertEquals("123", contas.get(1).getIdentificadorConta());
	}

}
