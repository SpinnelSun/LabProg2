package utility;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidadorTest {

	@Test(expected = IllegalArgumentException.class)
	public void testValidarStringNaoVaziaComVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar validar uma String vazia nesse metodo.";
		Validador.validarStringNaoVazia("Excecao lancada!", "");
	}

	@Test(expected = NullPointerException.class)
	public void testValidarStringNaoNulaComNull() {
		String msg = "Avaliacao da excecao lancada ao tentar validar um null nesse metodo.";
		Validador.validarStringNaoNula("Excecao lancada!", null);
	}

	public void testValidarIntUmACincoComZero() {
		String msg = "Avaliacao do resultado ao tentar validar um zero nesse metodo.";
		assertFalse(msg, Validador.validarIntUmACem(0));
	}
	
	public void testValidarIntUmACemComMaior() {
		String msg = "Avaliacao do resultado ao tentar validar um número maior que 100 nesse metodo.";
		assertFalse(msg, Validador.validarIntUmACem(101));
	}
	
	public void testValidarIntUmACemComNegativo() {
		String msg = "Avaliacao do resultado ao tentar validar um número negativo nesse metodo.";
		assertFalse(msg, Validador.validarIntUmACem(-1));
	}

}
