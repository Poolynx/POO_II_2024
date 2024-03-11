package revisao_desafio_jogador.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import revisao_desafio_jogador.Campeonato;
import revisao_desafio_jogador.Jogador;
import revisao_desafio_jogador.Time;

class CampeonatoTest {
	List<Time> times;

	@BeforeEach
	void inicializar() {
		List<Jogador> jogadores1 = new ArrayList<>();
		jogadores1.add(new Jogador("N1", 1, 1));
		jogadores1.add(new Jogador("N2", 2, 2));
		jogadores1.add(new Jogador("N3", 3, 3));
		jogadores1.add(new Jogador("N4", 4, 4));
		jogadores1.add(new Jogador("N5", 5, 5));
		
		List<Jogador> jogadores2 = new ArrayList<>();
		jogadores2.add(new Jogador("N6", 6, 6));
		jogadores2.add(new Jogador("N7", 7, 7));
		jogadores2.add(new Jogador("N8", 8, 8));
		jogadores2.add(new Jogador("N9", 9, 9));
		jogadores2.add(new Jogador("N10", 10, 10));
		
		List<Jogador> jogadores3 = new ArrayList<>();
		jogadores3.add(new Jogador("Nxx", 99, 0));
		jogadores3.add(new Jogador("Nyy", 99, 0));
		
		times = new ArrayList<>();
		Time time1 = new Time("Time 1", jogadores1);
		Time time2 = new Time("Time 2", jogadores2);
		Time time3 = new Time("Time 3", jogadores3);
		
		times.add(time1);
		times.add(time2);
		times.add(time3);
	}
	
	@Test
	public void timeMaisGolsTest() {
		Time timeMaisGols = Campeonato.timeComMaisGols(times);
		assertEquals("Time 2 (5)", timeMaisGols.toString());
	}
	
	@Test
	public void artilheiroCampeonato() {
		Jogador artilheiro = Campeonato.artilheiroCampeonato(times);
		assertEquals("Jogador [nome=N10, numeroCamisa=10, gols=10]", artilheiro.toString());
	}
}
