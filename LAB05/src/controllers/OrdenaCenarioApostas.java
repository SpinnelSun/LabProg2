package controllers;

import java.util.Comparator;

import models.Cenario;

public class OrdenaCenarioApostas implements Comparator<Cenario> {

	@Override
	public int compare(Cenario c1, Cenario c2) {
		return c1.totalDeApostas() - c2.totalDeApostas();
	}

}
