package models;

import views.Seguro;

/**
 * Representação de um Seguro baseado num percentual do valor apostado em uma Aposta Assegurada fei-
 * ta num Sistema. Essa classe implementa a interface Seguro e tem como atributo a taxa do valor a-
 * postado que deverá ser assegurado.
 * 
 * Laboratório de Programação 2 - Lab 05
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class SeguroPorTaxa implements Seguro {
	
	private double taxaAssegurada;

	/**
	 * Constrói um SeguroPorTaxa a partir da taxa percentual que será assegurada.
	 * 
	 * @param taxaAsegurada A taxa percentual que será assegurada.
	 * 
	 */
	public SeguroPorTaxa(double taxaAssegurada) {
		this.taxaAssegurada = taxaAssegurada;
	}

	public double getTaxaAssegurada() {
		return this.taxaAssegurada;
	}

	/**
	 * Implementação do método de Seguro que calcula qual o valor assegurado por esse Seguro. Para
	 * SeguroPorTaxa, será retornado o produto da taxaAssegurada pelo valor total que foi apostado.
	 * 
	 * @param valorAposta O valor (em centavos) que foi apostado.
	 * 
	 * @return O valor (em centavos) que será assegurado.
	 * 
	 */
	@Override
	public int quantiaAssegurada(int valorAposta) {
		return (int) (Math.round(valorAposta * this.taxaAssegurada));
	}

	/**
	 * Retorna a String que representa o SeguroPorTaxa. A representação segue o formato "ASSEGURADA 
	 * (TIPO) - TAXA ASSEGURADA".
	 * 
	 * @return A representação, em String, do SeguroPorTaxa.
	 * 
	 */
	@Override
	public String toString() {
		return "ASSEGURADA (TAXA) - " + (int) (this.taxaAssegurada * 100) + "%";
	}
	
}
