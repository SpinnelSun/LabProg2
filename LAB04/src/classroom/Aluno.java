/**
 * 
 */
package classroom;

/**
 * Representação de um aluno a ser manipulado pelo Controle. Como atributos, cada Aluno possui matrícula, nome e curso
 * (armazenados como Strings). 
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
	 * Constrói um Aluno a partir de sua matrícula, de seu nome e de seu curso. Não é permitida a criação de Alunos com
	 * parâmetros vazios ou nulos. As informações armazenadas não contém espaços em branco nas extremidades.
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
	 * Valida os parâmetros do construtor através dos métodos de Validador, causando o lançamento de exceções sempre
	 * que as exigências do construtor não forem atendidas.
	 * 
	 * @param matricula A matrícula do aluno.
	 * @param nome O nome do aluno.
	 * @param curso O curso do aluno.
	 * 
	 * @returns null.
	 * 
	 */
	private void validacoes(String matricula, String nome, String curso) {
		Validador.validarNotNull("MATRÍCULA NULA!", matricula);
		Validador.validarNotEmpty("MATRÍCULA VAZIA!", matricula);
		
		Validador.validarNotEmpty("NOME VAZIO!", nome);
		Validador.validarNotNull("NOME NULO!", nome);
		
		Validador.validarNotEmpty("CURSO VAZIO!", curso);
		Validador.validarNotNull("CURSO NULO!", curso);
	}
	
	/**
	 * Retorna a matrícula do Aluno.
	 *  
	 * @returns A matrícula do aluno.
	 * 
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Retorna o nome do Aluno.
	 *  
	 * @returns O nome do aluno.
	 * 
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Retorna o curso do Aluno.
	 *  
	 * @returns O curso do aluno.
	 * 
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * Gera o HashCode de um Aluno a partir de seu atributo matricula.
	 * 
	 * @returns O Hashcode do Aluno.
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
	 * Avalia se o Aluno é ou não igual a outro Object. Para que haja igualdade, deverão possuir o atributo matricula
	 * iguais.
	 * 
	 * @param obj O objeto a ser comparado com o Aluno executando o equals.
	 * @returns O boolean que equivalente ao resultado do teste de igualdade.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Aluno other = (Aluno) obj;
		
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		
		return true;
	}
	
	/**
	 * Retorna a String que representa o Aluno. A representação segue o formato "MATRICULA - NOME - CURSO".
	 * 
	 * @returns A representação, em String, de um Aluno.
	 * 
	 */
	@Override
	public String toString() {
		return this.getMatricula() + " - " + this.getNome() + " - " + this.getCurso();
	}

}