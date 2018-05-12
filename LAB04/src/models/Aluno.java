/**
 * 
 */
package models;

import utility.Validador;

/**
 * Representação de um aluno a ser manipulado pelo Controle. Como atributos, cada Aluno possui matrí-
 * cula, nome e curso (armazenados como Strings). 
 * 
 * Laboratório de Programação 2 - Lab 04
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class Aluno {
	
	private String matricula;
	private String nome;
	private String curso;
	
	/**
	 * Constrói um Aluno a partir de sua matrícula, de seu nome e de seu curso. Não é permitida a
	 * criação de Alunos com parâmetros vazios ou nulos. As informações armazenadas não contém es-
	 * paços em branco nas extremidades.
	 * 
	 * @param matricula A matrícula do aluno.
	 * @param nome O nome do aluno.
	 * @param curso O curso do aluno.
	 * 
	 */
	public Aluno(String matricula, String nome, String curso) {
		this.validacoes(matricula, nome, curso);

		this.matricula = matricula.trim();
		this.nome = nome.trim();
		this.curso = curso.trim();
	}
	
	/**
	 * Valida os parâmetros do construtor através dos métodos de Validador, causando o lançamento de
	 * exceções sempre que as exigências do construtor não forem atendidas.
	 * 
	 * @param matricula A matrícula do aluno.
	 * @param nome O nome do aluno.
	 * @param curso O curso do aluno.
	 * 
	 */
	private void validacoes(String matricula, String nome, String curso) {
		Validador.validarStringNaoVaziaNaoNula("MATRÍCULA NÃO PODE SER VAZIA OU NULA!", matricula);
		Validador.validarStringNaoVaziaNaoNula("NOME NÃO PODE SER VAZIO OU NULO!", nome);
		Validador.validarStringNaoVaziaNaoNula("CURSO NÃO PODE SER VAZIO OU NULO!", curso);
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCurso() {
		return this.curso;
	}

	/**
	 * Gera o HashCode de um Aluno a partir de seu atributo matricula.
	 * 
	 * @return O Hashcode do Aluno.
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		
		return result;
	}

	/**
	 * Avalia se o Aluno é ou não igual a outro Object. Para que haja igualdade, deverão possuir o
	 * atributo matricula iguais.
	 * 
	 * @param obj O objeto a ser comparado com o Aluno executando o equals.
	 * @return O boolean que equivalente ao resultado do teste de igualdade.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		
		if (obj == null) { return false; }
		
		if (getClass() != obj.getClass()) { return false; }
		
		Aluno other = (Aluno) obj;
		
		if (matricula == null) {
			if (other.matricula != null) {
				return false;
			}
		} else if (!matricula.equals(other.matricula)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Retorna a String que representa o Aluno. A representação segue o formato "MATRICULA - NOME -
	 * CURSO".
	 * 
	 * @return A representação, em String, de um Aluno.
	 * 
	 */
	@Override
	public String toString() {
		return this.getMatricula() + " - " + this.getNome() + " - " + this.getCurso();
	}

}