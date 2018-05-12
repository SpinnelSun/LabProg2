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

}
