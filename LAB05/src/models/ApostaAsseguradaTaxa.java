package models;

public class ApostaAsseguradaTaxa extends Aposta {

	private double taxaAssegurada;

	public ApostaAsseguradaTaxa(String apostador, int valor, String previsao, double taxaAssegurada) {
		super(apostador, valor, previsao);
		this.taxaAssegurada = taxaAssegurada;
	}
		
	public double getTaxaAssegurada() {
		return this.taxaAssegurada;
	}

	public void setTaxaAssegurada(double taxaAssegurada) {
		this.taxaAssegurada = taxaAssegurada;
	}

	@Override
	public String toString() {
		return super.toString() + " - ASSEGURADA (TAXA) - R$ " + (int) (this.taxaAssegurada * 100) + "%";
	}

}
