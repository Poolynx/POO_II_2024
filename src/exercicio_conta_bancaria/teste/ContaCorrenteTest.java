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
import exercicio_conta_bancaria.contas.ContaCorrente;

class ContaCorrenteTest {
	
	String path = "contas.txt";
	List<ContaBancaria> contas;
	ContaCorrente contaCorrente;
	
	@BeforeEach
	public void inicializar() {
		contaCorrente = new ContaCorrente();
		contas = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path)) ){
			String line = br.readLine();
			while(line != null) {
				String[] caracteres = line.split(",");
				if(caracteres[0].equals("1")) {
					contaCorrente = new ContaCorrente(caracteres[1], Double.parseDouble(caracteres[2]));
					contas.add(contaCorrente);
				}
				line = br.readLine();
			}
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	


	
	@Test
	public void contaCorrente_SacarComSaldoPositivoTest() {
		contas.get(1).sacar(50.00);
		assertEquals(50.00, contas.get(1).getSaldoConta());
	}

	@Test
	public void contaCorrente_SacarSaldoNegativoTest() {
		contas.get(1).sacar(150.00);
		assertEquals(100.00, contas.get(1).getSaldoConta());
	}
	
	@Test
	public void contaCorrente_TransferirSaldoPositivoTest() {
		contas.get(1).transferencia(contas.get(0), 50.0);
		assertEquals(50.00, contas.get(0).getSaldoConta());
		assertEquals(50.00, contas.get(1).getSaldoConta());
	}
	
	@Test
	public void contaCorrente_TransferirSaldoNegativoTest() {
		contas.get(1).transferencia(contas.get(0), 150.0);
		assertEquals(100.00, contas.get(1).getSaldoConta());
		assertEquals(0.0, contas.get(0).getSaldoConta());
	}

}
