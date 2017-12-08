package models;

public class Aposta {
	
	private String apostador;
	private int valor;
	private boolean previsao;
	
	public Aposta(String apostador, int valor, boolean previsao) {
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
	}
	
	public String getApostador() {
		return this.apostador;
	}
	
	public boolean getPrevisao() {
		return this.previsao;
	}

	public int getValor() {
		return this.valor;
	}
	
	private String descrevePrevisao() {
		if (this.previsao) {
			return "VAI ACONTECER";
		}
		
		return "NÃO VAI ACONTECER";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apostador == null) ? 0 : apostador.hashCode());
		result = prime * result + (previsao ? 1231 : 1237);
		result = prime * result + valor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		return false;
	}

	@Override
	public String toString() {
		return this.getApostador() + " - R$" + this.getValor() + "- " + this.descrevePrevisao();
	} 	

}

