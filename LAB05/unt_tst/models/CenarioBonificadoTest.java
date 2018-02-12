package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CenarioBonificadoTest {
	
	private CenarioBonificado cenario1;
	private CenarioBonificado cenario2;
	private CenarioBonificado cenario3;
	
	@Before
	public void criarCenarioBonificado() {
		cenario1 = new CenarioBonificado(1, "Matheus vai sobreviver a essa semana", 1000);
		cenario2 = new CenarioBonificado(2, "Matheus vai tirar 10 no LAB05", 2000);
		
		cenario1.cadastrarAposta("Matheus Alves", 10000, "N VAI ACONTECER");
	}
	
	@Test
	public void testCenarioBonificado() {
		String msg = "Avaliação do armazenamento adequado da numeração em um CenarioBonificado.";
		assertTrue(msg, cenario1.getNumeracao() == 1);
		
		String msg2 = "Avaliação do armazenamento adequado da descrição em um CenarioBonificado.";
		assertEquals(msg2, cenario1.getDescricao(), "Matheus vai sobreviver a essa semana");
		
		String msg3 = "Avaliação da criação de um CenarioBonificado com o estado adequado.";
		assertEquals(msg3, cenario1.getEstado(), Estado.NAO_FINALIZADO);
		
		String msg4 = "Avaliação da criação de um CenarioBonificado com o bônus adequado.";
		assertTrue(msg4, cenario1.getBonus() == 1000);
	}

	@Test
	public void testRateioCenario() {
		cenario1.defineOcorrencia(true);
		String msg = "Avaliação do valor de rateio gerado no encerramento de um CenarioBonificado.";
		assertTrue(msg, cenario1.rateioCenario(0.1) == 10000);
	}

	@Test
	public void testToString() {
		String msg = "Avaliação da representação textual de um CenarioBonificado aberto.";
		assertEquals(msg, cenario1.toString(), "1 - Matheus vai sobreviver a essa semana - Nao finalizado"
				                             + " - R$ 10,00");
		
		cenario1.defineOcorrencia(true);
		String msg2 = "Avaliação da representação textual de um CenarioBonificado finalizado que ocorreu.";
		assertEquals(msg2, cenario1.toString(), "1 - Matheus vai sobreviver a essa semana - Finalizado "
											  + "(ocorreu) - R$ 10,00");
		
		cenario2.defineOcorrencia(false);
		String msg3 = "Avaliação da representação textual de um CenarioBonificado finalizado que não ocorreu.";
		assertEquals(msg3, cenario2.toString(), "2 - Matheus vai tirar 10 no LAB05 - Finalizado (n ocorreu)"
				                              + " - R$ 20,00");
	}

}
