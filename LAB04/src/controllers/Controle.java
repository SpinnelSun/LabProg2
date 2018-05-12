/**
 * 
 */
package classroom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Representação de um sistema de controle de alunos. Um Controle possui três atributos: alunos, grupos e
 * respondentes. O atributo alunos mapeia os Alunos a partir dos valores de suas matrículas, o atributo grupos
 * mapeia os Grupos a partir dos valores de seus nomes em caixa alta e o atributo respondentes é uma lista
 * de Alunos que respondem questões em sala.
 * 
 * Laboratório de Programação 2 - Lab 04
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class Controle {
	
	private HashMap<String, Aluno> alunos;
	private HashMap<String, Grupo> grupos;
	private ArrayList<Aluno> respondentes;
	
	/**
	 * Constrói um Controle. Todos os atributos são iniciados como as coleções vazias adequadas. 
	 * 
	 */
	public Controle() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.respondentes = new ArrayList<>();
	}
	
	/**
	 * Avalia se um Aluno com determinada matrícula está registrado no Controle. Caso não esteja, será lançada uma
	 * exceção adequada.
	 * 
	 * @param matricula A matrícula a ser buscada dentre as registradas no Controle.
	 * 
	 * @returns null.
	 * 
	 */
	private void alunoCadastrado(String matricula) {
		if (!this.alunos.containsKey(matricula)) {
			throw new NoSuchElementException("ALUNO NÃO CADASTRADO!");
		}
	}
	
	/**
	 * Avalia se um Aluno com determinada matrícula não está registrado no Controle. Caso esteja, será lançada uma
	 * exceção adequada.
	 * 
	 * @param matricula A matrícula a ser buscada dentre as registradas no Controle.
	 * 
	 * @returns null.
	 * 
	 */
	private void alunoInexistente(String matricula) {
		if (this.alunos.containsKey(matricula)) {
			throw new UnsupportedOperationException("MATRÍCULA JÁ CADASTRADA!");
		}
	}
	
	/**
	 * Avalia se um Grupo com determinado nome está registrado no Controle. Caso não esteja, será lançada uma exceção
	 * adequada.
	 * 
	 * @param nome O nome do Grupo a ser buscado dentre os registradas no Controle.
	 * 
	 * @returns null.
	 * 
	 */
	private void grupoCadastrado(String nome) {
		if (!this.grupos.containsKey(nome.toUpperCase())) {
			throw new NoSuchElementException("GRUPO NÃO CADASTRADO!");
		}
	}
	
	/**
	 * Avalia se um Grupo com determinado nome não está registrado no Controle. Caso esteja, será lançada uma exceção
	 * adequada.
	 * 
	 * @param nome O nome do Grupo a ser buscado dentre os registradas no Controle.
	 * 
	 * @returns null.
	 * 
	 */
	private void grupoInexistente(String nome) {
		if (this.grupos.containsKey(nome.toUpperCase())) {
			throw new UnsupportedOperationException("GRUPO JÁ CADASTRADO!");
		}
	}
	
	/**
	 * A partir dos parâmetros do método, cria um Aluno e o mapeia no atributo alunos a partir do valor registrado
	 * como sua matrícula.
	 * 
	 * @param matricula A matrícula do aluno.
	 * @param nome O nome do aluno.
	 * @param curso O curso do aluno.
	 * 
	 * @returns null.
	 * 
	 */
	public void cadastroAluno(String matricula, String nome, String curso) {
		this.alunoInexistente(matricula);
		this.alunos.put(matricula, new Aluno(matricula, nome, curso));
	}
	
	/**
	 * A partir do parâmetro do método, retorna a representação textual do Aluno que está mapeado no atributo alunos
	 * a partir dessa matrícula.
	 * 
	 * @param matricula A matrícula do aluno.
	 * 
	 * @returns A representação textual do Aluno com a matrícula consultada.
	 * 
	 */
	public String consultaAluno(String matricula) {
		this.alunoCadastrado(matricula);
		return this.alunos.get(matricula).toString();
	}
	
	/**
	 * A partir do parâmetro do método, cria um Grupo e o mapeia no atributo grupos a partir do valor registrado
	 * como seu nome (em caixa alta).
	 * 
	 * @param nome O nome do grupo de alunos.
	 * 
	 * @returns null.
	 * 
	 */
	public void cadastroGrupo(String nome) {
		this.grupoInexistente(nome);
		this.grupos.put(nome.toUpperCase(), new Grupo(nome));
	}
	
	/**
	 * A partir dos parâmetros do método, aloca o Aluno com essa matrícula no Grupo com esse nome. Alocar um Aluno
	 * significa adicioná-lo ao conjunto de Alunos do Grupo.
	 * 
	 * @param matricula A matrícula do aluno a ser alocado.
	 * @param nome O nome do grupo que receberá o novo aluno.
	 * 
	 * @returns null.
	 * 
	 */
	public void alocaAluno(String matricula, String nome) {		
		this.alunoCadastrado(matricula);
		this.grupoCadastrado(nome);
		
		this.grupos.get(nome.toUpperCase()).alocaAluno(this.alunos.get(matricula));
	}
	
	/**
	 * Retorna a String que representa o Grupo cujonome é o parâmetro do método.
	 * 
	 * @returns A representação, em String, do Grupo.
	 * 
	 */
	public String imprimeGrupo(String nome) {
		this.grupoCadastrado(nome);
		return this.grupos.get(nome.toUpperCase()).toString();
	}
	
	/**
	 * A partir do parâmetro do método, adiciona um Aluno à lista de respondentes do Controle. Esse Aluno é aquele
	 * mapeado a partir da matrícula passada como parâmetro.
	 * 
	 * @param matricula A matrícula do aluno a ser adicionado como Respondente.
	 * 
	 * @returns null.
	 * 
	 */
	public void cadastroRespondente(String matricula) {
		this.alunoCadastrado(matricula);
		this.respondentes.add(this.alunos.get(matricula));
	}
	
	/**
	 * Retorna a listagem dos Alunos que responderam questões. A listagem segue a ordem de adição do aluno à lista e
	 * cada aluno será representado pela sua posição na lista e pelo seu próprio toString().
	 * 
	 * @returns A listagem dos Respondentes registrados no Controle.
	 * 
	 */
	public String respondentesToString() {
		String representacaoTextual = "";

		for (int i = 0; i < this.respondentes.size(); i++) {
			representacaoTextual += (i + 1) + ". " + this.respondentes.get(i).toString() + System.lineSeparator();
		}

		return representacaoTextual;
	}
	
}
