package models;

/**
 * Representação dos débitos em lanchonetes (e estabelecimentos semelhantes) possuídos por um
 * estudante universitário. Cada débito em lanchonete deve conter o nome do estabelecimento,
 * a quantidade de itens já consumidos ali, o valor do débito atual e os detalhes dos últimos
 * 5 lanches consumidos na lanchonete. Há um atributo "controlaDetalhes" utilizado apenas na
 * distribuição e armazenamento dos detalhes.
 *
 * Laboratório de Programação 2 - Lab 02
 * @author Matheus Alves dos Santos - 117110503
 * 
 */
public class ContaCantina {
	
	private String nomeCantina;
	private int itensConsumidos;
	private int debitoConta;
	private String[] ultimosDetalhes;
	private int controleDetalhes;
	
	/**
	 *  Constrói um débito em lanchonete a partir do nome do estabelecimento. Inicia o número de
	 *  itens consumidos, o débito atual e o atributo de controle em 0, além de instanciar todos
	 *  os detalhes armazenados como Strings vazias.
	 *
	 *  @param nomeCantina Nome do estabelicimento em que o débito foi criado.
	 *  
	 */
	public ContaCantina(String nomeCantina) {
		this.nomeCantina = nomeCantina;
		this.itensConsumidos = 0;
		this.debitoConta = 0;
		this.ultimosDetalhes = new String[] {"", "", "", "", ""};
		this.controleDetalhes = 0;
	}
	
	/**
	 *  Atualiza o débito no estabelecimento a partir de informações de um lanche consumido ali.
	 *  A quantidade de itens consumidos no estabelecimento e o débito total serão acrescidos de
	 *  acordo com o que foi consumido nesse novo lanche. Além disso, é armazenada uma descrição
	 *  desse lanche. A posição do Array em que essa descrição é armazenada é controlada por um
	 *  atributo auxiliar que também é atualizado após o armazenamento.
	 *  
	 *  @param qtdItens Quantidade de itens consumidos nesse novo lanche.
	 *  @param valorCentavos Custo, em centavos, do novo lanche.
	 *  @param detalhes Descrição do que foi consumido.
	 *  
	 *  @returns null
	 *  
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos, String detalhes) {
		this.itensConsumidos += qtdItens;
		this.debitoConta += valorCentavos;
		this.ultimosDetalhes[controleDetalhes] = detalhes;
		this.controleDetalhes++;
		
		if (this.controleDetalhes == 5) {
			this.controleDetalhes = 0;
		}
	}
	
	/**
	 *  Atualiza o débito no estabelecimento a partir de informações de um lanche consumido ali.
	 *  A quantidade de itens consumidos no estabelecimento e o débito total serão acrescidos de
	 *  acordo com o que foi consumido nesse novo lanche.
	 *  
	 *  @param qtdItens Quantidade de itens consumidos no novo lanche.
	 *  @param valorCentavos Custo, em centavos, do novo lanche.
	 *  
	 *  @returns null
	 *  
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.cadastraLanche(qtdItens, valorCentavos, "");
	}
	
	/**
	 *  Atualiza o débito no estabelecimento a partir de um pagamento realizado pelo estudante.
	 *  O débito total será decrescido de acordo com a quantia paga ao estabelecimento. Esse
	 *  pagamento é limitado pelo total devido ao estabelecimento.
	 *  
	 *  @param valorCentavos Valor, em centavos, que foi pago.
	 *  
	 *  @returns null
	 *  
	 */
	public void pagaConta(int valorCentavos) {
		this.debitoConta = Math.max(this.debitoConta -= valorCentavos, 0);
	}
	
	/**
	 *  Retorna uma String que representa as cinco últimas descrições de lanches armazenadas. O
	 *  padrão utilizado insere um divisor de formato " / " entre as descrições.
	 *  
	 *  @returns A representação em String do que foram os últimos cinco lanches.
	 *  
	 */
	public String listarDetalhes() {
		return this.ultimosDetalhes[0] + " / " + this.ultimosDetalhes[1] + " / " + this.ultimosDetalhes[2]
				+ " / " + this.ultimosDetalhes[3] + " / " + this.ultimosDetalhes[4]; 
	}
	
	/**
	 *  Retorna uma String que representa o débito no estabelecimento. A representação segue o
	 *  formato "Nome do Estabelecimento - Total de Itens Consumidos - Débito Atual".
	 *  
	 *  @returns A representação em String de um débito em estabelecimento.
	 *   
	 */
	@Override
	public String toString() {
		return this.nomeCantina + " " + this.itensConsumidos + " " + this.debitoConta;
	}
	
}

