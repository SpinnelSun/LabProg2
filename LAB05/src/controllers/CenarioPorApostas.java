package controllers;

import java.util.Comparator;

import models.Cenario;

/**
 * Representação de um ordenador de Cenarios cadastrados no Sistema de Apostas baseado no número de
 * Apostas cadastradas nos Cenarios. Essa classe implementa a interface Comparator.
 * 
 * Laboratório de Programação 2 - Lab 05
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class CenarioPorApostas implements Comparator<Cenario> {

	/**
	 * Implementação do método de Comparator que determina qual dos Cenarios passados como parâmetros
	 * precede o outro. Um cenario A precederá o Cenario B se possuir mais Apostas cadastradas que B.
	 * Caso haja equivalência, a numeração dos Cenarios é usada para "desempate".
	 * 
	 * @param c1 O primeiro Cenario.
	 * @param c2 O segundo Cenario.
	 * 
	 * @returns O inteiro que caracteriza a precedência entre os Cenarios.
	 * 
	 */
	@Override
	public int compare(Cenario c1, Cenario c2) {
		if (c1.totalApostasPerdedoras() == c2.totalApostasPerdedoras()) {
			return c1.getNumeracao() - c2.getNumeracao();
		}
		
		return c2.totalDeApostas() - c1.totalDeApostas();
	}

}
