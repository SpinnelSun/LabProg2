package lab2;

/**
 * Representação do estado de saúde de um estudante universitário. Um estado de saúde deve conter
 * as situações da saúde mental e da saúde física do estudante, a situação da saúde geral desse
 * estudante e o emoji que descreva a última sensação do estudante no decorrer do status atual de
 * sua saúde geral. As situações de saúde mental e física podem ser "fraca" ou "boa", a situação
 * de saúde geral do estudante pode ser "fraca", "ok" ou "boa".
 *
 * Laboratório de Programação 2 - Lab 02
 * @author Matheus Alves dos Santos - 117110503
 */
public class Saude {
	
	private String saudeMental;
	private String saudeFisica;
	private String saudeGeral;
	private String emoji;
	
	/**
	 *  Constrói um estado de saúde de um estudante. Inicializa a situações da saúde física, da
	 *  saúde mental e da saúde geral como "boa" e inicializa o emoji de última sensação como uma
	 *  String vazia.
	 */
	public Saude() {
		this.saudeFisica = "boa";
		this.saudeMental = "boa";
		this.saudeGeral = "boa";
		this.emoji = "";
	}
	
	/**
	 *  Restaura o emoji de última sensação do estudante ao seu valor default, ou seja, torna-o 
	 *  uma String vazia.
	 *  
	 *  @returns null
	 */
	private void restauraEmoji() {
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
	 */
	private void avaliacaoSaudeGeral() {
		if(this.saudeMental.equals("boa") && this.saudeFisica.equals("boa")) {
			this.saudeGeral = "boa";
		} else if (this.saudeMental.equals("fraca") && this.saudeFisica.equals("fraca")) {
			this.saudeGeral = "fraca";
		} else {
			this.saudeGeral = "ok";
		}
		
		this.restauraEmoji();
	}
	
	/**
	 *  Atualiza o estado da saúde mental do estudante, o que poderá ou não provocar mudança no
	 *  estado de saúde geral do mesmo.
	 *  
	 *  @param valor O estado da saúde mental do estudante.
	 * 
	 * @returns null
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor.toLowerCase();
		this.avaliacaoSaudeGeral();
	}
	
	/**
	 *  Atualiza o estado da saúde física do estudante, o que poderá ou não provocar mudança no
	 *  estado de saúde geral do mesmo.
	 *  
	 *  @param valor O estado da saúde física do estudante.
	 * 
	 *  @returns null
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor.toLowerCase();
		this.avaliacaoSaudeGeral();
	}
	
	/**
	 *  Armazena o emoji que representa a última sensação do estudante durante o atual quadro de
	 *  saúde.
	 *  
	 *  @param valor O emoji que representa a última sensação do estudante.
	 *  
	 *  @returns null
	 */
	public void definirEmoji(String valor) {
		this.emoji = valor;
	}
	
	/**
	 *  Retorna uma String que representa o estado de saúde do estudante. A representação utiliza
	 *  o padrão"Estado de Saúde Geral Emoji de Sensação desse Estado".
	 *  
	 *  @returns A representação em String de um estado de saúde.
	 */
	public String geral() {
		return this.saudeGeral + " " + this.emoji;
	}

}
