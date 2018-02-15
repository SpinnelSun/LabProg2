package views;

/**
 * Representação em interface do Seguro de uma Aposta Assegurada, visando a melhor interação do Sis-
 * tema com os dois tipos de Seguros existentes.
 * 
 * Laboratório de Programação 2 - Lab 05
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public interface Seguro {
	
	/**
	 * Método a ser implementado por SeguroPorValor e SeguroPorTaxa. Esse método calcula, de acordo
	 * com o tipo de Seguro, o quanto do valor apostado será assegurado.
	 * 
	 * @param valorAposta O valor (em centavos) que foi apostado.
	 * 
	 * @returns A quantia que será assegurada.
	 * 
	 */
    public int quantiaAssegurada(int valorAposta);

}
