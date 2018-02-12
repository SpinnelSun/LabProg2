package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ApostaAsseguradaTest {
	
	private ApostaAssegurada aposta1;
	private ApostaAssegurada aposta2;
	
	@Before
	public void criarApostaAssegurada() {
		aposta1 = new ApostaAssegurada("Matheus Alves", 100, "VAI ACONTECER", 10);
		aposta2 = new ApostaAssegurada("Matheus Alves", 150, "N VAI ACONTECER", 0.1);
	}
	
	@Test
	public void testApostaAsseguradaValor() {
		String msg = "Avaliação do armazenamento adequado do nome do apostador em uma ApostaAssegurada.";
		assertEquals(msg, aposta1.getApostador(), "Matheus Alves");
		
		String msg2 = "Avaliação do armazenamento adequado do valor apostado em uma Aposta.";
		assertTrue(msg2, aposta1.getValor() == 100);
		
		String msg3 = "Avaliação do armazenamento adequado da previsão positiva em uma Aposta.";
		assertTrue(msg3, aposta1.getPrevisao() == true);
	}

	@Test
	public void testPerdaGerada() {
		String msg = "Avaliação do cálculo da perda gerada por uma ApostaAssegurada por Valor.";
		assertTrue(msg, aposta1.perdaGerada() == 90);
		

		String msg2 = "Avaliação do cálculo da perda gerada por uma ApostaAssegurada por Taxa.";
		assertTrue(msg2, aposta2.perdaGerada() == 135);
	}

	@Test
	public void testToString() {
		String msg = "Avaliação da representação adequada de uma ApostaAssegurada por valor.";
		assertEquals(msg, aposta1.toString(), "Matheus Alves - R$1,00 - VAI ACONTECER - ASSEGURADA (VALOR)"
				                            + " - R$ 0,10");
		
		String msg2 = "Avaliação da representação adequada de uma ApostaAssegurada por taxa.";
		assertEquals(msg2, aposta2.toString(), "Matheus Alves - R$1,50 - N VAI ACONTECER - ASSEGURADA (TAXA)"
							                 + " - 10%");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSeguroValorInvalido() {
		String msg = "Avaliação da exceção lançada ao tentar segurar um valor muito alto na Aposta.";
		ApostaAssegurada aposta = new ApostaAssegurada("Matheus Alves", 100, "VAI ACONTECER", 101);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSeguroTaxaInvalida() {
		String msg = "Avaliação da exceção lançada ao tentar segurar uma taxa muito alto na Aposta.";
		ApostaAssegurada aposta = new ApostaAssegurada("Matheus Alves", 100, "VAI ACONTECER", 1.1);
	}

}
