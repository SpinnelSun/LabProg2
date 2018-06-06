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
	 * Avalia se uma String é não-vazia. Lançará uma exceção adequada caso não o seja.
	 * 
	 * @param msg A mensagem a ser associada a exceção lançada.
	 * @param str A string a ser validada como não-vazia.
	 * 
	 */
	public static void validarStringNaoVazia(String msg, String str) {
		if (str.trim().equals("")) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	/**
	 * Avalia se uma String é não-nula. Lançará uma exceção adequada caso não o seja.
	 * 
	 * @param msg A mensagem a ser associada a exceção lançada.
	 * @param str A string a ser validada como não-nula.
	 * 
	 */
	public static void validarStringNaoNula(String msg, String str) {
		if (str == null) {
			throw new NullPointerException(msg); 
		}
	}
	
	/**
	 * Avalia se uma String é não-vazia e não-nula. Lançará uma exceção adequada caso não o seja.
	 * 
	 * @param msg A mensagem a ser associada a exceção lançada.
	 * @param str A string a ser validada como não-vazia e não-nula.
	 * 
	 */
	public static void validarStringNaoVaziaNaoNula(String msg, String str) {
		Validador.validarStringNaoVazia(msg, str);
		Validador.validarStringNaoNula(msg, str);
	}
	
	/**
	 * Avalia se um int é positivo.
	 * 
	 * @param msg A mensagem a ser associada à exceção lançada.
	 * @param value O inteiro a ser validado como positivo.
	 * 
	 */
	public static void validarInteiroPositivo(String msg, int value) {
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
	 */
	public static void validarInteiroNaoNegativo(String msg, int value) {
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
	 */
	public static void validarDoubleNaoNegativo(String msg, double value) {
		if (value < 0) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	/**
	 * Avalia se um inteiro é menor ou igual a outro inteiro.
	 * 
	 * @param msg A mensagem a ser associada à exceção lançada.
	 * @param value1 O int que se espera ser menor.
	 * @param value2 O int que se espera ser maior.
	 * 
	 */
	public static void validarMenorIgualQue(String msg, int value1, int value2) {
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
	 */
	public static void validarPercentual(String msg, double value) {
		if ((value < 0) || (value > 1)) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
}
