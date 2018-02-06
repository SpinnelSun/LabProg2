package models;

import java.text.DecimalFormat;

public class CenarioBonificado extends Cenario {
	
	private int bonus;

	public CenarioBonificado(int numeracao, String descricao, int bonus) {
		super(numeracao, descricao);
		this.bonus = bonus;
	}
	
	public int getBonus() {
		return this.bonus;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		
		return super.toString() + " - R$ " + (df.format(this.getBonus() / 100.0));
	}
	
}
