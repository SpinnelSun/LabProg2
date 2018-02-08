package controllers;

import easyaccept.EasyAccept;

/**
 * Facade Controller do Sistema de Apostas.
 * 
 * Laboratório de Programação 2 - Lab 05
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class Facade {
	
	private Sistema sistema;
	
	public static void main(String[] args) {
		args = new String[] {"controllers.Facade", "acc_tst/us1_test.txt", "acc_tst/us2_test.txt",
				             "acc_tst/us3_test.txt", "acc_tst/us4_test.txt", "acc_tst/us5_test.txt",
				             "acc_tst/us6_test.txt"};
		
		EasyAccept.main(args);
	}
	
	/**
	 * Inicializa o Sistema de Apostas.
	 * 
	 * @param caixa O valor inicial do caixa do Sistema.
	 * @param taxa O percentual de ganho do Sistema sobre as apostas.
	 * 
	 * @return null.
	 * 
	 * @see Sistema#Sistema(int, double)
	 * 
	 */
	public void inicializa(int caixa, double taxa) {
		this.sistema = new Sistema(caixa, taxa);
	}
	
	/**
	 * Retorna o valor atual em caixa do Sistema de Apostas.
	 * 
	 * @return O valor atual em caixa.
	 * 
	 * @see Sistema#getCaixa()
	 * 
	 */
	public int getCaixa() {
		return this.sistema.getCaixa();
	}
	
	/**
	 * Cadastra um novo Cenario no Sistema de Apostas.
	 * 
	 * @param descricao A descrição do novo Cenario a ser cadastrado.
	 * 
	 * @return O ID do Cenario cadastrado.
	 * 
	 * @see Sistema#cadastrarCenario(String)
	 * 
	 */
	public int cadastrarCenario(String descricao) {
		return this.sistema.cadastrarCenario(descricao);
	}
	
	/**
	 * Cadastra um novo Cenario com Bônus no Sistema de Apostas.
	 * 
	 * @param descricao A descrição do novo Cenario a ser cadastrado.
	 * @param bonus O valor (em centavos) do bônus que o Cenario possuirá.
	 * 
	 * @return O ID do Cenario cadastrado.
	 * 
	 * @see Sistema#cadastrarCenario(String, int)
	 * 
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		return this.sistema.cadastrarCenario(descricao, bonus);
	}
	
	/**
	 * Exibe um Cenario cadastrado no Sistema de Apostas.
	 * 
	 * @param cenario O ID do Cenario a ser exibido.
	 * 
	 * @return A representação textual do Cenario.
	 * 
	 * @see Sistema#exibirCenario(int)
	 * 
	 */
	public String exibirCenario(int cenario) {
		return this.sistema.exibirCenario(cenario);
	}
	
	/**
	 * Exibe todos os Cenarios cadastrados no Sistema de Apostas.
	 * 
	 * @return A listagem de Cenarios registrados.
	 *
	 * @see Sistema#listarCenarios()
	 * 
	 */
	public String exibirCenarios() {
		return this.sistema.listarCenarios();
	}

	/**
	 * Cadastra uma nova Aposta em um dos Cenarios cadastrados no Sistema de Apostas.
	 * 
	 * @param cenario O ID do Cenario que receberá a Aposta.
	 * @param apostador O nome do apostador.
	 * @param valor O valor apostado.
	 * @param previsao A previsão da Aposta.
	 * 
	 * @return null.
	 * 
	 * @see Sistema#cadastrarAposta(int, String, int, String)
	 * 
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.sistema.cadastrarAposta(cenario, apostador, valor, previsao);
	}
	
	public void cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao,
			                               int valorSeguro, int custo) {
		this.sistema.cadastrarAposta(cenario, apostador, valor, previsao, valorSeguro, custo);
	}
	
	public void cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao,
			                              double taxaSeguro, int custo) {
		this.sistema.cadastrarAposta(cenario, apostador, valor, previsao, taxaSeguro, custo);
	}
	
	/**
	 * Calcula o valor total apostado em um dos Cenarios do Sistema de Apostas.
	 * 
	 * @param cenario O ID do Cenario a ser avaliado.
	 * 
	 * @return O valor total apostato no Cenario.
	 * 
	 * @see Sistema#valorTotalDeApostas(int)
	 * 
	 */
	public int valorTotalDeApostas(int cenario) {
		return this.sistema.valorTotalDeApostas(cenario);
	}
	
	/**
	 * Calcula o número de Apostas de um dos Cenarios do Sistema de Apostas.
	 * 
	 * @param cenario O ID do Cenario a ser avaliado.
	 * 
	 * @return O número de Apostas registradas no Cenario.
	 * 
	 * @see Sistema#totalDeApostas(int)
	 * 
	 */
	public int totalDeApostas(int cenario) {
		return this.sistema.totalDeApostas(cenario);
	}
	
	/**
	 * Exibe as Apostas feitas sobre um dos Cenarios do Sistema de Apostas.
	 * 
	 * @param cenario O ID do Cenario a ser avaliado.
	 * 
	 * @return A listagem de Apostas do Cenario.
	 * 
	 * @see Sistema#listarApostas(int)
	 * 
	 */
	public String exibeApostas(int cenario) {
		return this.sistema.listarApostas(cenario);
	}
	
	/**
	 * Encerra as Apostas de um dos Cenarios do Sistema de Apostas.
	 * 
	 * @param cenario O ID do Cenario a ser avaliado.
	 * @param ocorreu A ocorrência do Cenario a ser encerrado.
	 * 
	 * @return null.
	 * 
	 * @see Sistema#encerrarCenario(int, boolean)
	 * 
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.sistema.encerrarCenario(cenario, ocorreu);
	}
	
	/**
	 * Calcula o ganho do caixa a partir do encerramento de um Cenario no Sistema de Apostas.
	 * 
	 * @param cenario O ID do Cenario a ser avaliado.
	 * 
	 * @return O lucro do caixa.
	 * 
	 * @see Sistema#lucroCenario(int)
	 * 
	 */
	public int getCaixaCenario(int cenario) {
		return this.sistema.lucroCenario(cenario);
	}
	
	/**
	 * Calcula o valor a ser rateado entre os vencedores a partir do encerramento de um Cenario no
	 * Sistema de Apostas.
	 * 
	 * @param cenario O ID do Cenario a ser avaliado.
	 * 
	 * @return O valor a ser rateado entre os vencedores.
	 * 
	 * @see Sistema#rateioCenario(int)
	 * 
	 */
	public int getTotalRateioCenario(int cenario) {
		return this.sistema.rateioCenario(cenario);
	}

}
