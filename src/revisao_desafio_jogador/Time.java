package revisao_desafio_jogador;

import java.util.ArrayList;
import java.util.List;

public class Time {
	private String nome;
	private List<Jogador> jogadores;
	
	public Time() {
		setNome("");
		jogadores = new ArrayList<>();
	}

	public Time(String nome, List<Jogador> jogadores) {
		this.nome = nome;
		this.jogadores = jogadores;
	}
	
	public Time(String nome, Jogador jogador) {
		this.nome = nome;
		this.jogadores = new ArrayList<>();
		this.jogadores.add(jogador);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	@Override
	public String toString() {
		return getNome() + " ("+getJogadores().size()+")";
	}	
	
	public String listaJogadores() {
		String retorno = "";
		for(Jogador j : jogadores) {
			retorno += j + "\n";
		}
		return retorno;
	}
	
	public Jogador artilheiroDoTime() {
		Jogador artilheiro = new Jogador();
		
		for(Jogador j : jogadores) {
			if(j.getGols() > artilheiro.getGols()) {
				artilheiro = j;
			}			
		}
		
		return artilheiro;
	}
	
	public int golsDoTime() {
		int qntGols = 0;
		
		for(Jogador j : jogadores) {
			qntGols += j.getGols();		
		}
		
		return qntGols;
	}
}
