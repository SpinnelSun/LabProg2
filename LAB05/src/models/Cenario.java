package models;

import java.util.ArrayList;
import java.util.List;

import utility.Validador;

/**
 * Representação de um Cenario criado num Sistema, sobre o qual serão feitas Apostas. Como atributos,
 * cada Cenario possui uma numeração inteira que o identifica, uma String que o descreve, um Estado
 * que indica sua finalização e/ou ocorrência e uma lista de apostas feitas sobre ele.
 * 
 * Laboratório de Programação 2 - Lab 05
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class Cenario {
	
	private int numeracao;
	private String descricao;
	private Estado estado;
	private List<Aposta> apostas;
	

	/**
	 * Constrói um Cenario a partir da numeração que o identifica e da String que o descreve. Não é
	 * permitida a criação de um Cenario cuja descrição seja nula ou vazia. Não é permitida a cria-
	 * ção de um Cenario cuja numeração seja menor ou igual a zero. O estado do Cenario será inicia-
	 * lizado como "Nao finalizado" e a lista com as apostas sobre ele é, inicialmente, vazia.
	 * 
	 * @param numeracao O inteiro que atua como ID de cada Cenario.
	 * @param descricao O texto que descreve brevemente o Cenario.
	 * 
	 */
	public Cenario(int numeracao, String descricao) {
		Validador.validarNotEmptyNotNull("Descricao nao pode ser vazia", descricao);
		Validador.validarPositiveInteger("NUMERAÇÃO INVÁLIDA!", numeracao);
		
		this.numeracao = numeracao;
		this.descricao = descricao;
		estado = Estado.NAO_FINALIZADO;
		this.apostas = new ArrayList<>();
	}
	
	public int getNumeracao() {
		return this.numeracao;
	}


	public String getDescricao() {
		return this.descricao;
	}
	
	public Estado getEstado() {
		return this.estado;
	}
	
	/**
	 * Finaliza um Cenario ainda aberto. Dentre os dois estados "Finalizado" possíveis, o correto é
	 * escolhido a partir do boolean passado como parâmetro do método. Caso esse método seja execu-
	 * tado por um Cenario já fechado, uma exceção adequada é lançada.
	 * 
	 * @param ocorrencia O boolean relativo à ocorrência do Cenário.
	 * 
	 * @returns null.
	 * 
	 */
	public void defineOcorrencia(boolean ocorrencia) {
		if (!this.estado.equals(Estado.NAO_FINALIZADO)) {
			throw new IllegalArgumentException("Cenario ja esta fechado");
		}
		
		this.estado = (ocorrencia) ? Estado.FINALIZADO_OCORREU : Estado.FINALIZADO_NAO_OCORREU;
	}
	
	/**
	 * A partir dos parâmetros recebidos, constroi uma nova Aposta e a adiciona à lista de Apostas
	 * que é atributo do Cenario.
	 * 
	 * @param apostador O nome da pessoa que fez a Aposta.
	 * @param valor O valor (em centavos) que foi apostado.
	 * @param previsao O texto que explicita a previsão sobre a ocorrência do Cenario.
	 * 
	 * @returns O ID da Aposta cadastrada.
	 * 
	 */
	public int cadastrarAposta(String apostador, int valor, String previsao) {		 
		this.apostas.add(new Aposta(apostador, valor, previsao));
		return this.apostas.size();
	}
	
	/**
	 * A partir dos parâmetros recebidos, constroi uma nova Aposta com Seguro por Valor e a adicio-
	 * na à lista de Apostas que é atributo do Cenario.
	 * 
	 * @param apostador O nome da pessoa que fez a Aposta.
	 * @param valor O valor (em centavos) que foi apostado.
	 * @param previsao O texto que explicita a previsão sobre a ocorrência do Cenario.
	 * @param valorSeguro O valor (em centavos) assegurado na Aposta cadastrada.
	 * 
	 * @returns O ID da ApostaAssegurada cadastrada.
	 * 
	 */
	public int cadastrarAposta(String apostador, int valor, String previsao, int valorSeguro) {		 
		this.apostas.add(new ApostaAssegurada(apostador, valor, previsao, valorSeguro));
		return this.apostas.size();
	}
	
	/**
	 * A partir dos parâmetros recebidos, constroi uma nova Aposta com Seguro por Taxa e a adicio-
	 * na à lista de Apostas que é atributo do Cenario.
	 * 
	 * @param apostador O nome da pessoa que fez a Aposta.
	 * @param valor O valor (em centavos) que foi apostado.
	 * @param previsao O texto que explicita a previsão sobre a ocorrência do Cenario.
	 * @param taxaSeguro A taxa assegurada na Aposta cadastrada.
	 * 
	 * @returns O ID da ApostaAssegurada cadastrada.
	 * 
	 */
	public int cadastrarAposta(String apostador, int valor, String previsao, double taxaSeguro) {		 
		this.apostas.add(new ApostaAssegurada(apostador, valor, previsao, taxaSeguro));
		return this.apostas.size();
	}
	
	/**
	 * A partir dos parâmetros recebidos, modifica o Seguro de uma Aposta com Seguro previamente ca-
	 * dastrada no Sistema, dando-lhe um novo Seguro por Valor. Ocorre o lançamento de uma exceção
	 * caso se tente alterar o Seguro de uma Aposta comum.
	 * 
	 * @param apostaAssegurada O ID da Aposta que terá seu Seguro modificado.
	 * @param valorSeguro O valor assegurado através do novo Seguro da Aposta.
	 * 
	 * @returns O ID da Aposta com novo Seguro.
	 * 
	 */
	public int alterarSeguroValor(int apostaAssegurada, int valorSeguro) {
		if (this.apostas.get(apostaAssegurada - 1) instanceof ApostaAssegurada) {
			((ApostaAssegurada) this.apostas.get(apostaAssegurada - 1)).setSeguro(valorSeguro);
			return apostaAssegurada;
		}
		
		throw new IllegalArgumentException("ESSA APOSTA NÃO POSSUI SEGURO!");
	}
	
	/**
	 * A partir dos parâmetros recebidos, modifica o Seguro de uma Aposta com Seguro previamente ca-
	 * dastrada no Sistema, dando-lhe um novo Seguro por Taxa. Ocorre o lançamento de uma exceção
	 * caso se tente alterar o Seguro de uma Aposta comum.
	 * 
	 * @param apostaAssegurada O ID da Aposta que terá seu Seguro modificado.
	 * @param taxaSeguro A taxa assegurada através do novo Seguro da Aposta.
	 * 
	 * @returns O ID da Aposta com novo Seguro.
	 * 
	 */
	public int alterarSeguroTaxa(int apostaAssegurada, double taxaSeguro) {
		if (this.apostas.get(apostaAssegurada - 1) instanceof ApostaAssegurada) {
			((ApostaAssegurada) this.apostas.get(apostaAssegurada - 1)).setSeguro(taxaSeguro);
			return apostaAssegurada;
		}
		
		throw new IllegalArgumentException("ESSA APOSTA NÃO POSSUI SEGURO!");	
	}
	
	/**
	 * Retorna o valor total (em centavos) que foi apostado no Cenario até o momento. O valor total
	 * é a soma do valor de cada Aposta registrada no Cenario.
	 * 
	 * @returns O valor total (em centavos) apostado no Cenario.
	 * 
	 */
	public int valorTotalDeApostas() {
		int totalApostas = 0;
		
		for (Aposta aposta : this.apostas) {
			totalApostas += aposta.getValor();			
		}
		
		return totalApostas;
	}
	
	/**
	 * Retorna o número de Apostas registradas no Cenario até o momento.
	 * 
	 * @returns O número de Apostas registradas no Cenario.
	 * 
	 */
	public int totalDeApostas() {
		return this.apostas.size();
	}
	
	/**
	 * Retorna a listagem de Apostas registradas no Cenario até o momento. Cada linha da listagem
	 * contém o toString() de uma Aposta registrada. A listagem segue a ordem de registro das Apos-
	 * tas.
	 * 
	 * @returns A listagem de Apostas registradas no Cenario.
	 * 
	 */
	public String listarApostas() {
		String representacaoTextual = "";
		
		for(Aposta aposta : this.apostas) {
			representacaoTextual += aposta.toString() + System.lineSeparator();
		}
		
		return representacaoTextual;
	}
	
	/**
	 * Retorna o valor total das Apostas perdedoras. Para que uma Aposta seja considerada perdedora,
	 * sua previsão sobre o Cenario não pode coincidir com a ocorrência do Cenário. Caso esse método
	 * seja executado por um Cenario ainda aberto, uma exceção adequada é lançada.
	 * 
	 * @returns O valor total (em centavos) das Apostas perdedoras do Cenario.
	 * 
	 */
	public int totalApostasPerdedoras() {
		if (this.estado.equals(Estado.NAO_FINALIZADO)) {
			throw new IllegalArgumentException("Cenario ainda esta aberto");
		}
		
		int total = 0;
		boolean ocorrencia = (this.estado.equals(Estado.FINALIZADO_OCORREU)) ? true : false;
		
		for (Aposta aposta : this.apostas) {
			if (aposta.getPrevisao() != ocorrencia) {
					total += aposta.getValor();
			}
		}
		
		return total;
	}
	
	/**
	 * Retorna o valor (em centavos) correspondente ao lucro gerado a partir das Apostas perdedoras
	 * registradas no Cenario.  
	 * 
	 * @param taxa A taxa de lucro informada pelo Sistema que contém o Cenario.
	 * 
	 * @returns O valor (em centavos) de lucro gerado pelo Cenario.
	 * 
	 */
	public int lucroCenario(double taxa) {
		return (int) Math.floor(this.totalApostasPerdedoras() * taxa);
	}
	
	/**
	 * Retorna o custo total gerado pelo pagamento dos Seguros das ApostasAsseguradas perdedoras ca-
	 * dastradas no Cenario. Caso esse método seja executado por um Cenario ainda aberto, uma exce-
	 * ção adequada é lançada.
	 * 
	 * @returns O valor total (em centavos) que será pago devido aos Seguros no Cenario.
	 * 
	 */
	public int pagamentoSeguros() {
		if (this.estado.equals(Estado.NAO_FINALIZADO)) {
			throw new IllegalArgumentException("Cenario ainda esta aberto");
		}
		
		int perdasGeradas = 0;
		boolean ocorrencia = (this.estado.equals(Estado.FINALIZADO_OCORREU)) ? true : false;
		
		for (Aposta aposta : this.apostas) {
			if (aposta.getPrevisao() != ocorrencia) {
					perdasGeradas += aposta.perdaGerada();
			}
		}
		
		return this.totalApostasPerdedoras() - perdasGeradas;
		
	}
	
	/**
	 * Retorna o valor (em centavos) que será destinado ao rateio entre os vencedores do Cenario.  
	 * 
	 * @param taxa A taxa de lucro informada pelo Sistema que contém o Cenario.
	 * 
	 * @returns O valor (em centavos) que será destinado ao rateio entre os vencedores.
	 * 
	 */
	public int rateioCenario(double taxa) {
		return this.totalApostasPerdedoras() - this.lucroCenario(taxa);
	}
	
	/**
	 * Gera o HashCode de um Cenario a partir de seu atributo numeracao.
	 * 
	 * @returns O Hashcode do Cenario.
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.numeracao;
		return result;
	}

	/**
	 * Avalia se o Cenario é ou não igual a outro Object. Para que haja igualdade, deverão possuir 
	 * o atributo numeracao iguais.
	 * 
	 * @param obj O objeto a ser comparado com o Cenario executando o equals.
	 * @returns O boolean equivalente ao resultado do teste de igualdade.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Cenario other = (Cenario) obj;
		if (this.numeracao != other.numeracao)
			return false;
		
		return true;
	}

	/**
	 * Retorna a String que representa o Cenario. A representação segue o formato "NUMERAÇÃO - DES
	 * CRIÇÃO DO CENARIO - ESTADO ATUAL DO CENARIO".
	 * 
	 * @returns A representação, em String, do Cenario.
	 * 
	 */
	@Override
	public String toString() {
		return this.getNumeracao() + " - " + this.getDescricao() + " - " + this.estado.toString();
	}

}
