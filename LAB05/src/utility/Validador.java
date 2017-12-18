package utility;

/**
 * Representação de um validador de informações, no qual estão armazenados os métodos para evitar a
 * utilização de informações inválidas. Essa classe visa evitar a repetição de código necessário em
 * validações idênticas ou semelhantes.
 * 
 * Laboratório de Programação 2 - Lab 05
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class Validador {
	
	/**
	 * Avalia se uma String é vazia ou nula.
	 * 
	 * @param msg A mensagem a ser associada à exceção lançada.
	 * @param str A string a ser validada como não-vazia e não-nula.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarNotEmptyNotNull(String msg, String str) {
		if (str == null) {
			throw new NullPointerException(msg); 
		}
		
		if (str.trim().equals("")) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	/**
	 * Avalia se um int é positivo.
	 * 
	 * @param msg A mensagem a ser associada à exceção lançada.
	 * @param value O inteiro a ser validado como positivo.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarPositiveInteger(String msg, int value) {
		if (value < 1) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	/**
	 * Avalia se um int é não-negativo.
	 * 
	 * @param msg A mensagem a ser associada à exceção lançada.
	 * @param value O inteiro a ser validado como não-negativo.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarNotNegativeInteger(String msg, int value) {
		if (value < 0) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	/**
	 * Avalia se um double é não-negativo.
	 * 
	 * @param msg A mensagem a ser associada à exceção lançada.
	 * @param value O double a ser validado como não-negativo.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarNotNegativeDouble(String msg, double value) {
		if (value < 0) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	/**
	 * Avalia se um inteiro é menor ou igual a outro int.
	 * 
	 * @param msg A mensagem a ser associada à exceção lançada.
	 * @param value1 O int que se espera ser menor.
	 * @param value2 O int que se espera ser maior.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarLessEqualThan(String msg, int value1, int value2) {
		if (value1 > value2) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	/**
	 * Avalia se um double é uma representação válida para um percentual.
	 * 
	 * @param msg A mensagem a ser associada à exceção lançada.
	 * @param value O double a ser validado como percentual válido.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarPercentage(String msg, double value) {
		if ((value < 0) || (value > 1)) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
}
