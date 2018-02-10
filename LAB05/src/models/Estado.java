package models;

/**
 * Representação dos estados em que um Cenario pode se encontrar. Cada Estado é definido a partir
 * de uma String nos padrões especificados.
 * 
 * Laboratório de Programação 2 - Lab 05
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public enum Estado {
	
	NAO_FINALIZADO("Nao finalizado"),
	
	FINALIZADO_OCORREU("Finalizado (ocorreu)"),
	
	FINALIZADO_NAO_OCORREU("Finalizado (n ocorreu)");
	
	
	private String estado;
	
	/**
	 * Constrói um Estado a partir de uma String que o defina.
	 * 
	 * @param estado A String que caracteriza o Estado.
	 * 
	 */
	Estado(String estado) {
		this.estado = estado;
	}
	
	/**
	 * Retorna a String que define o Estado.
	 * 
	 * @returns A representação textual de um Estado.
	 * 
	 */
	@Override
	public String toString() {
		return this.estado;
	}

}