package revisao_desafio_jogador.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import revisao_desafio_jogador.Jogador;
import revisao_desafio_jogador.Time;

class TimeTest {
	
	Time t1;
	Time t2;
	
	@BeforeEach
	public void inicializar() {
		List<Jogador> jogadores = new ArrayList<>();
		jogadores.add(new Jogador("N1", 1, 1));
		jogadores.add(new Jogador("N2", 2, 2));
		jogadores.add(new Jogador("N3", 3, 3));
		jogadores.add(new Jogador("N4", 4, 4));
		jogadores.add(new Jogador("N5", 5, 5));
		t1 = new Time("Time 1", jogadores);
		t2 = new Time();
	}
	
	@Test
	public void listaJogadoresTest() {
		assertEquals("Jogador [nome=N1, numeroCamisa=1, gols=1]\n"
				+"Jogador [nome=N2, numeroCamisa=2, gols=2]\n"
				+"Jogador [nome=N3, numeroCamisa=3, gols=3]\n"
				+"Jogador [nome=N4, numeroCamisa=4, gols=4]\n"
				+"Jogador [nome=N5, numeroCamisa=5, gols=5]\n", t1.listaJogadores());
		assertEquals("", t2.listaJogadores());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Time 1 (5)", t1.toString());
		assertEquals(" (0)", t2.toString());
		
	}
	
	@Test
	public void artilheiroTest() {
		assertEquals("Jogador [nome=N5, numeroCamisa=5, gols=5]", t1.artilheiroDoTime().toString());
		assertEquals("Jogador [nome=, numeroCamisa=999, gols=-1]", t2.artilheiroDoTime().toString());
	}
	
	@Test
	public void quantidadeGolsTest() {
		assertEquals(t1.golsDoTime(), 15);
		assertEquals(t2.golsDoTime(), 0);
	}
}
