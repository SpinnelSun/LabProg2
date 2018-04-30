package models;

/**
 * Representação do estado de saúde de um estudante universitário. Um estado de saúde deve conter
 * as situações da saúde mental e da saúde física do estudante, a situação da saúde geral desse
 * estudante e o emoji que descreva a última sensação do estudante no decorrer do status atual de
 * sua saúde geral. As situações de saúde mental e física podem ser "fraca" ou "boa".
 *
 * Laboratório de Programação 2 - Lab 02
 * @author Matheus Alves dos Santos - 117110503
 * 
 */
public class Saude {
	
	private String saudeMental;
	private String saudeFisica;
	private String emoji;
	
	/**
	 *  Constrói um estado de saúde de um estudante. Inicializa a situações da saúde física e da
	 *  saúde mental como "boa" e inicializa o emoji de última sensação como uma String vazia.
	 *  
	 */
	public Saude() {
		this.saudeFisica = "boa";
		this.saudeMental = "boa";
		this.emoji = "";
	}
	
	public String getEmoji() {
		return emoji;
	}

	/**
	 *  Atualiza o estado da saúde mental do estudante, o que poderá ou não provocar mudança no
	 *  estado de saúde geral do mesmo.
	 *  
	 *  @param valor O estado da saúde mental do estudante.
	 * 
	 * @returns null
	 * 
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor.toLowerCase();
	}
	
	/**
	 *  Atualiza o estado da saúde física do estudante, o que poderá ou não provocar mudança no
	 *  estado de saúde geral do mesmo.
	 *  
	 *  @param valor O estado da saúde física do estudante.
	 * 
	 *  @returns null
	 *  
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor.toLowerCase();
	}
	
	/**
	 *  Armazena o emoji que representa a última sensação do estudante durante o atual quadro de
	 *  saúde.
	 *  
	 *  @param valor O emoji que representa a última sensação do estudante.
	 *  
	 *  @returns null
	 *  
	 */
	public void defineEmoji(String valor) {
		this.emoji = valor;
	}
	
	/**
	 *  Restaura o emoji de última sensação do estudante ao seu valor default, ou seja, torna-o 
	 *  uma String vazia.
	 *  
	 *  @returns null
	 *  
	 */
	private void restaurarEmoji() {
		this.emoji = "";
	}
	
	/**
	 *  A partir das situações de saúde física e de saúde mental, avalia o status da saúde geral
	 *  do estudante. A cada nova avaliação, o emoji de sensação voltará ao seu valor padrão.
	 *  
	 *  Para uma saúde geral boa, saúde física e saúde mental devem estar boas. Já para uma saúde
	 *  geral fraca, saúde física e saúde mental devem estar fracas. Nos demais casos, tem-se que
	 *  a saúde geral está ok.  
	 *  
	 *  @returns null
	 *  
	 */
	private String avaliarSaudeGeral() {
		this.restaurarEmoji();
		return (this.saudeMental.equals(this.saudeFisica)) ? this.saudeFisica : "ok";
	}
	
	/**
	 *  Retorna uma String que representa o estado de saúde do estudante. A representação utiliza
	 *  o padrão "(Estado de Saúde Geral) (Emoji de Sensação)".
	 *  
	 *  @returns A representação em String de um estado de saúde.
	 *  
	 */
	public String getStatusGeral() {
		return this.avaliarSaudeGeral() + " " + this.getEmoji();
	}

}
