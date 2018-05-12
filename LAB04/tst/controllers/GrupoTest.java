package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import models.Aluno;
import models.Grupo;

public class GrupoTest {
	
	private Grupo grupo1;
	private Grupo grupo2;
	private Aluno queen1;
	private Aluno queen2;

	@Before
	public void criarGrupos() {
		this.grupo1 = new Grupo("Rainhas do Mid");
		this.grupo2 = new Grupo("Flopadas do Mid");
		this.queen1 = new Aluno("1", "Diana", "Assassin");
		this.queen2 = new Aluno("2", "Katarina", "Assassin");
	}
	
	@Test
	public void testGrupo() {
		String msg = "Verificação de construção adequada de um Grupo.";
		assertEquals(msg, grupo1.getNome(), "Rainhas do Mid");
	}

	@Test
	public void testEqualsObject() {
		String msg = "Comparação de um Grupo com ele mesmo.";
		assertEquals(msg, grupo1, grupo1);
		
		String msg2 = "Comparação de um Grupo1 com Null.";
		assertNotEquals(msg2, grupo1, null);
		
		String msg3 = "Comparação de um Grupo com um Objeto de outra classe.";
		assertNotEquals(msg3, grupo1, "AAAAA");
		
		String msg4 = "Comparação de dois Grupos diferentes.";
		assertNotEquals(msg4, grupo1, grupo2);
		
		Grupo copiaGrupo = new Grupo("RaInHas Do MiD");
		String msg5 = "Comparação de dois Grupos iguais.";
		assertEquals(msg5, grupo1, copiaGrupo);
	}

	@Test
	public void testToString() {
		String lista = "Alunos do grupo Rainhas do Mid:" + System.lineSeparator();
				
		String msg = "Verificação da representação textual de um Grupo sem Alunos.";
		assertEquals(msg, grupo1.toString(), lista);
		
		grupo1.alocarAluno(queen1);
		lista += "* 1 - Diana - Assassin" + System.lineSeparator();
		
		String msg2 = "Verificação da representação textual de um Grupo com um Aluno.";
		assertEquals(msg2, grupo1.toString(), lista);
		
		grupo1.alocarAluno(queen2);
		lista += "* 2 - Katarina - Assassin" + System.lineSeparator();
		
		String msg3 = "Verificação da representação textual de um Grupo com mais de um Aluno.";
		assertEquals(msg3, grupo1.toString(), lista);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGrupoNomeVazio() {
		String msg = "Verificação da exceção lançada devido à criação de um Grupo com nome vazio.";
		Grupo grupoFalha = new Grupo("   ");
	}

	@Test(expected = NullPointerException.class)
	public void testGrupoNomeNulo() {
		String msg = "Verificação da exceção lançada devido à criação de um Grupo com nome nulo.";
		Grupo alunoFalha = new Grupo(null);
	}

}
