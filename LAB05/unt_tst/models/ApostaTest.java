package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ApostaTest {
	
	private Aposta aposta1;
	private Aposta aposta2;
	
	@Before
	public void criarAposta() {
		aposta1 = new Aposta("Matheus Alves", 100, "VAI ACONTECER");
		aposta2 = new Aposta("Matheus Alves", 150, "N VAI ACONTECER");
	}

	@Test
	public void testAposta() {
		String msg = "Avaliação do armazenamento adequado do nome do apostador em uma Aposta.";
		assertEquals(msg, aposta1.getApostador(), "Matheus Alves");
		
		String msg2 = "Avaliação do armazenamento adequado do valor apostado em uma Aposta.";
		assertTrue(msg2, aposta1.getValor() == 100);
		
		String msg3 = "Avaliação do armazenamento adequado da previsão positiva em uma Aposta.";
		assertTrue(msg3, aposta1.getPrevisao() == true);
		
		String msg4 = "Avaliação do armazenamento adequado da previsão negativa em uma Aposta.";
		assertTrue(msg4, aposta2.getPrevisao() == false);
	}
	
	@Test
	public void testPerdaGerada() {
		String msg = "Avaliação da perda gerada por um Aposta sem Seguro.";
		assertEquals(msg, aposta1.perdaGerada(), aposta1.getValor());
	}

	@Test
	public void testToString() {
		String msg = "Avaliação da representação adequada de uma Aposta com previsão positiva.";
		assertEquals(msg, aposta1.toString(), "Matheus Alves - R$1,00 - VAI ACONTECER");
		
		String msg2 = "Avaliação da representação adequada de uma Aposta com previsão negativa.";
		assertEquals(msg2, aposta2.toString(), "Matheus Alves - R$1,50 - N VAI ACONTECER");
	}
	
	@Test(expected = NullPointerException.class)
	public void testApostadorNulo() {
		String msg = "Avaliação da exceção lançada ao criar uma Aposta com nome de apostador nulo.";
		Aposta aposta = new Aposta(null, 100, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostadorVazio() {
		String msg = "Avaliação da exceção lançada ao criar uma Aposta com nome de apostador vazio.";
		Aposta aposta = new Aposta("   ", 100, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorZero() {
		String msg = "Avaliação da exceção lançada ao criar uma Aposta com valor zero.";
		Aposta aposta = new Aposta("Matheus Alves", 0, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorNegativo() {
		String msg = "Avaliação da exceção lançada ao criar uma Aposta com valor negativo.";
		Aposta aposta = new Aposta("Matheus Alves", -1, "VAI ACONTECER");
	}

	@Test(expected = NullPointerException.class)
	public void testPrevisaoNula() {
		String msg = "Avaliação da exceção lançada ao criar uma Aposta com texto de previsão nulo.";
		Aposta aposta = new Aposta("Matheus Alves", 100, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPrevisaoVazia() {
		String msg = "Avaliação da exceção lançada ao criar uma Aposta com texto de previsão vazio.";
		Aposta aposta = new Aposta("Matheus Alves", 100, "   ");
	}

}
