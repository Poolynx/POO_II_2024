package revisao_desafio_jogador;

import java.util.List;

public class Campeonato {
	public static Time timeComMaisGols(List<Time> times) {
		Time timeMaisGols = times.get(0);
		for(Time t : times) {
			if(t.golsDoTime() > timeMaisGols.golsDoTime()) {
				timeMaisGols = t;
			}
		}
		
		return timeMaisGols;
	}
	
public static Jogador artilheiroCampeonato(List<Time> times) {
		Jogador artilheiroCampeonato = times.get(0).artilheiroDoTime();
		for(Time t : times) {
			if(t.artilheiroDoTime().getGols() > artilheiroCampeonato.getGols()) {
				artilheiroCampeonato = t.artilheiroDoTime();
			}
		}
		
		return artilheiroCampeonato;
		
	}
}
