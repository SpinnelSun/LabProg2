package lab3;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

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
		
		agenda1.novoCadastro(1, "Flora", "of Linphea", "00000-0000");
		agenda1.novoCadastro(100, "Aisha", "of Andros", "11111-1111");
		agenda2.novoCadastro(1, "Flora", "of Linphea", "00000-0000");
	}
	
	@Test
	public void testAgenda() {
		String msg = "Verifica se os objetos da classe Agenda são criados.";
		assertTrue(msg, agenda1.validarContato(1));
		
		String msg2 = "Verifica se os objetos da classe Agenda são corretamente.";
		assertEquals(msg2, agenda1.exibicaoContato(1), "Flora of Linphea - 00000-0000");
	}

	@Test
	public void testValidarPosicao() {
		String msg = "Teste da validez da posição 0 em uma Agenda.";
		assertFalse(msg, agenda1.validarPosicao(0));
		
		String msg2 = "Teste da validez da posição 1 em uma Agenda.";
		assertTrue(msg2, agenda1.validarPosicao(1));
		
		String msg3 = "Teste da validez da posição 100 em uma Agenda.";
		assertTrue(msg3, agenda1.validarPosicao(100));
		
		String msg4 = "Teste da validez da posição 101 em uma Agenda.";
		assertFalse(msg4, agenda1.validarPosicao(101));
	}

	@Test
	public void testValidarContato() {
		String msg = "Valida que há um Contato armazenado na posição buscada.";
		assertTrue(msg, agenda1.validarContato(1));
		
		String msg2 = "Valida que não há um Contato armazenado na posição buscada.";
		assertFalse(msg2, agenda1.validarContato(2));
	}
	
	@Test
	public void testNovoCadastro() {
		/* Não é necessário realizar testes para o cadastro de contatos em posições inválidas. Só se
		 * executa novoCadastro() se a posição passada como parâmetro for válida e, conforme testes,
		 * validarPosicao() funciona adequadamente,
		 */
		
		String msg = "Cadastro de um Contato em posição vazia.";
		agenda1.novoCadastro(2, "Tecna", "of Zenith", "22222-2222");
		assertTrue(msg, agenda1.validarContato(2));
		
		String msg2 = "Cadastro de um Contato em posição preenchida previamente.";
		agenda1.novoCadastro(1, "Kiko", "the Rabbit", "33333-3333");
		assertEquals(msg2, agenda1.exibicaoContato(1), "Kiko the Rabbit - 33333-3333");
	}

	@Test
	public void testExibicaoContato() {
		/* Não é necessário realizar testes para a exibição de contatos inexistentes/não cadastrados.
		 * Só se executa exibicaoContato() se a posição passada como parâmetro já contiver um Contato
		 * e, conforme testes, validarContato() funciona adequadamente,
		 */
		
		String msg = "Exibição de um Contato existente em uma posição simples.";
		assertEquals(msg, agenda1.exibicaoContato(1), "Flora of Linphea - 00000-0000");
		
		String msg2 = "Exibição de um Contato existente em uma posição limite.";
		assertEquals(msg2, agenda1.exibicaoContato(100), "Aisha of Andros - 11111-1111");
	}

	@Test
	public void testListagemContatos() {
		String msg = "Listagem de uma Agenda com Contatos cadastrados.";
		ArrayList<String> listagemEsperada = new ArrayList<>();
		listagemEsperada.add("1 - Flora of Linphea");
		listagemEsperada.add("100 - Aisha of Andros");
		assertEquals(msg, agenda1.listagemContatos(), listagemEsperada);
		
		String msg2 = "Listagem de uma Agenda sem Contatos cadastrados.";
		assertEquals(msg2, agenda3.listagemContatos().size(), 0);
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
		agenda2.novoCadastro(100, "Aisha", "of Andros", "11111-1111");
		assertTrue(msg5, agenda1.equals(agenda2));
	}
	
	@Test
	public void testToString() {
		String msg = "Obtenção da representação em String da Agenda.";
		ArrayList<String> listagemEsperada = new ArrayList<>();
		listagemEsperada.add("1 - Flora of Linphea");
		listagemEsperada.add("100 - Aisha of Andros");
		assertEquals(msg, agenda1.toString(), "CONTATOS CADASTRADOS: " + listagemEsperada);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNovoCadastroNomeVazio() {
		agenda1.novoCadastro(1, "", "Alphea", "00000-0000"); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNovoCadastroSobrenomeVazio() {
		agenda1.novoCadastro(1, "Magix", "", "11111-1111"); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNovoCadastroTelefoneVazio() {
		agenda1.novoCadastro(1, "Earth", " Kingdom", ""); 
	}

}
