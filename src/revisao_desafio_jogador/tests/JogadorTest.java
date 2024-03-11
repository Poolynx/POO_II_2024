package revisao_desafio_jogador.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import revisao_desafio_jogador.Jogador;

class JogadorTest {
	
	Jogador j1;
	Jogador j2;
	
	@BeforeEach
	public void inicializarJogadores() {
		j1 = new Jogador();
		j2 = new Jogador("John Green", 10, 3);
	}
	
	@Test
	public void construtorVazioTest() {
		assertEquals(999, j1.getNumeroCamisa());
		assertEquals(-1, j1.getGols());
		assertEquals("", j1.getNome());
		
		assertEquals("Jogador [nome=, numeroCamisa=999, gols=-1]", j1.toString());
	}
	
	@Test
	public void construtorPreenchidoTest() {
		assertEquals(10, j2.getNumeroCamisa());
		assertEquals(3, j2.getGols());
		assertEquals("John Green", j2.getNome());
		
		assertEquals("Jogador [nome=John Green, numeroCamisa=10, gols=3]", j2.toString());
	}
}
