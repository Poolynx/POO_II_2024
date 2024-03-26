package quizz_perguntas_professor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Tests {

private Joguinho jogo = new Joguinho();
	
	@Test
	void carregarJoguinhoTest() {
		jogo.lerArquivo();
		assertEquals(50, jogo.getPerguntas().size());
		Pergunta terceira = jogo.getPerguntas().get(2);
		assertEquals("O sangue humano é azul dentro do corpo e se torna vermelho quando exposto ao oxigênio", terceira.getTitulo());
		assertEquals(false, terceira.isRespostaCorreta());
	}
	
	@Test
	void fazCorrecaoTest() {
		Pergunta pergunta = new Pergunta("ABCD é EFGH,Falso");
		Resposta r = new Resposta(pergunta,false);
		assertEquals("acerto", r.correcao());
	}
	
	@Test
	void fazCorrecaoErroTest() {
		Pergunta pergunta = new Pergunta("ABCD é EFGH,Falso");
		Resposta r = new Resposta(pergunta,true);
		assertEquals("erro", r.correcao());
	}
	
	@Test
	void calcularPontuacaoTest() {
		
	}
	@Test
	void calculaPotuacaoTest() {
		assertEquals(2, jogo.calculaPontuacao(respostasControladas()));
	}
	
	@Test
	void gravarRespostTest() {
		ArrayList<Resposta> respostas = respostasControladas();
		jogo.gravaResultado(respostas);
		String conteuArg = jogo.lerResposta();
		assertEquals(
				"1,a,acerto\n"
				+ "2,b,acerto\n"
				+ "3,c,erro\n"
				+ "4,d,erro\n", conteuArg);
	}
	
	
	
	private ArrayList<Resposta> respostasControladas(){
		ArrayList<Resposta> respostas = new ArrayList<Resposta>();
		Pergunta pa = new Pergunta("a", false);
		Pergunta pb = new Pergunta("b", false);
		Pergunta pc = new Pergunta("c", true);
		Pergunta pd = new Pergunta("d", true);
		respostas.add(new Resposta(pa,false));
		respostas.add(new Resposta(pb,false));
		respostas.add(new Resposta(pc,false));
		respostas.add(new Resposta(pd,false));
		return respostas;
		}

	
	@Test
	void sorteiaRodada() {
		jogo.lerArquivo();
		Pergunta primeira = jogo.getPerguntas().get(0);
		Pergunta segunda = jogo.getPerguntas().get(1);
		assertEquals("A Lua é o maior satélite natural da Terra", primeira.getTitulo());
		assertEquals("A Grande Muralha da China é visível do espaço", segunda.getTitulo());
		
		ArrayList<Pergunta> sorteadas = jogo.sorteiaRodada(10);
		
		primeira = sorteadas.get(0);
		segunda = sorteadas.get(1);
		assertNotEquals("A Lua é o maior satélite natural da Terra", primeira.getTitulo());
		assertNotEquals("A Grande Muralha da China é visível do espaço", segunda.getTitulo());
		assertEquals(10, sorteadas.size());
		
	}

}
