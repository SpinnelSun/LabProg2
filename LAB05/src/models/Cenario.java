package models;

public class Cenario {
	
	private int numeracao;
	private String descricao;
	private boolean finalizacao;
	private boolean ocorrencia;
	
	public Cenario(int numeracao, String descricao) {
		Validador.validarNotEmpty("Erro no cadastro de cenario: Descricao nao pode ser vazia", descricao);
		Validador.validarNotNull("Descrição de cenário nula!", descricao);
		
		this.numeracao = numeracao;
		this.descricao = descricao;
		this.finalizacao = false;
		this.ocorrencia = false;
	}
	
	public int getNumeracao() {
		return this.numeracao;
	}


	public String getDescricao() {
		return this.descricao;
	}

	public boolean getFinalizacao() {
		return this.finalizacao;
	}


	public void setFinalizacao(boolean finalizacao) {
		this.finalizacao = finalizacao;
	}


	public boolean getOcorrencia() {
		return this.ocorrencia;
	}


	public void setOcorrencia(boolean ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	
	private String descreveEstadoOcorrencia() {
		if (!this.finalizacao) {
			return "Nao finalizado";
		}
		
		if (this.ocorrencia) {
			return "finalizado (ocorreu)";
		}
		
		return "Finalizado (n ocorreu)";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.numeracao;
		return result;
	}

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

	@Override
	public String toString() {
		return this.getNumeracao() + " - " + this.getDescricao() + " - " + this.descreveEstadoOcorrencia();
	}

}
