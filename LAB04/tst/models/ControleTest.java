package models;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import controllers.Controle;

public class ControleTest {
	
	private Controle controle;
	
	@Before
	public void criarControle() {
		this.controle = new Controle();
	}

	@Test
	public void testControle() {
		String msg = "Verificação do construção adequada de um Controle.";
		assertNotEquals(msg, controle, null);
	}

	@Test
	public void testCadastroAlunoNovo() {
		String msg = "Verificação do cadastro de um Aluno com matrícula inédita.";
		controle.cadastrarAluno("1", "Soraka", "Support");
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testCadastroAlunoRepetido() {
		String msg = "Verificação da exceção lançada devido ao cadastro de um Aluno com matrícula repetida.";
		controle.cadastrarAluno("1", "Soraka", "Support");
		controle.cadastrarAluno("1", "Sona", "Support");
	}

	@Test
	public void testConsultaAlunoExistente() {
		controle.cadastrarAluno("1", "Soraka", "Support");
		String msg = "Verificação da consulta sobre um Aluno já cadastrado.";
		assertEquals(msg, controle.consultarAluno("1"), "1 - Soraka - Support");
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testConsultaAlunoInexistente() {
		String msg = "Verificação da exceção lançada devido à consulta sobre um Aluno já cadastrado.";
		controle.consultarAluno("1");
	}
	
	@Test
	public void testCadastroGrupoNovo() {
		String msg = "Verificação do cadastro de um Grupo com nome inédito.";
		controle.cadastrarGrupo("Melhores Builds");
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testCadastroGrupoRepetido() {
		String msg = "Verificação da exceção lançada devido ao cadastro de um Grupo com nome repetido.";
		controle.cadastrarGrupo("Melhores Builds");
		controle.cadastrarGrupo("Melhores Builds");
	}
	
	@Test
	public void testAlocaAluno() {
		controle.cadastrarAluno("1", "Soraka", "Support");
		controle.cadastrarGrupo("Melhores Builds");
		
		String msg = "Verificação da alocação de um Aluno em um Grupo, ambos existentes.";
		controle.alocarAluno("1", "Melhores Builds");
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testAlocaAlunoInexistente() {
		controle.cadastrarGrupo("Melhores Builds");
		
		String msg = "Verificação da exceção lançada devido à alocação de Aluno não cadastrado.";
		controle.alocarAluno("1", "Melhores Builds");
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testAlocaEmGrupoInexistente() {
		controle.cadastrarAluno("1", "Soraka", "Support");
		
		String msg = "Verificação da exceção lançada devido à alocação em Grupo não cadastrado.";
		controle.alocarAluno("1", "Melhores Builds");
	}

	@Test
	public void testImprimeGrupoExistente() {
		controle.cadastrarGrupo("Melhores Builds");
		controle.cadastrarAluno("1", "Soraka", "Support");
		
		String msg = "Verificação da impressão de um Grupo já cadastrado sem alunos alocados.";
		assertEquals(msg, controle.imprimirGrupo("Melhores Builds"), "Alunos do grupo Melhores Builds:"
				                                + System.lineSeparator());
		
		controle.alocarAluno("1", "Melhores Builds");
		String msg2 = "Verificação da impressão de um Grupo já cadastrado com alunos alocados.";
		assertEquals(msg2, controle.imprimirGrupo("Melhores Builds"), "Alunos do grupo Melhores Builds:"
				                                + System.lineSeparator() + "* 1 - Soraka - Support" + System.lineSeparator());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testImprimeGrupoInexistente() {
		String msg = "Verificação da exceção lançada devido à impressão de um Grupo não cadastrado.";
		controle.imprimirGrupo("Melhores Builds");
	}

	@Test
	public void testCadastroRespondente() {
		String msg = "Verificação do registro de um respondente já cadastrado.";
		controle.cadastrarAluno("1", "Soraka", "Support");
		controle.cadastrarRespondente("1");
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testCadastroRespondenteInexistente() {
		String msg = "Verificação da exceção lançada devido ao registro de um respondente não cadastrado.";
		controle.cadastrarRespondente("1");
	}

	@Test
	public void testRespondentesToString() {
		String msg = "Verificação da representação textual dos respondentes quando não se registra respostas.";
		assertEquals(msg, controle.respondentesToString(), "");
		
		controle.cadastrarAluno("1", "Soraka", "Support");
		controle.cadastrarRespondente("1");
		
		String msg2 = "Verificação da representação textual dos respondentes quando há resposas registradas.";
		assertEquals(msg2, controle.respondentesToString(), "1. 1 - Soraka - Support" + System.lineSeparator());
	}

}
