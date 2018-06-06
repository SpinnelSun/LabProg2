package sorting;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import models.Cenario;
import sorting.CenarioPorApostas;

public class CenarioPorApostasTest {
	
	private Comparator<Cenario> comparator;
	
	private Cenario cenario1;
	private Cenario cenario2;
	private Cenario cenario3;
	
	@Before
	public void criaCenarios() {
		this.comparator = new CenarioPorApostas();
		
		this.cenario1 = new Cenario(1, "Cenário 1");
		this.cenario2 = new Cenario(2, "Cenário 2");
		this.cenario3 = new Cenario(3, "Cenário 3");
		
		this.cenario2.cadastrarAposta("Apostador 1", 100, "VAI ACONTECER");
		this.cenario3.cadastrarAposta("Apostador 2", 100, "N VAI ACONTECER");
	}

	@Test
	public void testCompareMenosApostasMaisApostas() {
		String msg = "Avaliação da comparação de um Cenario com outro que possua mais Apostas cadas-"
				   + "tradas.";
		assertTrue(this.comparator.compare(this.cenario1, this.cenario2) == 1); 
	}
	
	@Test
	public void testCompareMaisApostasMenosApostas() {
		String msg = "Avaliação da comparação de um Cenario com outro que possua menos Apostas cadas-"
				   + "tradas.";
		assertTrue(this.comparator.compare(this.cenario2, this.cenario1) == -1); 
	}
	
	@Test
	public void testCompareApostasIguais() {
		String msg = "Avaliação da comparação de um Cenario com outro que possua o mesmo número de "
				   + "Apostas cadastradas.";
		assertTrue(this.comparator.compare(this.cenario2, this.cenario3) == -1); 
	}

}
