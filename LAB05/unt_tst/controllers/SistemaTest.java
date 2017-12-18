package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import models.Cenario;

public class SistemaTest {
	
	private Sistema sistema1;
	private Sistema sistema2;
	private Sistema sistema3;
	
	@Before
	public void criarSistema() {
		sistema1 = new Sistema(1000, 0.1);
		sistema2 = new Sistema(1000, 0.1);
		sistema3 = new Sistema(1000, 0.1);
		
		sistema2.cadastrarCenario("O novo anime de Sakura Card Captors vai ser lindo");
		sistema3.cadastrarCenario("Eu vou conseguir terminar esse Lab antes das 17h");
		
		sistema3.cadastrarAposta(1, "Matheus Alves", 10000, "N VAI ACONTECER");
		sistema3.cadastrarAposta(1, "Sevla Suetham", 15000, "N VAI ACONTECER");
		sistema3.cadastrarAposta(1, "Lasev Hamsuet", 12525, "VAI ACONTECER");
		sistema3.cadastrarAposta(1, "Vesla Teusmah", 15252, "VAI ACONTECER");
		sistema3.cadastrarAposta(1, "Alsev Hamteus", 21521, "VAI ACONTECER");
	}

	@Test
	public void testSistema() {
		String msg = "Avaliação do armazenamento adequado do caixa em um Sistema.";
		assertTrue(msg, sistema1.getCaixa() == 1000);
		
		String msg2 = "Avaliação do armazenamento adequado da taxa em um Sistema.";
		assertTrue(msg2, sistema1.getTaxa() == 0.1);
		
		String msg3 = "Avaliação da criação da lista de Cenarios em um Sistema (ainda vazia).";
		assertTrue(msg3, sistema1.getQtdCenarios() == 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testOperarCenarioZero() {
		String msg = "Avaliação da exceção lançada ao se tentar acessar um Cenario com numeração zero.";
		sistema2.cadastrarAposta(0, "Matheus Alves", 10000, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testOperarCenarioNegativo() {
		String msg = "Avaliação da exceção lançada ao se tentar acessar um Cenario com numeração negativa.";
		sistema2.cadastrarAposta(-1, "Matheus Alves", 10000, "VAI ACONTECER");
	}
	


	@Test
	public void testCadastrarCenario() {
		sistema1.cadastrarCenario("O calendário vai regularizar em 2018");
		String msg = "Avaliação do armazenamento adequado de um novo Cenario no Sistema.";
		assertTrue(msg, sistema1.getQtdCenarios() == 1);
	}

	@Test
	public void testExibirCenario() {
		String msg = "Avaliação da equivalência entre a exibição de um Cenário e seu toString.";
		assertEquals(msg, sistema2.exibirCenario(1), "1 - O novo anime de Sakura Card Captors vai ser lindo "
				                                   + "- Nao finalizado");
	}

	@Test
	public void testListarCenarios() {
		String listagemEsperada = "";
		
		String msg = "Avaliação da listagem de Cenarios de um Sistema sem Cenarios registrados.";
		assertEquals(msg, sistema1.listarCenarios(), listagemEsperada);
		
		listagemEsperada += "1 - O novo anime de Sakura Card Captors vai ser lindo - Nao finalizado"
		                    + System.lineSeparator();
		String msg2 = "Avaliação da listagem de Cenarios de um Sistema com um Cenario registrado.";
		assertEquals(msg2, sistema2.listarCenarios(), listagemEsperada);
		
		sistema2.cadastrarCenario("O novo filme de Star Wars vai ser um pisão");
		listagemEsperada += "2 - O novo filme de Star Wars vai ser um pisão - Nao finalizado"
                            + System.lineSeparator();
		String msg3 = "Avaliação da listagem de Cenarios de um Sistema com vários Cenarios registrados.";
		assertEquals(msg3, sistema2.listarCenarios(), listagemEsperada);
	}
	
	
	/*
	 * Muitos métodos do Sistema consistem apenas em validar a numeração ou o estado de um Cenario e, em
	 * seguida, a execução de um método daquele Cenario. Visto que todos os métodos de Cenario já foram
	 * testados previamente, e que as validações estão sendo feitas adequadamentes conforme testes, não
	 * há a necessidade de criação de novos (e redundantes) testes para esses métodos.
	 * 
	 */
	

	@Test
	public void testLucroCenario() {
		sistema3.encerrarCenario(1, false);
		String msg = "Avaliação do cálculo adequado do lucro de um Cenário encerrado.";
		assertTrue(msg, sistema3.lucroCenario(1) == 4929);
	}

	@Test
	public void testRateioCenario() {
		sistema3.encerrarCenario(1, false);
		String msg = "Avaliação do cálculo adequado do valor para rateio de um Cenário encerrado.";
		assertTrue(msg, sistema3.rateioCenario(1) == 44369);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCaixaNegativo() {
		String msg = "Avaliação da inicialização do caixa de um Sistema com valor negativo.";
		Sistema sistema = new Sistema(-1, 0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTaxaNegativa() {
		String msg = "Avaliação da inicialização da taxa de um Sistema com valor negativo.";
		Sistema sistema = new Sistema(1000, -0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTaxaInvalida() {
		String msg = "Avaliação da inicialização da taxa de um Sistema com valor inválido.";
		Sistema sistema = new Sistema(1000, 2.00);
	}

}
