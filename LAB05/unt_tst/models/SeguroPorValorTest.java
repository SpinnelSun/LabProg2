package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeguroPorValorTest {
	
	private SeguroPorValor seguro1;
	
	@Before
	public void criarSeguroPorValor() {
		seguro1 = new SeguroPorValor(1000);
	}

	@Test
	public void testSeguroPorValor() {
		String msg = "Avaliação do armazenamento adequado do valor assegurado no SeguroPorValor.";
		assertTrue(msg, seguro1.getValorAssegurado() == 1000);
	}

	@Test
	public void testQuantiaAssegurada() {
		String msg = "Avaliação do cálculo adequado da quantia assegurada no SeguroPorValor.";
		assertEquals(msg, seguro1.quantiaAssegurada(1000), seguro1.getValorAssegurado());
	}

	@Test
	public void testToString() {
		String msg = "Avaliação da representação adequada de um SeguroPorValor.";
		assertEquals(msg, seguro1.toString(), "ASSEGURADA (VALOR) - R$ 10,00");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSeguroValorZero() {
		String msg = "Avaliação da exceção lançada ao tentar segurar um valor 0 no SeguroPorValor.";
		SeguroPorValor seguroZero = new SeguroPorValor(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSeguroValorNegativo() {
		String msg = "Avaliação da exceção lançada ao tentar segurar um valor negativo no SeguroPorValor.";
		SeguroPorValor seguroNegativo = new SeguroPorValor(-1);
	}

}
