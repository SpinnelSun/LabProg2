package controllers;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import models.Cenario;

public class CenarioPorDescricaoTest {

	private Comparator<Cenario> comparator;
	
	private Cenario cenario1;
	private Cenario cenario2;
	private Cenario cenario3;
	
	@Before
	public void criaCenarios() {
		this.comparator = new CenarioPorApostas();
		
		this.cenario1 = new Cenario(1, "Cenário 1");
		this.cenario2 = new Cenario(2, "Cenário 2");
		this.cenario3 = new Cenario(3, "Cenário 2");
	}

	@Test
	public void testCompareMenorDescricaoMaiorDescricao() {
		String msg = "Avaliação da comparação de um Cenario com outro que possua uma descrição lexi-"
				   + "cograficamente maior.";
		assertTrue(this.comparator.compare(this.cenario1, this.cenario2) == -1); 
	}
	
	@Test
	public void testCompareMaiorDescricaoMenorDescricao() {
		String msg = "Avaliação da comparação de um Cenario com outro que possua uma descrição lexi-"
				   + "cograficamente menor.";
		assertTrue(this.comparator.compare(this.cenario2, this.cenario1) == 1); 
	}
	
	@Test
	public void testCompareDescricoesIguais() {
		String msg = "Avaliação da comparação de um Cenario com outro que possua uma descrição lexi-"
				   + "cograficamente igual.";
		assertTrue(this.comparator.compare(this.cenario2, this.cenario3) == -1); 
	}

}
