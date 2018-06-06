package sorting;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import models.Cenario;
import sorting.CenarioPorApostas;

public class CenarioPorNumeracaoTest {
	
	private Comparator<Cenario> comparator;

	private Cenario cenario1;
	private Cenario cenario2;
	
	@Before
	public void criaCenarios() {
		this.comparator = new CenarioPorApostas();
		
		this.cenario1 = new Cenario(1, "Cenário 1");
		this.cenario2 = new Cenario(2, "Cenário 2");
	}

	@Test
	public void testCompareMenorNumeracaoMaiorNumeracao() {
		String msg = "Avaliação da comparação de um Cenario com outro que possua ID maior.";
		assertTrue(this.comparator.compare(this.cenario1, this.cenario2) == -1); 
	}
	
	@Test
	public void testCompareMaiorNumeracaoMenorNumeracao() {
		String msg = "Avaliação da comparação de um Cenario com outro que possua ID menor.";
		assertTrue(this.comparator.compare(this.cenario2, this.cenario1) == 1); 
	}
	
}
