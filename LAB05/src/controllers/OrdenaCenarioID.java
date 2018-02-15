package controllers;

import java.util.Comparator;

import models.Cenario;

public class OrdenaCenarioID implements Comparator<Cenario> {

	@Override
	public int compare(Cenario c1, Cenario c2) {
		return c1.getNumeracao() - c2.getNumeracao();
	}

}
