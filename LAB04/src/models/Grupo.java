package models;

import java.util.HashSet;
import java.util.Set;

import utility.Validador;

/**
 * Representação de um grupo de alunos a ser manipulado pelo Controle. Como atributos, cada Grupo
 * possui um nome e um conjunto de Alunos. Representados por uma String e um HashSet de Alunos,
 * respectivamente.
 * 
 * Laboratório de Programação 2 - Lab 04
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class Grupo {
	
	private String nome;
	private Set<Aluno> alunos;
	
	/**
	 * Constrói um Grupo a partir de seu nome. Não é permitida a criação de Grupos com parâmetros 
	 * vazios ou nulos. Além disso, o nome do Grupo é armazenado sem possíveis espaços em branco
	 * nas extremidades. Inicialmente, o atributo alunos é um conjunto vazio. 
	 * 
	 * @param nome O nome do grupo de alunos.
	 * 
	 */
	public Grupo(String nome) {
		this.validacoes(nome);
		
		this.nome = nome.trim();
		this.alunos = new HashSet<Aluno>();
	}
	
	/**
	 * Valida o parâmetro do construtor através dos métodos de Validador, causando o lançamento de
	 * exceções sempre que as exigências do construtor não forem atendidas.
	 * 
	 * @param nome O nome do grupo de alunos.
	 * 
	 */
	private void validacoes(String nome) {
		Validador.validarStringNaoVaziaNaoNula("NOME DO GRUPO NÃO PODE SER VAZIO OU NULO!", nome);
	}

	public String getNome() {
		return nome;
	}

	/**
	 * Adiciona um Aluno ao conjunto de Alunos do Grupo. 
	 * 
	 * @param aluno O Aluno a ser alocado.
	 * 
	 */
	public void alocarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	/**
	 * Gera o HashCode de um Grupo a partir de seu atributo nome.
	 * 
	 * @return O Hashcode do Grupo.
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		
		return result;
	}

	/**
	 * Avalia se o Grupo é ou não igual a outro Object. Para que haja igualdade, deverão possuir o
	 * atributo nome iguais. Para essa igualdade, letras maiúsculas e minúsculas não são diferencia-
	 * das.
	 * 
	 * @param obj O objeto a ser comparado com o Grupo executando o equals.
	 * @return O boolean que equivalente ao resultado do teste de igualdade.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		
		if (obj == null) { return false; }
		
		if (getClass() != obj.getClass()) { return false; }
		
		Grupo other = (Grupo) obj;
		
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equalsIgnoreCase(other.nome)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Retorna a String que representa o Grupo. A representação é uma lista dos alunos contidos no
	 * Grupo, cada linha tem o padrão "* Aluno.toString()".
	 * 
	 * @return A representação, em String, de um Grupo.
	 * 
	 */
	@Override
	public String toString() {
		String representacaoTextual = "Alunos do grupo " + this.getNome() + ":" + System.lineSeparator();
		
		for (Aluno aluno : alunos) {
			representacaoTextual += "* " + aluno.toString() + System.lineSeparator();
		}
		
		return representacaoTextual;
	}

}
