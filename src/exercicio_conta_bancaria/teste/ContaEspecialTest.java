package exercicio_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_conta_bancaria.contas.ContaEspecial;



class ContaEspecialTest {
	String path = "contas.txt";
	List<ContaEspecial> contas;
	ContaEspecial contaEspecial;
	
	@BeforeEach
	public void inicializar() {
		contas = new ArrayList<>();
		contaEspecial = new ContaEspecial();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path)) ){
			String line = br.readLine();
			while(line != null) {
				String[] caracteres = line.split(",");
				if(caracteres[0].equals("2")) {
					contaEspecial = new ContaEspecial(caracteres[1], Double.parseDouble(caracteres[2]), Double.parseDouble(caracteres[3]));
					contas.add(contaEspecial);
				}
				line = br.readLine();
			}
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	@Test
	public void contaEspecial_SetterTest() {
		contas.get(0).setLimiteEspecial(200.00);
		assertEquals(200.0, contas.get(0).getLimiteEspecial());
	}
	
	@Test
	public void contaEspecial_SacarComSaldoPositivoTest() {
		contas.get(1).sacar(50.00);
		assertEquals(50.00, contas.get(1).getSaldoConta());
	}
	
	@Test
	public void contaEspecial_SacarComSaldoNegativoMasLimitePositivoTest() {
		contas.get(1).sacar(150.00);
		assertEquals(-50.00, contas.get(1).getSaldoConta());
	}
	
	@Test
	public void contaEspecial_SacarComSaldoNegativoMasLimiteNegativoTest() {
		contas.get(1).sacar(200.00);
		assertEquals(100.00, contas.get(1).getSaldoConta());
	}
	
	@Test
	public void contaEspecial_TransferirComSaldoPositivoTest() {
		contas.get(1).transferencia(contas.get(0), 70.00);
		assertEquals(30.00, contas.get(1).getSaldoConta());
		assertEquals(70.00, contas.get(0).getSaldoConta());
	}
	
	@Test
	public void contaEspecial_TransferirComSaldoNegativoMasLimitePositivoTest() {
		contas.get(1).transferencia(contas.get(0), 150.00);
		assertEquals(-50.0, contas.get(1).getSaldoConta());
		assertEquals(150.00, contas.get(0).getSaldoConta());
	}
	
	@Test
	public void contaEspecial_TransferirComSaldoNegativoLimiteEstourado() {
		contas.get(1).transferencia(contas.get(0), 200.00);
		assertEquals(100.0, contas.get(1).getSaldoConta());
		assertEquals(0.0, contas.get(0).getSaldoConta());
	}

}
