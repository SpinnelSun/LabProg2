package main;

import java.util.NoSuchElementException;
import java.util.Scanner;

import classroom.Controle;
import classroom.Validador;

/**
 * Menu utilizado no gerenciamento do Controle de Alunos.
 * 
 * Laboratório de Programação 2 - Lab 04
 * @author Matheus Alves dos Santos - 117110503
 * 
 */

public class Menu {
	
	public static void main(String[] args) {
		Controle controle = new Controle();
		while (true) {
			exibirMenu(controle);
		}
	}

	public static void exibirMenu(Controle controle) {
		Scanner scan = new Scanner(System.in);

		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Resposta de Aluno");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!");
		System.out.print(System.lineSeparator());
		System.out.print("Opção > ");
		
		String op = scan.nextLine().trim();

		switch (op.toUpperCase()) {
			case "C":
				cadastrarAluno(controle, scan);
				break;
				
			case "E":
				exibirAluno(controle, scan);
				break;
				
			case "N":
				novoGrupo(controle, scan);
				break;
				
			case "A":
				alocarOuImprimir(controle, scan);
				break;
				
			case "R":
				registrarResposta(controle, scan);
				break;
				
			case "I":
				imprimirRespondentes(controle, scan);
				break;
		
			case "O":
				System.exit(0);
				break;
				
			default:
				System.out.print(System.lineSeparator());
				System.out.println("OPÇÃO INVÁLIDA!");
				break;
		}

		System.out.print(System.lineSeparator());
	}
	
	public static void cadastrarAluno(Controle controle, Scanner scan) {
		System.out.print(System.lineSeparator());
		System.out.print("Matrícula: ");
		String matricula = scan.nextLine();

		System.out.print("Nome: ");
		String nome = scan.nextLine();

		System.out.print("Curso: ");
		String curso = scan.nextLine();
		
		Validador.validarNotEmpty("Você forneceu uma informação vazia!", matricula);
		Validador.validarNotEmpty("Você forneceu uma informação vazia!", nome);
		Validador.validarNotEmpty("Você forneceu uma informação vazia!", curso);
		
		Validador.validarNotNull("Você forneceu uma informação nula!", matricula);
		Validador.validarNotNull("Você forneceu uma informação nula!", nome);
		Validador.validarNotNull("Você forneceu uma informação nula!", curso);
		
		try {
			controle.cadastroAluno(matricula, nome, curso);
			System.out.println("CADASTRO REALIZADO!");
		}
		
		catch (UnsupportedOperationException | IllegalArgumentException | NullPointerException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public static void exibirAluno(Controle controle, Scanner scan) {
		System.out.print(System.lineSeparator());
		
		System.out.print("Matrícula: ");
		String matricula = scan.nextLine();
		
		Validador.validarNotEmpty("Você forneceu uma informação vazia!", matricula);
		Validador.validarNotNull("Você forneceu uma informação nula!", matricula);
		
		try {
			System.out.print(System.lineSeparator());
			System.out.println("Aluno: " + controle.consultaAluno(matricula));
		}
		
		catch (NoSuchElementException | IllegalArgumentException | NullPointerException exception) {
			System.out.println(exception.getMessage());
		}		
		
	}

	public static void novoGrupo(Controle controle, Scanner scan) {
		System.out.print(System.lineSeparator());
		
		System.out.print("Grupo: ");
		String grupo = scan.nextLine();
		
		Validador.validarNotEmpty("Você forneceu uma informação vazia!", grupo);
		Validador.validarNotNull("Você forneceu uma informação nula!", grupo);
		
		try {
			controle.cadastroGrupo(grupo);
			System.out.println("CADASTRO REALIZADO!");
		}
		
		catch (UnsupportedOperationException | IllegalArgumentException | NullPointerException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public static void alocarOuImprimir(Controle controle, Scanner scan) {
		System.out.print(System.lineSeparator());
		System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
		String op = scan.nextLine();
		
		switch (op.toUpperCase()) {
			case "A":
				alocarAluno(controle, scan);
				break;
				
			case "I":
				imprimirGrupo(controle, scan);
				break;
				
			default:
				System.out.print(System.lineSeparator());
				System.out.println("OPÇÃO INVÁLIDA!");
				break;
		}
		
	}
	
	public static void alocarAluno(Controle controle, Scanner scan) {
		System.out.print(System.lineSeparator());
		System.out.print("Matrícula: ");
		String matricula = scan.nextLine();
		
		System.out.print("Grupo: ");
		String grupo = scan.nextLine();
		
		Validador.validarNotEmpty("Você forneceu uma informação vazia!", matricula);
		Validador.validarNotEmpty("Você forneceu uma informação vazia!", grupo);
		
		Validador.validarNotNull("Você forneceu uma informação nula!", matricula);
		Validador.validarNotNull("Você forneceu uma informação nula!", grupo);
		
		try {
			controle.alocaAluno(matricula, grupo);
			System.out.println("ALUNO ALOCADO!");
		}
		
		catch (NoSuchElementException | IllegalArgumentException | NullPointerException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public static void imprimirGrupo(Controle controle, Scanner scan) {
		System.out.print(System.lineSeparator());
		
		System.out.print("Grupo: ");
		String grupo = scan.nextLine();
		
		System.out.print(System.lineSeparator());
		
		Validador.validarNotEmpty("Você forneceu uma informação vazia!", grupo);
		Validador.validarNotNull("Você forneceu uma informação nula!", grupo);
		
		try {
			System.out.println(controle.imprimeGrupo(grupo));
		}
		
		catch (NoSuchElementException | IllegalArgumentException | NullPointerException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public static void registrarResposta(Controle controle, Scanner scan) {
		System.out.print(System.lineSeparator());
		System.out.print("Matrícula: ");
		String matricula = scan.nextLine();
		
		Validador.validarNotEmpty("Você forneceu uma informação vazia!", matricula);
		Validador.validarNotNull("Você forneceu uma informação nula!", matricula);
		
		try {
			System.out.print(System.lineSeparator());
			controle.cadastroRespondente(matricula);
			System.out.println("ALUNO REGISTRADO!");
		}
		
		catch (NoSuchElementException | IllegalArgumentException | NullPointerException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public static void imprimirRespondentes(Controle controle, Scanner scan) {
		System.out.print(System.lineSeparator());
		System.out.print("Alunos:" + System.lineSeparator());
		System.out.println(controle.respondentesToString());
	}
	
}