package utility;

/**
 * Representação de um validador de informações, no qual estão armazenados os métodos para evitar a
 * utilização de informações inválidas. Essa classe visa evitar a repetição de código necessário em
 * validações idênticas ou semelhantes.
 * 
 * Laboratório de Programação 2 - Lab 03
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class Validador {
	
	/**
	 * Avalia se uma String é não-vazia. Lançará uma excecao adequada caso não o seja.
	 * 
	 * @param msg A mensagem a ser associada a exceção lançada.
	 * @param str A string a ser validada como não-vazia.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarStringNaoVazia(String msg, String str) {
		if (str.trim().equals("")) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	/**
	 * Avalia se uma String e não-nula. Lançará uma excecao adequada caso não o seja.
	 * 
	 * @param msg A mensagem a ser associada a exceção lançada.
	 * @param str A string a ser validada como não-nula.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarStringNaoNula(String msg, String str) {
		if (str == null) {
			throw new NullPointerException(msg); 
		}
	}
	
	/**
	 * Avalia se uma String e não-vazia e não-nula. Lançará uma exceção adequada caso não o seja.
	 * 
	 * @param msg A mensagem a ser associada a exceção lançada.
	 * @param str A string a ser validada como não-vazia e não-nula.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarStringNaoVaziaNaoNula(String msg, String str) {
		Validador.validarStringNaoVazia(msg, str);
		Validador.validarStringNaoNula(msg, str);
	}	
	
	/**
	 * Avalia se um número inteiro esta no intervalo [1, 100].
	 * 
	 * @param value O inteiro a ser validado no intervalo [1, 100].
	 * 
	 * @returns null.
	 * 
	 */
	public static boolean validarIntUmACem(int valor) {
		return ((valor >= 1) && (valor <= 100));
	}
	
}