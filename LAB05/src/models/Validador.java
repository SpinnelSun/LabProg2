package models;

/**
 * Representação de um validador de informações, no qual estão armazenados os métodos para evitar a utilização de
 * informações nulas ou vazias. A existência dessa classe evita a repetição de código nos construtores de Aluno e
 * de Grupo, bem como no Menu.
 * 
 * Laboratório de Programação 2 - Lab 04
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class Validador {
	
	/**
	 * Avalia se um objeto não é nulo.
	 * 
	 * @param msg A mensagem a ser associada à exceção lançada.
	 * @param obj O objeto a ser validado como não-nulo.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarNotNull(String msg, Object obj) {
		if (obj == null) {
			throw new NullPointerException(msg); 
		}
	}
	
	/**
	 * Avalia se uma String não contém apenas espaços em branco.
	 * 
	 * @param msg A mensagem a ser associada à exceção lançada.
	 * @param str A String a ser validada como não-vazia.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarNotEmpty(String msg, String str) {
		if (str.trim().equals("")) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	public static void validarPositiveInteger(String msg, int value) {
		if (value < 1) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	public static void validarNotNegativeInteger(String msg, int value) {
		if (value < 0) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	public static void validarNotNegativeDouble(String msg, double value) {
		if (value < 0) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	public static void validarLessEqualThan(String msg, int value1, int value2) {
		if (value2 > value1) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	
	
}
