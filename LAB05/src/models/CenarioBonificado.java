package models;

public class CenarioBonificado extends Cenario {
	
	private int bonus;

	public CenarioBonificado(int numeracao, String descricao, int bonus) {
		super(numeracao, descricao);
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - R$ " + this.bonus;
	}
	
}
