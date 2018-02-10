package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Cenario;
import models.CenarioBonificado;
import utility.Validador;

/**
 * Representação de um Sistema de apostas em que serão registrados diversos Cenarios sobre os quais
 * se farão Apostas. Como atributos, um Sistema possui um valor (em centavos) de caixa e um double
 * que representa o percentual de ganho do caixa sobre as apostas perdedoras.
 * 
 * Laboratório de Programação 2 - Lab 05
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class Sistema {
	
	private int caixa;
	private double taxa;
	private List<Cenario> cenarios;
	
	/**
	 * Constrói um Sistema a partir do seu valor inicial (em centavos) em caixa e da taxa de ganho
	 * de seu caixa sobre as apostas perdedoras. Não é permitida a criação de um Sistema com caixa
	 * ou taxa negativas. Não é permitido a criação de um Sistema com ganho percentual acima de 1.
	 * 
	 * @param caixa O valor inicial (em centavos) do caixa do Sistema.
	 * @param taxa O percentual (representado em double) do ganho do Sistema sobre as apostas.
	 * 
	 */
	public Sistema(int caixa, double taxa) {
		try {
			Validador.validarNotNegativeInteger("Caixa nao pode ser inferior a 0", caixa);
			Validador.validarNotNegativeDouble("Taxa nao pode ser inferior a 0", taxa);
			Validador.validarPercentage("TAXA INVÁLIDA!", taxa);
			
			this.caixa = caixa;
			this.taxa = taxa;
			this.cenarios = new ArrayList<>();
		} 
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na inicializacao: " + e.getMessage());
		}
	}

	public int getCaixa() {
		return this.caixa;
	}
	
	public double getTaxa() {
		return this.taxa;
	}
	
	public int getQtdCenarios() {
		return this.cenarios.size();
	}

	public void setCaixa(int caixa) {
		this.caixa = caixa;
	}
	
	/**
	 * Determina se um Cenario que o usuário pretende acessar é válido. Para que seja válido, a nu-
	 * meração do Cenario tem que corresponder a um Cenario já cadastrado.
	 * 
	 * @param cenario O ID do Cenario que se deseja acessar.
	 * 
	 * @returns null.
	 * 
	 */
	private void validezCenario(int cenario) {
		Validador.validarPositiveInteger("Cenario invalido", cenario);
		Validador.validarLessEqualThan("Cenario nao cadastrado", cenario, this.cenarios.size());
	}
	
	/**
	 * Cadastra um novo Cenario no Sistema e retorna o int que será o ID do Cenario cadastrado. Caso
	 * algum parâmetro gere o lançamento de exceção, ela é tratada e relançada, visando melhor inte-
	 * ração com o usuário. 
	 * 
	 * @param descricao A descrição do Cenario que será cadastrado.
	 * 
	 * @returns O ID do Cenario cadastrado.
	 * 
	 */
	public int cadastrarCenario(String descricao) {
		try {
			this.cenarios.add(new Cenario(this.cenarios.size() + 1, descricao));
			return this.cenarios.size();
		}
		
		catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: " + e1.getMessage());
		}
		
		catch (NullPointerException e2) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: " + e2.getMessage());
		}
	}
	
	/**
	 * Cadastra um novo CenarioBonificado no Sistema e retorna o int que será o ID do Cenario ca-
	 * dastrado. Caso algum parâmetro gere o lançamento de exceção, ela é tratada e relançada, vi-
	 * sando melhor interação com o usuário. 
	 * 
	 * @param descricao A descrição do CenarioBonificado que será cadastrado.
	 * @param bonus O valor de bônus que o CenarioBonificado possuirá.
	 * 
	 * @returns O ID do CenarioBonificado cadastrado.
	 * 
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		try {
			Validador.validarLessEqualThan("O CAIXA NÃO SUPORTA ESSE BÔNUS!", bonus, this.caixa);
			
			this.cenarios.add(new CenarioBonificado(this.cenarios.size() + 1, descricao, bonus));
			this.caixa -= bonus;
			
			return this.cenarios.size();
		}
		
		catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: " + e1.getMessage());
		}
		
		catch (NullPointerException e2) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: " + e2.getMessage());
		}
	}
	
	/**
	 * Retorna a representação textual do Cenario cujo ID é o parâmetro desse método. Caso algum
	 * parâmetro gere o lançamento de exceção, ela é tratada e relançada, visando melhor intera-
	 * ção com o usuário.  
	 * 
	 * @param cenario O ID do Cenario que se deseja acessar.
	 * 
	 * @returns A String que representa o Cenario acessado.
	 * 
	 */
	public String exibirCenario(int cenario) {
		try {
			this.validezCenario(cenario);
			return this.cenarios.get(cenario - 1).toString();
		} 
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta de cenario: " + e.getMessage());
		}
	}
	
	/**
	 * Retorna a listagem do Cenarios cadastros no Sistema até o momento. Cada linha da listagem
	 * contém o toString() de um Cenario registrado. A listagem segue a ordem de registro dos Ce-
	 * narios.  
	 * 
	 * @returns A listagem de Cenarios registrados no Sistema.
	 * 
	 */
	public String listarCenarios() {
		String representacaoTextual = "";
		
		for (int i = 0; i < this.cenarios.size(); i++) {
			representacaoTextual += this.cenarios.get(i).toString() + System.lineSeparator();
		}
		
		return representacaoTextual;
	}
	
	/**
	 * A partir dos parâmetros recebidos, cadastra uma nova Aposta em um Cenario já registrado no
	 * Sistema. Caso algum parâmetro gere o lançamento de exceção, ela é tratada e relançada, vi-
	 * sando melhor interação com o usuário.  
	 * 
	 * @param cenario O ID do Cenario que se deseja acessar.
	 * @param apostador O nome da pessoa que fez a Aposta.
	 * @param valor O valor (em centavos) que foi apostado.
	 * @param previsao O texto que explicita a previsão sobre a ocorrência do Cenario.
	 * 
	 * @returns O ID da Aposta cadastrada.
	 * 
	 */
	public int cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		try {
			this.validezCenario(cenario);
			return this.cenarios.get(cenario - 1).cadastrarAposta(apostador, valor, previsao);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: " + e.getMessage());
		}
	}
	
	/**
	 * A partir dos parâmetros recebidos, cadastra uma nova Aposta com Seguro por Valor em um Ce-
	 * nario já registrado no Sistema. Caso algum parâmetro gere o lançamento de exceção, ela é
	 * tratada e relançada, visando melhor interação com o usuário.  
	 * 
	 * @param cenario O ID do Cenario que se deseja acessar.
	 * @param apostador O nome da pessoa que fez a Aposta.
	 * @param valor O valor (em centavos) que foi apostado.
	 * @param valorSeguro O valor assegurado nessa Aposta.
	 * @param custo O custo pago ao Sistema de Apostas na compra do Seguro.
	 * 
	 * @returns O ID da ApostaAssegurada cadastrada.
	 * 
	 */
	public int cadastrarAposta(int cenario, String apostador, int valor, String previsao,
			                    int valorSeguro, int custo) {
		try {
			Validador.validarPositiveInteger("CUSTO INVÁLIDO!", custo);
			this.validezCenario(cenario);
			
			this.caixa += custo;
			
			return this.cenarios.get(cenario - 1).cadastrarAposta(apostador, valor, previsao, valorSeguro);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: "
		                                       + e.getMessage());
		}
	}
	
	/**
	 * A partir dos parâmetros recebidos, cadastra uma nova Aposta com Seguro por Taxa em um Ce-
	 * nario já registrado no Sistema. Caso algum parâmetro gere o lançamento de exceção, ela é
	 * tratada e relançada, visando melhor interação com o usuário.  
	 * 
	 * @param cenario O ID do Cenario que se deseja acessar.
	 * @param apostador O nome da pessoa que fez a Aposta.
	 * @param valor O valor (em centavos) que foi apostado.
	 * @param taxaSeguro A taxa assegurada nessa Aposta.
	 * @param custo O custo pago ao Sistema de Apostas na compra do Seguro.
	 * 
	 * @returns O ID da ApostaAssegurada cadastrada.
	 * 
	 */
	public int cadastrarAposta(int cenario, String apostador, int valor, String previsao,
							    double taxaSeguro, int custo) {
		try {
			this.validezCenario(cenario);

			Validador.validarPositiveInteger("CUSTO INVÁLIDO!", custo);
			this.caixa += custo;

			return this.cenarios.get(cenario - 1).cadastrarAposta(apostador, valor, previsao, taxaSeguro);
		}

		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: "
												+ e.getMessage());
		}
	}
	
	/**
	 * A partir dos parâmetros recebidos, modifica o Seguro de uma Aposta com Seguro previamente ca-
	 * dastrada no Sistema, dando-lhe um novo Seguro por Valor. Caso algum parâmetro gere o lançamen-
	 * to de exceção, ela é tratada e relançada, visando melhor interação com o usuário. 
	 * 
	 * @param cenario O ID do Cenario que contém a Aposta.
	 * @param apostaAssegurada O ID da Aposta que terá seu Seguro modificado.
	 * @param valorSeguro O valor assegurado através do novo Seguro da Aposta.
	 * 
	 * @returns O ID da Aposta com novo Seguro.
	 * 
	 */
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valorSeguro) {
		try {
			this.validezCenario(cenario);
			return this.cenarios.get(cenario - 1).alterarSeguroValor(apostaAssegurada, valorSeguro);
		}

		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na alteração para seguro por valor: "
												+ e.getMessage());
		}
	}
	
	/**
	 * A partir dos parâmetros recebidos, modifica o Seguro de uma Aposta com Seguro previamente ca-
	 * dastrada no Sistema, dando-lhe um novo Seguro por Taxa. Caso algum parâmetro gere o lançamen-
	 * to de exceção, ela é tratada e relançada, visando melhor interação com o usuário. 
	 * 
	 * @param cenario O ID do Cenario que contém a Aposta.
	 * @param apostaAssegurada O ID da Aposta que terá seu Seguro modificado.
	 * @param taxaSeguro A taxa assegurada através do novo Seguro da Aposta.
	 * 
	 * @returns O ID da Aposta com novo Seguro.
	 * 
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxaSeguro) {
		try {
			this.validezCenario(cenario);
			return this.cenarios.get(cenario - 1).alterarSeguroTaxa(apostaAssegurada, taxaSeguro);
		}

		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na alteração para seguro por taxa: "
												+ e.getMessage());
		}
	}
	
	/**
	 * Retorna o valor total (em centavos) que foi apostado em um dos Cenarios registrados no Sis-
	 * tema até o momento. O valor total é a soma do valor de cada Aposta registrada no Cenario. Se
	 * algum parâmetro gerar o lançamento de exceção, ela é tratada e relançada, visando melhor in-
	 * teração com o usuário.  
	 * 
	 * @param cenario O ID do Cenario que se deseja acessar.
	 * 
	 * @returns O valor total (em centavos) que foi apostado no Cenario acessado.
	 * 
	 */
	public int valorTotalDeApostas(int cenario) {
		try {
			this.validezCenario(cenario);
			return this.cenarios.get(cenario - 1).valorTotalDeApostas();
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: " + e.getMessage());
		}
	}
	
	/**
	 * Retorna o número de Apostas registradas em um dos Cenarios registrados no Sistema até o mo-
	 * mento. Caso algum parâmetro gere o lançamento de exceção, ela é tratada e relançada, visan-
	 * do melhor interação com o usuário.  
	 * 
	 * @param cenario O ID do Cenario que se deseja acessar.
	 * 
	 * @returns O número de Apostas registradas no Cenario acessado.
	 * 
	 */
	public int totalDeApostas(int cenario) {
		try {
			this.validezCenario(cenario);
			return this.cenarios.get(cenario - 1).totalDeApostas();
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: " + e.getMessage());
		}
	}
	
	/**
	 * Retorna a listagem de Apostas registradas em um dos Cenarios registrados no Sistema até o mo-
	 * mento. Cada linha da listagem contém o toString() de uma Aposta registrada. A listagem segue
	 * a ordem de registro das Apostas. Caso algum parâmetro gere o lançamento de exceção, ela será
	 * tratada e relançada, visando melhor interação com o usuário.  
	 * 
	 * @param cenario O ID do Cenario que se deseja acessar.
	 * 
	 * @returns A listagem de Apostas registradas no Cenario acessado.
	 * 
	 */
	public String listarApostas(int cenario) {
		try {
			this.validezCenario(cenario);
			return this.cenarios.get(cenario - 1).listarApostas();
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta de apostas do cenario: " + e.getMessage());
		}
	}
	
	/**
	 * Finaliza um dos Cenarios registrados no Sistema até o momento. Dentre os dois estados "Fina-
	 * lizado" possíveis, o correto é escolhido a partir do boolean passado como parâmetro do méto-
	 * do. Caso algum parâmetro gere o lançamento de exceção, ela será tratada e relançada, visan-
	 * do melhor interação com o usuário.  
	 * 
	 * @param cenario O ID do Cenario que se deseja acessar.
	 * @param ocorrencia O boolean relativo à ocorrência do Cenário.
	 * 
	 * @returns null.
	 * 
	 */
	public void encerrarCenario(int cenario, boolean ocorrencia) {
		try {
			this.validezCenario(cenario);
			this.cenarios.get(cenario - 1).defineOcorrencia(ocorrencia);
			this.caixa += this.lucroCenario(cenario);
			this.caixa -= this.cenarios.get(cenario - 1).pagamentoSeguros();
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro ao fechar aposta: " + e.getMessage());
		}
	}
	
	/**
	 * Retorna o valor (em centavos) correspondente ao lucro do caixa a partir das Apostas perdedo-
	 * ras de um Cenario registrado no Sistema até o momento. Caso algum parâmetro gere o lançamen-
	 * to de exceção, ela será tratada e relançada, visando melhor interação com o usuário.  
	 * 
	 * @param cenario O ID do Cenario que se deseja acessar.
	 * 
	 * @returns O valor (em centavos) de lucro do caixa em decorrência do Cenario acessado.
	 * 
	 */
	public int lucroCenario(int cenario) {
		try {
			this.validezCenario(cenario);
			return this.cenarios.get(cenario - 1).lucroCenario(this.taxa) ;
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: " + e.getMessage());
		}
	}
	
	/**
	 * Retorna o valor (em centavos) que será destinado ao rateio entre os vencedores de um Cenario
	 * registrado no Sistema até o momento. Caso algum parâmetro gere o lançamento de exceção, ela
	 * será tratada e relançada, visando melhor interação com o usuário.  
	 * 
	 * @param cenario O ID do Cenario que se deseja acessar.
	 * 
	 * @returns O valor (em centavos) que será destinado ao rateio entre os vencedores.
	 * 
	 */
	public int rateioCenario(int cenario) {
		try {
			this.validezCenario(cenario);
			return this.cenarios.get(cenario - 1).rateioCenario(this.taxa);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: "
												+ e.getMessage());
		}
	}
	
}
