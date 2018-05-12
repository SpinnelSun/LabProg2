package classroom;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class ValidadorTest {

	@Test(expected = NullPointerException.class)
	public void testValidarNotNull() {
		String msg = "Verificação da exceção lançada devido à validação de informação nula.";
		Validador.validarNotNull(msg, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidarNotEmpty() {
		String msg = "Verificação da exceção lançada devido à validação de informação vazia.";
		Validador.validarNotEmpty(msg, "    ");
	}

}
