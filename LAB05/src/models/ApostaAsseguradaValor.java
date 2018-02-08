package models;

import java.text.DecimalFormat;

public class ApostaAsseguradaValor extends Aposta {
	
	private int valorAssegurado;

	public ApostaAsseguradaValor(String apostador, int valor, String previsao, int valorAssegurado) {
		super(apostador, valor, previsao);
		this.valorAssegurado = valorAssegurado;
	}

	public int getValorAssegurado() {
		return this.valorAssegurado;
	}

	public void setValorAssegurado(int valorAssegurado) {
		this.valorAssegurado = valorAssegurado;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		
		return super.toString() + " - ASSEGURADA (VALOR) - R$ " + (df.format(this.getValor() / 100.0));
	}

}
