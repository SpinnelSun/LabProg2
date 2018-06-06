package models;

import utility.Validador;
import views.Seguro;

/**
 * Representação de uma Aposta com Seguro feita num Sistema, relativa à ocorrência de um Cenario.
 * Como atributos, cada Aposta possui o nome do apostador, o boolean relativo à previsão de ocor-
 * rência do Cenario, o valor (em centavos) que foi apostado e um Seguro adequado.
 * 
 * Laboratório de Programação 2 - Lab 05
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class ApostaAssegurada extends Aposta {
	
	private Seguro seguro;

	/**
	 * Constrói uma Aposta com Seguro a partir do nome do apostador, do valor (em centavos) aposta-
	 * do, do texto que explicita a previsão sobre a ocorrência do Cenario e do valor (em centavos)
	 * assegurado pelo Seguro dessa Aposta. Utiliza-se o construtor da classe Aposta como base para
	 * a construção dos objetos dessa classe.
	 * 
	 * @param apostador O nome da pessoa que fez a Aposta.
	 * @param valor O valor (em centavos) que foi apostado.
	 * @param previsao O texto que explicita a previsão sobre a ocorrência do Cenario.
	 * @param valorAssegurado O valor (em centavos) dessa Aposta que é assegurado.
	 * 
	 */
	public ApostaAssegurada(String apostador, int valor, String previsao, int valorAssegurado) {
		super(apostador, valor, previsao);
		
		Validador.validarMenorIgualQue("VALOR ASSEGURADO MUITO ALTO!", valorAssegurado,
										this.getValor());
		
		this.seguro = new SeguroPorValor(valorAssegurado);
	}
	
	/**
	 * Constrói uma Aposta com Seguro a partir do nome do apostador, do valor (em centavos) aposta-
	 * do, do texto que explicita a previsão sobre a ocorrência do Cenario e da taxa percentual as-
	 * segurado pelo Seguro dessa Aposta. Utiliza-se o construtor da classe Aposta como base para
	 * a construção dos objetos dessa classe.
	 * 
	 * @param apostador O nome da pessoa que fez a Aposta.
	 * @param valor O valor (em centavos) que foi apostado.
	 * @param previsao O texto que explicita a previsão sobre a ocorrência do Cenario.
	 * @param taxaAssegurada A taxa percentual dessa Aposta que é assegurada.
	 * 
	 */
	public ApostaAssegurada(String apostador, int valor, String previsao, double taxaAssegurada) {
		super(apostador, valor, previsao);
		
		Validador.validarPercentual("TAXA ASSEGURADA INVÁLIDA!", taxaAssegurada);
		
		this.seguro = new SeguroPorTaxa(taxaAssegurada);
	}

	/**
	 * Modifica o Seguro atual da Aposta, trocando-o por um novo Seguro por Valor. Esse novo Seguro
	 * é construído a partir de um valor assegurado (em centavos) passado como parâmetro do método.
	 * 
	 * @param valorAssegurado O valor (em centavos) que será assegurado pelo novo Seguro da Aposta.
	 * 
	 */
	public void setSeguro(int valorAssegurado) {
		this.seguro = new SeguroPorValor(valorAssegurado);
	}
	
	/**
	 * Modifica o Seguro atual da Aposta, trocando-o por um novo Seguro por Taxa. Esse novo Seguro
	 * é construído a partir de uma taxa percentual assegurada passada como parâmetro do método.
	 * 
	 * @param taxaAssegurada A taxa percentual que será assegurada pelo novo Seguro da Aposta.
	 * 
	 */
	public void setSeguro(double taxaAssegurada) {
		this.seguro = new SeguroPorTaxa(taxaAssegurada);
	}
	
	/**
	 * Retorna a perda que a Aposta poderá causar ao apostador caso a previsão não se concretize.
	 * Para Apostas com Seguro, a perda gerada é amortecida pela quantia assegurada. 
	 * 
	 * @return A perda (em centavos) que a Aposta é capaz de causar ao apostador.
	 * 
	 */
	@Override
	public int perdaGerada() {
		return this.getValor() - this.seguro.quantiaAssegurada(this.getValor());
	}

	/**
	 * Retorna a String que representa a ApostaAssegurada. A representação segue o formato utili-
	 * zado em Aposta, acrescentando-se, ao final da String, as informações do Seguro.
	 * 
	 * @return A representação, em String, da ApostaAssegurada.
	 * 
	 */
	@Override
	public String toString() {
		return super.toString() + " - " + this.seguro.toString();
	}
	
}
