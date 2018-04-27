package models;

/**
 * Representação da conta de um estudante de Ciência da Computação na UFCG em um laboratório do
 * curso. Cada conta de laboratório deve conter o nome do laboratório em que se está hospedando
 * a conta, a quantidade de espaço (em MB) que está sendo ocupado por essa conta e a quantidade
 * de espaço máxima (em MB) que o laboratório deseja disponibilizar para essa conta (chamada de
 * cota). 
 *
 * Laboratório de Programação 2 - Lab 02
 * @author Matheus Alves dos Santos - 117110503
 * 
 */
public class ContaLaboratorio {
	
	private String nomeLaboratorio;
	private int espacoOcupado;
	private int cota;
	
	/**
	 *  Constrói uma conta em laboratório a partir do nome do laboratório utilizado e de quanto
	 *  espaço máximo (em MB) essa conta deverá ocupar. Inicializa o espaço ocupado pela conta
	 *  em 0.
	 *  
	 *  @param nomeLaboratorio Nome do laboratório em que se está hospedando a conta.
	 *  @param cota Quantidade máxima de espaço (em MB) que essa conta deverá ocupar.
	 *  
	 */
	public ContaLaboratorio (String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.espacoOcupado = 0;
		this.cota = cota;
	}
	
	/**
	 *  Constrói uma conta em laboratório a partir do nome do laboratório utilizado. Inicializa
	 *  o espaço ocupado por essa conta como 0 e, por padrão dos laboratórios, inicia a cota da
	 *  conta em 2000MB.
	 *  
	 *  @param nomeLaboratorio Nome do laboratório em que se está hospedando a conta.
	 *  
	 */
	public ContaLaboratorio (String nomeLaboratorio) {
		this("nomeLaboratorio", 2000);
	}
	
	/**
	 *  Atualiza a quantidade de espaço ocupado pela conta de laboratório, acrescendo-a a partir
	 *  da quantidade de MBs informada como parâmetro. É importante ressaltar que não limita-se
	 *  o espaço ocupado, ainda que seja desejável não estourar a cota da conta.
	 *  
	 *  @param mbytes Quantidade de MB que passaram a ser ocupados.
	 *  
	 *  @returns null
	 *  
	 */
	public void consomeEspaco(int mbytes) {
		this.espacoOcupado += mbytes;
	}
	
	/**
	 *  Atualiza a quantidade de espaço ocupado pela conta de laboratório, decrescendo-a a partir
	 *  da quantidade de MBs informada como parâmetro. É importante ressaltar que não é possível
	 *  liberar mais espaço do que se está sendo ocupado pela conta.
	 *  
	 *  @param mbytes Quantidade de MB que deixaram de ser ocupados.
	 *  
	 *  @returns null
	 *  
	 */
	public void liberaEspaco(int mbytes) {
		this.espacoOcupado = Math.max(this.espacoOcupado - mbytes, 0);
	}
	
	/**
	 *  Determina se a conta está ocupando o máximo de espaço (em MB) que foi alocado para ela.
	 *  Caso o espaço ocupado seja igual (ou superior) à cota da conta, esse método irá retornar
	 *  true. caso contrário, retornará false. 
	 *  
	 *  @returns O boolean que indica se a cota foi estourada.
	 *  
	 */
	public boolean atingiuCota() {
		return (this.espacoOcupado >= this.cota);
	}

	/**
	 *  Retorna uma String que representa a conta de laboratório. A representação segue o padrão
	 *  "Nome do Laboratório (Espaço Ocupado)/(Cota da Conta)".
	 *  
	 *  @returns A representação em String de uma conta de laboratório.
	 *  
	 */
	@Override
	public String toString() {
		return this.nomeLaboratorio + " " + this.espacoOcupado + "/" + this.cota;
	}	
	
}
