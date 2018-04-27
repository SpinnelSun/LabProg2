package models;

import java.util.Arrays;

/**
 * Representação de uma disciplina que esteja sendo cursada por um estudante. Cada disciplina em
 * curso deverá conter o nome dessa disciplina, a quantidade de horas dedicadas ao estudo dessa
 * disciplina, as notas obtidas pelo aluno no decorrer da disciplina e o peso de cada uma dessas
 * notas no cálculo da média final obtida pelo aluno.
 *
 * Laboratório de Programação 2 - Lab 02
 * @author Matheus Alves dos Santos - 117110503 
 * 
 */
public class Disciplina {
	
	private String nomeDisciplina;
	private int horasEstudo;
	private double[] notas;
	private double[] pesoNotas;
	
	/**
	 *  Constrói uma disciplina em curso a partir do nome da disciplina e da quantidade de notas
	 *  que serão utilizadas na avaliação do estudante. Inicia-se a quantidade de horas de estudo
	 *  da disciplina em 0. Conforme a quantidade de notas, cada nota da disciplina é iniciada em
	 *  0 e cada uma das notas recebe exatamente o mesmo peso na média final.
	 *  
	 *  @param nomeDisciplina Nome da disciplina que será cursada pelo estudante.
	 *  @param numeroNotas Quantidade de notas utilizada na avaliação do estudante.
	 *  
	 */
	public Disciplina(String nomeDisciplina, int numeroNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.horasEstudo = 0;
		this.notas = new double[numeroNotas];
		this.pesoNotas = new double[numeroNotas];
		
		for(int i = 0; i < numeroNotas; i++) {
			this.notas[i] = 0;
			this.pesoNotas[i] = 1;
		}
	}
	
	/**
	 *  Constrói uma disciplina em curso a partir do nome da disciplina. Inicia a quantidade de
	 *  horas de estudo dedicadas em 0. Também considera que haverão exatamente quatro notas na
	 *  disciplina, sendo todas elas inicializadas em 0. Cada uma das quatro notas terá o mesmo
	 *  peso na média final.
	 *  
	 *  @param nomeDisciplina Nome da disciplina que será cursada pelo estudante.
	 *  
	 */
	public Disciplina(String nomeDisciplina) {
		this(nomeDisciplina, 4);
	}
	
	/**
	 *  Constrói uma disciplina em curso a partir do nome da disciplina, da quantidade de notas e
	 *  dos pesos de cada uma dessas notas no cálculo da média final. De acordo com a quantidade
	 *  de notas avaliativas, todas as notas do aluno são iniciadas como 0. A quantidade de horas
	 *  de estudo também é, inicialmente, 0. O peso de cada nota no cálculo da média final também
	 *  é registrado no objeto.
	 *  
	 *  @param nomeDisciplina Nome da disciplina que será cursada pelo estudante.
	 *  @param numeroNotas Quantidade de notas utilizada na avaliação do estudante.
	 *  @param pesoNotas Pesos das notas no cálculo da média final do aluno.
	 *  
	 */
	public Disciplina(String nomeDisciplina, int numeroNotas, double[] pesoNotas) {
		this(nomeDisciplina, 4);
		this.pesoNotas = pesoNotas;
	}
	
	/**
	 *  Atualiza a quantidade de horas de estudo que foram dedicadas à disciplina. O número total
	 *  de horas de estudo é acrescido conforme o número de horas informado como parâmetro.
	 *  
	 *  @param horas Quantidade de horas de estudo da disciplina a ser adicionada.
	 *  
	 *  @returns null
	 *  
	 */
	public void cadastraHoras(int horas) {
		this.horasEstudo += horas;
	}
	
	
	/**
	 *  Registra uma nota obtida pelo estudante. O registro é feito apenas se a prova e a nota a
	 *  serem registradas fizerem sentido para tal disciplina.
	 *  
	 *  @param nota Posição sequencial da nota obtida na ordem das notas avaliativas.
	 *  @param valorNota Pontuação obtida pelo estudante.
	 *  
	 *  @returns null
	 *  
	 */
	public void cadastraNota(int nota, double valorNota) {
		if((nota > 0) && (nota <= this.notas.length)) {
			if((valorNota >= 0) && (valorNota <= 10)) {
				this.notas[nota - 1] = valorNota;
			}
		}
	}
	
	/**
	 *  Calcula a média final obtida pelo estudante na disciplina. O cálculo realizado pondera os
	 *  pesos das notas e as notas em si para retornar a média final do estudante.
	 *  
	 *  @returns o double que representa a média final do estudante nessa disciplina.
	 *  
	 */
	private double calculaMedia() {
		int media = 0, pesos = 0;
		for(int i = 0; i < this.notas.length; i++) {
			media += (this.notas[i] * this.pesoNotas[i]);
			pesos += this.pesoNotas[i];
		}
		
		return media /= pesos;
	}
	
	/**
	 *  Determina se o estudante foi (ou não) aprovado por média na disciplina. Para conseguir a
	 *  aprovação, o estudante deve possuir uma média final igual ou superior a 7.
	 *  
	 *  @returns o boolean que indica se o estudante foi aprovado.
	 *  
	 */
	public boolean aprovado() {
		return (this.calculaMedia() >= 7.0);
	}
	
	/**
	 *  Retorna uma String que representa a disciplina em curso. A representação segue o padrão
	 *  "(Nome da Disciplina) (Horas de Estudo Média Final) [Notas Obtidas]".
	 *  
	 *  @returns A representação em String da disciplina em curso.
	 *  
	 */
	@Override
	public String toString() {
		return nomeDisciplina + " " + horasEstudo + " " + this.calculaMedia() + " "
	           + Arrays.toString(this.notas);
	}
	
}
