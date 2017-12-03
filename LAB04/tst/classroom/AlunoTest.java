package classroom;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classroom.Aluno;

public class AlunoTest {
	
	private Aluno aluno1;
	private Aluno aluno2;

	@Before
	public void criarAlunos() {
		this.aluno1 = new Aluno("1", "Miss Fortune", "ADCarry");
		this.aluno2 = new Aluno("2", "Evelynn", "Jungler");
	}
	
	@Test
	public void testAluno() {
		String msg = "Verificação de construção adequada de um Aluno.";
		assertEquals(msg, aluno1.getMatricula(), "1");
		assertEquals(msg, aluno1.getNome(), "Miss Fortune");
		assertEquals(msg, aluno1.getCurso(), "ADCarry");
	}

	@Test
	public void testEqualsObject() {
		String msg = "Comparação de um Aluno com ele mesmo.";
		assertEquals(msg, aluno1, aluno1);
		
		String msg2 = "Comparação de um Aluno com Null.";
		assertNotEquals(msg2, aluno1, null);
		
		String msg3 = "Comparação de um Aluno com um Objeto de outra classe.";
		assertNotEquals(msg3, aluno1, "AAAAA");
		
		String msg4 = "Comparação de dois Alunos diferentes.";
		assertNotEquals(msg4, aluno1, aluno2);
		
		Aluno copiaAluno = new Aluno("1", "Vayne", "ADCarry");
		String msg5 = "Comparação de dois Alunos iguais.";
		assertEquals(msg5, aluno1, copiaAluno);
	}

	@Test
	public void testToString() {
		String msg = "Verificação da representação textual de um Aluno.";
		assertEquals(msg, aluno1.toString(), "1 - Miss Fortune - ADCarry");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAlunoMatriculaVazia() {
		String msg = "Verificação da exceção lançada devido à criação de um Aluno com matrícula vazia.";
		Aluno alunoFalha = new Aluno("   ", "Quinn", "Top Laner");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAlunoNomeVazio() {
		String msg = "Verificação da exceção lançada devido à criação de um Aluno com nome vazio.";
		Aluno alunoFalha = new Aluno("1", "   ", "Top Laner");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCursoVazio() {
		String msg = "Verificação da exceção lançada devido à criação de um Aluno com curso vazio.";
		Aluno alunoFalha = new Aluno("1", "Quinn", "   ");
	}
	
	@Test(expected = NullPointerException.class)
	public void testAlunoMatriculaNula() {
		String msg = "Verificação da exceção lançada devido à criação de um Aluno com matrícula nula.";
		Aluno alunoFalha = new Aluno(null, "Quinn", "Top Laner");
	}
	
	@Test(expected = NullPointerException.class)
	public void testAlunoNomeNulo() {
		String msg = "Verificação da exceção lançada devido à criação de um Aluno com nome nulo.";
		Aluno alunoFalha = new Aluno("1", null, "Top Laner");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCursoNulo() {
		String msg = "Verificação da exceção lançada devido à criação de um Aluno com curso nulo.";
		Aluno alunoFalha = new Aluno("1", "Quinn", null);
	}

}
