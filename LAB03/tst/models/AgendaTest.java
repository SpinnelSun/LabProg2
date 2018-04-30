package models;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Test;

import models.Agenda;

/**
 * Testes da classe Agenda.
 * 
 * @author matheusas
 * 
 */
public class AgendaTest {
	
	private Agenda agenda1;
	private Agenda agenda2;
	private Agenda agenda3;

	@Before
	public void criaAgenda() {
		agenda1 = new Agenda();
		agenda2 = new Agenda();
		agenda3 = new Agenda();
		
		agenda1.cadastrarContato(1, "Flora", "of Linphea", "00000-0000");
		agenda1.cadastrarContato(100, "Aisha", "of Andros", "11111-1111");
		agenda2.cadastrarContato(1, "Flora", "of Linphea", "00000-0000");
	}
	
	@Test
	public void testAgenda() {
		String msg = "Verifica se os objetos da classe Agenda são criados.";
		assertTrue(msg, agenda1.verificarContatoCadastrado(1));
		
		String msg2 = "Verifica se os objetos da classe Agenda são corretamente.";
		assertEquals(msg2, agenda1.exibirContato(1), "Flora of Linphea - 00000-0000");
	}

	@Test
	public void testVerificarPosicaoValida() {
		String msg = "Teste da validez da posição 0 em uma Agenda.";
		assertFalse(msg, agenda1.verificarPosicaoValida(0));
		
		String msg2 = "Teste da validez da posição 1 em uma Agenda.";
		assertTrue(msg2, agenda1.verificarPosicaoValida(1));
		
		String msg3 = "Teste da validez da posição 100 em uma Agenda.";
		assertTrue(msg3, agenda1.verificarPosicaoValida(100));
		
		String msg4 = "Teste da validez da posição 101 em uma Agenda.";
		assertFalse(msg4, agenda1.verificarPosicaoValida(101));
	}

	@Test
	public void testVerificarContatoCadastrado() {
		String msg = "Valida que há um Contato armazenado na posição buscada.";
		assertTrue(msg, agenda1.verificarContatoCadastrado(1));
		
		String msg2 = "Valida que não há um Contato armazenado na posição buscada.";
		assertFalse(msg2, agenda1.verificarContatoCadastrado(2));
	}
	
	@Test
	public void testCadastrarContato() {
		/* Não é necessário realizar testes para o cadastro de contatos em posições inválidas. Só se
		 * executa novoCadastro() se a posição passada como parâmetro for válida e, conforme testes,
		 * validarPosicao() funciona adequadamente,
		 */
		
		String msg = "Cadastro de um Contato em posição vazia.";
		agenda1.cadastrarContato(2, "Tecna", "of Zenith", "22222-2222");
		assertTrue(msg, agenda1.verificarContatoCadastrado(2));
		
		String msg2 = "Cadastro de um Contato em posição preenchida previamente.";
		agenda1.cadastrarContato(1, "Kiko", "the Rabbit", "33333-3333");
		assertEquals(msg2, agenda1.exibirContato(1), "Kiko the Rabbit - 33333-3333");
	}

	@Test
	public void testExibirContato() {
		/* Não é necessário realizar testes para a exibição de contatos inexistentes/não cadastrados.
		 * Só se executa exibicaoContato() se a posição passada como parâmetro já contiver um Contato
		 * e, conforme testes, validarContato() funciona adequadamente,
		 */
		
		String msg = "Exibição de um Contato existente em uma posição simples.";
		assertEquals(msg, agenda1.exibirContato(1), "Flora of Linphea - 00000-0000");
		
		String msg2 = "Exibição de um Contato existente em uma posição limite.";
		assertEquals(msg2, agenda1.exibirContato(100), "Aisha of Andros - 11111-1111");
	}

	@Test
	public void testListarContatos() {
		String msg = "Listagem de uma Agenda com Contatos cadastrados.";
		String listagemEsperada = "1 - Flora of Linphea" + System.lineSeparator() +
								  "100 - Aisha of Andros" + System.lineSeparator();
		assertEquals(msg, agenda1.listarContatos(), listagemEsperada);
		
		String msg2 = "Listagem de uma Agenda sem Contatos cadastrados.";
		assertEquals(msg2, agenda3.listarContatos(), "");
	}
	
	@Test
	public void testEquals() {
		String msg = "Comparação de uma Agenda com ela mesma.";
		assertTrue(msg, agenda1.equals(agenda1));
		
		String msg2 = "Comparação de uma Agenda com null.";
		assertFalse(msg2, agenda1.equals(null));
		
		String msg3 = "Comparação de uma Agenda com outro tipo de Objeto.";
		assertFalse(msg3, agenda1.equals("Enchantix!"));
		
		String msg4 = "Comparação de Agendas diferentes.";
		assertFalse(msg4, agenda1.equals(agenda2));
		
		String msg5 = "Comparação de Agendas iguais (com os mesmos contatos).";
		agenda2.cadastrarContato(100, "Aisha", "of Andros", "11111-1111");
		assertTrue(msg5, agenda1.equals(agenda2));
	}
	
	@Test
	public void testToString() {
		String msg = "Obtenção da representação em String da Agenda.";
		String listagemEsperada = "1 - Flora of Linphea" + System.lineSeparator() +
				  "100 - Aisha of Andros" + System.lineSeparator();
		assertEquals(msg, agenda1.toString(), "CONTATOS CADASTRADOS: " + listagemEsperada);
	}

}
