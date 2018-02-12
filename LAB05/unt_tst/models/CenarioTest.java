package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CenarioTest {
	
	private Cenario cenario1;
	private Cenario cenario2;
	private Cenario cenario3;
	
	@Before
	public void criarCenario() {
		cenario1 = new Cenario(1, "Matheus vai sobreviver a essa semana");
		cenario2 = new Cenario(2, "Matheus vai tirar 10 no LAB05");
		cenario3 = new Cenario(3, "As pessoas apostam com seguro?");
		
		cenario1.cadastrarAposta("Matheus Alves", 10000, "N VAI ACONTECER");
		
		cenario3.cadastrarAposta("Matheus Alves", 10000, "VAI ACONTECER", 1000);
		cenario3.cadastrarAposta("Alves Matheus", 10000, "N VAI ACONTECER", 0.1);
	}

	@Test
	public void testCenario() {
		String msg = "Avaliação do armazenamento adequado da numeração em um Cenario.";
		assertTrue(msg, cenario1.getNumeracao() == 1);
		
		String msg2 = "Avaliação do armazenamento adequado da descrição em um Cenario.";
		assertEquals(msg2, cenario1.getDescricao(), "Matheus vai sobreviver a essa semana");
		
		String msg3 = "Avaliação da criação de um Cenario com o estado adequado.";
		assertEquals(msg3, cenario1.getEstado(), Estado.NAO_FINALIZADO);
	}

	@Test
	public void testDefineOcorrencia() {
		cenario1.defineOcorrencia(true);
		String msg = "Avaliação da mudança de estado de um Cenario em função de sua ocorrência.";
		assertEquals(msg, cenario1.getEstado(), Estado.FINALIZADO_OCORREU);

		cenario2.defineOcorrencia(false);
		String msg2 = "Avaliação da mudança de estado de um Cenario em função de sua não ocorrência.";
		assertEquals(msg2, cenario2.getEstado(), Estado.FINALIZADO_NAO_OCORREU);
	}

	@Test
	public void testCadastrarAposta() {
		String msg = "Avaliação do registro de uma Aposta no Cenario através do método de cadastro.";
		assertTrue(msg, cenario1.totalDeApostas() == 1);
		
		cenario1.cadastrarAposta("Todo", 1000000, "N VAI ACONTECER");
		cenario1.cadastrarAposta("Mundo", 1000000, "N VAI ACONTECER");
		String msg2 = "Avaliação do registro de várias Apostas no Cenario através do método de cadastro.";
		assertTrue(msg2, cenario1.totalDeApostas() == 3);
	}
	
	@Test
	public void testCadastrarApostaAsseguradaValor() {
		cenario1.cadastrarAposta("Todo Mundo", 1000000, "N VAI ACONTECER", 1000);
		String msg = "Avaliação do registro de uma ApostaAssegurada (Valor) no Cenario através do método"
					  + " de cadastro.";
		assertTrue(msg, cenario1.totalDeApostas() == 2);
	}
	
	@Test
	public void testCadastrarApostaAsseguradaTaxa() {
		cenario1.cadastrarAposta("Todo Mundo", 1000000, "N VAI ACONTECER", 0.25);
		String msg = "Avaliação do registro de uma ApostaAssegurada (Taxa) no Cenario através do método"
					  + " de cadastro.";
		assertTrue(msg, cenario1.totalDeApostas() == 2);
	}

	@Test
	public void testValorTotalDeApostas() {
		String msg = "Avaliação do cálculo do caixa de um Cenario sem Apostas registradas.";
		assertTrue(msg, cenario2.valorTotalDeApostas() == 0);
		
		String msg2 = "Avaliação do cálculo do caixa de um Cenario com uma Aposta registrada.";
		assertTrue(msg2, cenario1.valorTotalDeApostas() == 10000);
		
		cenario1.cadastrarAposta("Todo Mundo", 10000, "N VAI ACONTECER");
		String msg3 = "Avaliação do cálculo do caixa de um Cenario com várias Apostas registradas.";
		assertTrue(msg3, cenario1.valorTotalDeApostas() == 20000);
	}

	@Test
	public void testTotalDeApostas() {
		String msg = "Avaliação da contagem de apostas de um Cenario sem Apostas registradas.";
		assertTrue(msg, cenario2.totalDeApostas() == 0);
		
		String msg2 = "Avaliação da contagem de apostas de um Cenario com uma Aposta registrada.";
		assertTrue(msg2, cenario1.totalDeApostas() == 1);
		
		cenario1.cadastrarAposta("Todo Mundo", 10000, "N VAI ACONTECER");
		String msg3 = "Avaliação da contagem de apostas de um Cenario com várias Apostas registradas.";
		assertTrue(msg3, cenario1.totalDeApostas() == 2);
	}

	@Test
	public void testListarApostas() {
		String listagemEsperada = "";
		
		String msg = "Avaliação da listagem de Apostas de um Cenario sem Apostas registradas.";
		assertEquals(msg, cenario2.listarApostas(), listagemEsperada);
		
		listagemEsperada += "Matheus Alves - R$100,00 - N VAI ACONTECER" + System.lineSeparator();
		String msg2 = "Avaliação da listagem de Apostas de um Cenario com uma Aposta registrada.";
		assertEquals(msg2, cenario1.listarApostas(), listagemEsperada);
		
		cenario1.cadastrarAposta("Todo", 10000, "N VAI ACONTECER", 1000);
		cenario1.cadastrarAposta("Mundo", 10000, "N VAI ACONTECER", 0.25);
		listagemEsperada += "Todo - R$100,00 - N VAI ACONTECER - ASSEGURADA (VALOR) - R$ 10,00" + System.lineSeparator();
		listagemEsperada += "Mundo - R$100,00 - N VAI ACONTECER - ASSEGURADA (TAXA) - 25%" + System.lineSeparator();
		String msg3 = "Avaliação da listagem de Apostas de um Cenario com vário tipos de Apostas registradas.";
		assertEquals(msg3, cenario1.listarApostas(), listagemEsperada);
	}

	@Test
	public void testTotalApostasPerdedoras() {
		cenario2.cadastrarAposta("Matheus Leal", 10000, "VAI ACONTECER");
		cenario2.defineOcorrencia(true);
		String msg = "Avaliação do levantamento de apostas perdedoras de um Cenario sem Apostas perdedoras.";
		assertTrue(msg, cenario2.totalApostasPerdedoras() == 0);
		
		cenario1.defineOcorrencia(true);
		String msg2 = "Avaliação do levantamento de apostas perdedoras de um Cenario com Apostas perdedoras.";
		assertTrue(msg2, cenario1.totalApostasPerdedoras() == 10000);
	}
	
	@Test
	public void testLucroCenario() {
		cenario2.cadastrarAposta("Matheus Leal", 10000, "VAI ACONTECER");
		cenario2.defineOcorrencia(true);
		String msg = "Avaliação do lucro gerado por um Cenario sem Apostas perdedoras.";
		assertTrue(msg, cenario2.lucroCenario(0.5) == 0);
		
		cenario1.defineOcorrencia(true);
		String msg2 = "Avaliação do lucro gerado por um Cenario sem Apostas perdedoras.";
		assertTrue(msg2, cenario1.lucroCenario(0.5) == 5000);
	}
	
	@Test
	public void testPagamentoSegurosValor() {
		cenario3.defineOcorrencia(false);
		String msg = "Avaliação do cálculo do valor a ser pago devido aos Seguros (Valor) das Apostas.";
		assertTrue(msg, cenario3.pagamentoSeguros() == 1000);
	}
	
	@Test
	public void testPagamentoSegurosTaxa() {
		cenario3.defineOcorrencia(true);
		String msg = "Avaliação do cálculo do valor a ser pago devido aos Seguros (Valor) das Apostas.";
		assertTrue(msg, cenario3.pagamentoSeguros() == 1000);
	}
	
	@Test
	public void testRateioCenario() {
		cenario2.cadastrarAposta("Matheus Leal", 10000, "VAI ACONTECER");
		cenario2.defineOcorrencia(true);
		String msg = "Avaliação do valor de rateio gerado no encerramento do Cenario sem Apostas perdedoras.";
		assertTrue(msg, cenario2.rateioCenario(0.1) == 0);
		
		cenario1.defineOcorrencia(true);
		String msg2 = "Avaliação do valor de rateio gerado no encerramento do Cenario com Apostas perdedoras.";
		assertTrue(msg2, cenario1.rateioCenario(0.1) == 9000);
	}

	@Test
	public void testEqualsObject() {
		String msg = "Comparação de um Cenario com ele mesmo.";
		assertEquals(msg, cenario1, cenario1);
		
		String msg2 = "Comparação de um Cenario com Null.";
		assertNotEquals(msg2, cenario1, null);
		
		String msg3 = "Comparação de um Cenario com um Objeto de outra classe.";
		assertNotEquals(msg3, cenario1, "AAAAA");
		
		String msg4 = "Comparação de dois Cenarios diferentes.";
		assertNotEquals(msg4, cenario1, cenario2);
		
		Cenario copiaCenario = new Cenario(1, "Qualquer coisa");
		String msg5 = "Comparação de dois Cenarios iguais.";
		assertEquals(msg5, cenario1, copiaCenario);
	}

	@Test
	public void testToString() {
		String msg = "Avaliação da representação textual de um Cenario aberto.";
		assertEquals(msg, cenario1.toString(), "1 - Matheus vai sobreviver a essa semana - Nao finalizado");
		
		cenario1.defineOcorrencia(true);
		String msg2 = "Avaliação da representação textual de um Cenario finalizado que ocorreu.";
		assertEquals(msg2, cenario1.toString(), "1 - Matheus vai sobreviver a essa semana - Finalizado (ocorreu)");
		
		cenario2.defineOcorrencia(false);
		String msg3 = "Avaliação da representação textual de um Cenario finalizado que não ocorreu.";
		assertEquals(msg3, cenario2.toString(), "2 - Matheus vai tirar 10 no LAB05 - Finalizado (n ocorreu)");
	}
	
	@Test(expected = NullPointerException.class)
	public void testDescricaoNula() {
		String msg = "Avaliação da exceção lançada ao criar um Cenario com descrição nula.";
		Cenario cenario = new Cenario(1, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDescricaoVazia() {
		String msg = "Avaliação da exceção lançada ao criar um Cenario com descrição vazia.";
		Cenario cenario = new Cenario(1, "   ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testOperacaoInadequadaCenarioFechado() {
		String msg = "Avaliação da exceção lançada ao definir ocorrência de um Cenario já fechado.";
		Cenario cenario = new Cenario(1, "Qualquer coisa");
		cenario.defineOcorrencia(true);
		cenario.defineOcorrencia(true);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testOperacaoInadequadaCenarioAberto() {
		String msg = "Avaliação da exceção lançada ao definir ocorrência de um Cenario já fechado.";
		Cenario cenario = new Cenario(1, "Qualquer coisa");
		cenario.totalApostasPerdedoras();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAlterarSeguroValorApostaComum() {
		String msg = "Avaliação da exceção lançada ao definir Seguro por Valor em uma Aposta sem Seguro.";
		cenario1.alterarSeguroValor(1, 1000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAlterarSeguroTaxaApostaComum() {
		String msg = "Avaliação da exceção lançada ao definir Seguro por Taxa em uma Aposta sem Seguro.";
		cenario1.alterarSeguroTaxa(1, 0.1);
	}

}