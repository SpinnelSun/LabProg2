package models;

import java.text.DecimalFormat;

import utility.Validador;

/**
 * Representação de um Cenario com Bônus criado num Sistema, sobre o qual serão feitas Apostas. Além
 * dos atributos herdados de Cenario, o CenarioBonificado possui um int que representa o valor do
 * Bônus registrado pelo Sistema para ele.
 * 
 * Laboratório de Programação 2 - Lab 05
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class CenarioBonificado extends Cenario {
	
	private int bonus;

	/**
	 * Constrói um CenarioBonificado a partir da numeração que o identifica, da String que o descre-
	 * ve e do valor (em centavos) de Bônus que incide sobre ele. Utiliza-se o construtor da classe
	 * Cenario como base para a construção dos objetos dessa classe.
	 * 
	 * @param numeracao O inteiro que atua como ID de cada Cenario.
	 * @param descricao O texto que descreve brevemente o Cenario.
	 * @param bonus O valor (em centavos) do bônus reservado para esse CenarioBonificado.
	 * 
	 */
	public CenarioBonificado(int numeracao, String descricao, int bonus) {
		super(numeracao, descricao);
		
		Validador.validarInteiroPositivo("Bonus invalido", bonus);
		this.bonus = bonus;
	}
	
	public int getBonus() {
		return this.bonus;
	}
	
	/**
	 * Retorna o valor (em centavos) que será destinado ao rateio entre os vencedores do Cenario.
	 * Utiliza o rateio da classe Cenario e adiciona a ele o valor de bônus.  
	 * 
	 * @param taxa A taxa de lucro informada pelo Sistema que contém o Cenario.
	 * 
	 * @return O valor (em centavos) que será destinado ao rateio entre os vencedores.
	 * 
	 */
	@Override
	public int rateioCenario(double taxa) {
		return super.rateioCenario(taxa) + this.getBonus();
	}
	
	/**
	 * Retorna a String que representa o CenarioBonificado. A representação segue o formato utili-
	 * zado em Cenario, acrescentando-se, ao final da String, o valor (em reais) do bônus.
	 * 
	 * @return A representação, em String, do CenarioBonificado.
	 * 
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		
		return super.toString() + " - R$ " + (df.format(this.getBonus() / 100.0));
	}
	
}
