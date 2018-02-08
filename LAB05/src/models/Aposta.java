package models;

import utility.Validador;
import java.text.DecimalFormat;

/**
 * Representação de uma Aposta feita num Sistema, relativa à ocorrência de um Cenario. Como atribu-
 * tos, cada Aposta possui o nome do apostador, o boolean relativo à previsão de ocorrência do Ce-
 * nario e o valor (em centavos) que foi apostado.
 * 
 * Laboratório de Programação 2 - Lab 05
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class Aposta {
	
	private String apostador;
	private boolean previsao;
	private int valor;
	
	/**
	 * Constrói uma Aposta a partir do nome do apostador, do valor (em centavos) apostado e do texto
	 * que explicita a previsão sobre a ocorrência do Cenario. Não é permitido criar apostas de valor
	 * menor ou igual a zero. Não é permitido que Apostas tenham nome de apostador ou texto de previ-
	 * são vazios ou nulos.
	 * 
	 * @param apostador O nome da pessoa que fez a Aposta.
	 * @param valor O valor (em centavos) que foi apostado.
	 * @param previsao O texto que explicita a previsão sobre a ocorrência do Cenario.
	 * 
	 */
	public Aposta(String apostador, int valor, String previsao) {
		Validador.validarNotEmptyNotNull("Apostador nao pode ser vazio ou nulo", apostador);
		Validador.validarNotEmptyNotNull("Previsao nao pode ser vazia ou nula", previsao);
		Validador.validarPositiveInteger("Valor nao pode ser menor ou igual a zero", valor);
		
		this.apostador = apostador.trim();
		this.previsao = avaliaPrevisao(previsao);
		this.valor = valor;
	}
	
	public String getApostador() {
		return this.apostador;
	}
	
	public boolean getPrevisao() {
		return this.previsao;
	}

	public int getValor() {
		return this.valor;
	}
	
	/**
	 * A partir do texto que explicita a previsão do apostador sobre a ocorrência do Cenário, esse
	 * método avalia qual o boolean adequado a ser atribuído à Aposta. Quando o texto informado não
	 * estiver nos padrões esperados, uma exceção adequada será lançada.
	 * 
	 * @param previsao O texto que explicita a previsão sobre a ocorrência do Cenario.
	 * 
	 * @returns O boolean adequado a ser atributo da Aposta.
	 * 
	 */
	private boolean avaliaPrevisao(String previsao) {
		if (previsao.equals("VAI ACONTECER")) {
			return true;
		} 
		
		if (previsao.equals("N VAI ACONTECER")) {
			return false;
		}
		
		throw new IllegalArgumentException("Previsao invalida"); 
	}
	
	/**
	 * Retorna a representação textual referente ao boolean que foi armazenado no atributo previsao
	 * da Aposta.
	 * 
	 * @returns A representação textual da previsão da Aposta.
	 * 
	 */
	protected String descrevePrevisao() {
		return (this.previsao) ? "VAI ACONTECER" : "N VAI ACONTECER";
	}

	/**
	 * Retorna a String que representa a Aposta. Utiliza o padrão "NOME DO APOSTADOR - VALOR EM
	 * REAIS DA APOSTA - PREVISÃO DA APOSTA".
	 * 
	 * @returns A representação, em String, da Aposta.
	 * 
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		
		return this.getApostador() + " - R$" + (df.format(this.getValor() / 100.0)) + " - " +
			   this.descrevePrevisao();
	} 	

}