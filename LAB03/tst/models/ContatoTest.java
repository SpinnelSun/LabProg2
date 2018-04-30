package models;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Test;

import models.Contato;

public class ContatoTest {
	
	private Contato contatoBasico1;
	private Contato contatoBasico2;
	private Contato contatoBasico3;
	private Contato contatoBasico4;
	private Contato contatoRepetido;
	
	@Before
	public void criaContatos() {
		contatoBasico1 = new Contato("Bloom", "of Domino", "00000-0000");
		contatoBasico2 = new Contato("Stella", "of Solaria", "11111-1111");
		contatoBasico3 = new Contato("The Fairy ", "of Solaria", "22222-2222");
		contatoBasico4 = new Contato("Stella", ", the Princess", "33333-3333");
		contatoRepetido = new Contato("Bloom", "of Domino", "44444-4444");
	}
	
	@Test
	public void testContato() {
		String msg = "Criação de um Contato através do construtor padrão da classe.";
		Contato contatoCriado = new Contato("Musa", "of Melody", "55555-5555");
		assertEquals(msg, "Musa of Melody - 55555-5555", contatoCriado.toString());
	}


	@Test
	public void testGetNomeCompleto() {
		String msg = "Obtenção o nome completo de um Contato criado.";
		assertEquals(msg, "Bloom of Domino", contatoBasico1.getNomeCompleto());
	}

	@Test
	public void testEqualsObject() {
		String msg = "Comparação de um Contato com ele mesmo.";
		assertTrue(msg, contatoBasico1.equals(contatoBasico1));
		
		String msg2 = "Comparação de um Contato com null.";
		assertFalse(msg2, contatoBasico1.equals(null));
		
		String msg3 = "Comparação de um Contato com outro tipo de Objeto.";
		assertFalse(msg3, contatoBasico1.equals("Enchantix!"));
		
		String msg4 = "Comparação de Contatos iguais (com mesmo nome e sobrenome).";
		assertTrue(msg4, contatoBasico1.equals(contatoRepetido));
		
		String msg5 = "Comparação de Contatos diferentes. (com mesmo nome)";
		assertFalse(msg5, contatoBasico2.equals(contatoBasico4));
		
		String msg6 = "Comparação de Contatos diferentes (com mesmo sobrenome).";
		assertFalse(msg6, contatoBasico2.equals(contatoBasico3));
	}

	@Test
	public void testToString() {
		String msg = "Obtém a representação em String do Contato.";
		assertEquals(msg, "Bloom of Domino - 00000-0000", contatoBasico1.toString());
	}
	
	@Test(expected=NullPointerException.class)
	public void testNomeNulo() {
		Contato invalido = new Contato(null, "Alphea", "00000-0000"); 
	}
	
	@Test(expected=NullPointerException.class)
	public void testSobrenomeNulo() {
		Contato invalido = new Contato("Magix", null, "11111-1111"); 
	}
	
	@Test(expected=NullPointerException.class)
	public void testTelefoneNulo() {
		Contato invalido = new Contato("Earth", " Kingdom", null); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNomeVazio() {
		Contato invalido = new Contato("   ", "Alphea", "00000-0000"); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSobrenomeVazio() {
		Contato invalido = new Contato("Magix", "   ", "11111-1111"); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTelefoneVazio() {
		Contato invalido = new Contato("Earth", " Kingdom", "   "); 
	}

}
