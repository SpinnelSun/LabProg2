package models;

public class Aposta {
	
	private String apostador;
	private int valor;
	private boolean previsao;
	
	public Aposta(String apostador, int valor, boolean previsao) {
		Validador.validarNotEmpty("Nome do apostador vazio!", apostador);
		Validador.validarNotNull("Nome do apostador nulo!", apostador);
		Validador.validarPositiveInteger("Valor apostado inválido!", valor);
				
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
		return (this.previsao) ? "VAI ACONTECER" : "N VAI ACONTECER";
	}

	@Override
	public String toString() {
		return this.getApostador() + " - R$" + this.getValor() + "- " + this.descrevePrevisao();
	} 	

}

