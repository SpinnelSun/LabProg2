package sorting;

import java.util.Comparator;

import models.Cenario;

/**
 * Representação de um ordenador de Cenarios cadastrados no Sistema de Apostas baseado na numeração
 * (ID) dos Cenarios. Essa classe implementa a interface Comparator.
 * 
 * Laboratório de Programação 2 - Lab 05
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class CenarioPorNumeracao implements Comparator<Cenario> {

	/**
	 * Implementação do método de Comparator que determina qual dos Cenarios passados como parâmetros
	 * precede o outro. Um cenario A precederá o Cenario B se sua numeração tiver valor menor.
	 * 
	 * @param c1 O primeiro Cenario.
	 * @param c2 O segundo Cenario.
	 * 
	 * @return O inteiro que caracteriza a precedência entre os Cenarios.
	 * 
	 */
	@Override
	public int compare(Cenario c1, Cenario c2) {
		return c1.getNumeracao() - c2.getNumeracao();
	}

}
