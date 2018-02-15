package models;

import java.text.DecimalFormat;

import utility.Validador;
import views.Seguro;

/**
 * Representação de um Seguro baseado no valor apostado em uma Aposta Assegurada feita num Sistema.
 * Essa classe implementa a interface Seguro e tem como atributo o valor (em centavos) que será as-
 * segurado.
 * 
 * Laboratório de Programação 2 - Lab 05
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class SeguroPorValor implements Seguro {

	private int valorAssegurado;
	
	/**
	 * Constrói um SeguroPorValor a partir do valor (em centavos) que será assegurado. Não é possí-
	 * vel criar um Seguro para menos que um centavo.
	 * 
	 * @param valorAsegurado O valor (em centavos) que será assegurado.
	 * 
	 */
	public SeguroPorValor(int valorAssegurado) {
		Validador.validarPositiveInteger("VALOR ASSEGURADO INVÁLIDO!", valorAssegurado);
		
		this.valorAssegurado = valorAssegurado;
	}

	public int getValorAssegurado() {
		return this.valorAssegurado;
	}

	/**
	 * Implementação do método de Seguro que calcula qual o valor assegurado por esse Seguro. Para
	 * SeguroPorValor, será retornado exatamente o valor do atributo valorAssegurado.
	 * 
	 * @param valorAposta O valor (em centavos) que foi apostado.
	 * 
	 * @returns O valor (em centavos) que será assegurado.
	 * 
	 */
	@Override
	public int quantiaAssegurada(int valorAposta) {
		return this.valorAssegurado;
	}

	/**
	 * Retorna a String que representa o SeguroPorValor. A representação segue o formato "ASSEGURADA 
	 * (TIPO) - VALOR ASSEGURADO".
	 * 
	 * @returns A representação, em String, do SeguroPorValor.
	 * 
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		
		return "ASSEGURADA (VALOR) - R$ " + (df.format(this.valorAssegurado / 100.0));
	}

}
