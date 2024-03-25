package exercicio_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_conta_bancaria.Banco;
import exercicio_conta_bancaria.contas.ContaBancaria;
import exercicio_conta_bancaria.contas.ContaCorrente;
import exercicio_conta_bancaria.contas.ContaEspecial;
import exercicio_conta_bancaria.contas.ContaPoupanca;

class BancoTest {
	Banco banco;
	String path = "contas.txt";
	ContaBancaria contaBancaria;
	
	@BeforeEach
	public void inicializar() {
		banco = new Banco();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path)) ){
			String line = br.readLine();
			while(line != null) {
				String[] caracteres = line.split(",");
				if(caracteres[0].equals("0")) {
					contaBancaria = new ContaBancaria(caracteres[1], Double.parseDouble(caracteres[2]));
					banco.addConta(contaBancaria);
				}
				if(caracteres[0].equals("1")) {
					contaBancaria = new ContaCorrente(caracteres[1], Double.parseDouble(caracteres[2]));
					banco.addConta(contaBancaria);
				}
				if(caracteres[0].equals("2")) {
					contaBancaria = new ContaEspecial(caracteres[1], Double.parseDouble(caracteres[2]), Double.parseDouble(caracteres[3]));
					banco.addConta(contaBancaria);
				}
				if(caracteres[0].equals("3")) {
					contaBancaria = new ContaPoupanca(caracteres[1], Double.parseDouble(caracteres[2]));
					banco.addConta(contaBancaria);
				}
				line = br.readLine();
			}
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@Test
	public void banco_ConstrutorCheioTest() {
		Banco bancoCheio = new Banco(banco.getContas().get(0));
		assertEquals(1, bancoCheio.getContas().size());
	}
	
	@Test
	public void banco_AdicionarSemNomeRepetido() {
		banco.addConta(new ContaCorrente("8", 10.00));
		assertEquals(9, banco.getContas().size());
	}
	
	@Test
	public void banco_AdicionarNomeRepetido() {
		banco.addConta(new ContaCorrente("1", 10.00));
		assertEquals(8, banco.getContas().size());
	}
}
