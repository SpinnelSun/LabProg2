package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeguroPorTaxaTest {
	
private SeguroPorTaxa seguro1;
	
	@Before
	public void criarSeguroPorTaxa() {
		seguro1 = new SeguroPorTaxa(0.1);
	}

	@Test
	public void testSeguroPorTaxa() {
		String msg = "Avaliação do armazenamento adequado da taxa assegurada no SeguroPorTaxa.";
		assertTrue(msg, seguro1.getTaxaAssegurada() == 0.1);
	}

	@Test
	public void testQuantiaAssegurada() {
		String msg = "Avaliação do cálculo adequado da quantia assegurada no SeguroPorValor.";
		assertEquals(msg, seguro1.quantiaAssegurada(1000), 100);
	}

	@Test
	public void testToString() {
		String msg = "Avaliação da representação adequada de um SeguroPorTaxa.";
		assertEquals(msg, seguro1.toString(), "ASSEGURADA (TAXA) - 10%");
	}

}
