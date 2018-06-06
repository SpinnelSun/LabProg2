package sorting;

import java.util.Comparator;

import models.Cenario;

/**
 * Representação de um ordenador de Cenarios cadastrados no Sistema de Apostas baseado nas descri-
 * ções dos Cenarios. Essa classe implementa a interface Comparator.
 * 
 * Laboratório de Programação 2 - Lab 05
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class CenarioPorDescricao implements Comparator<Cenario> {

	/**
	 * Implementação do método de Comparator que determina qual dos Cenarios passados como parâmetros
	 * precede o outro. Um cenario A precederá o Cenario B se sua descrição for lexicograficamente me-
	 * nor que a de B. Caso haja equivalência, a numeração dos Cenarios é usada para "desempate".
	 * 
	 * @param c1 O primeiro Cenario.
	 * @param c2 O segundo Cenario.
	 * 
	 * @return O inteiro que caracteriza a precedência entre os Cenarios.
	 * 
	 */
	@Override
	public int compare(Cenario c1, Cenario c2) {
		if (c1.getDescricao().equals(c2.getDescricao())) {
			return c1.getNumeracao() - c2.getNumeracao();
		}
		
		return c1.getDescricao().compareTo(c2.getDescricao());
	}

}
