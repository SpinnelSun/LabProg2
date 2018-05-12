package main;

import java.util.NoSuchElementException;
import java.util.Scanner;

import controllers.Controle;
import utility.Validador;

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
		
		Validador.validarStringNaoVazia("Você forneceu uma informação vazia!", matricula);
		Validador.validarStringNaoVazia("Você forneceu uma informação vazia!", nome);
		Validador.validarStringNaoVazia("Você forneceu uma informação vazia!", curso);
		
		try {
			controle.cadastrarAluno(matricula, nome, curso);
			System.out.println("CADASTRO REALIZADO!");
		}
		
		catch (RuntimeException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public static void exibirAluno(Controle controle, Scanner scan) {
		System.out.print(System.lineSeparator());
		
		System.out.print("Matrícula: ");
		String matricula = scan.nextLine();
		
		Validador.validarStringNaoVazia("Você forneceu uma informação vazia!", matricula);
		
		try {
			System.out.print(System.lineSeparator());
			System.out.println("Aluno: " + controle.consultarAluno(matricula));
		}
		
		catch (RuntimeException exception) {
			System.out.println(exception.getMessage());
		}		
		
	}

	public static void novoGrupo(Controle controle, Scanner scan) {
		System.out.print(System.lineSeparator());
		
		System.out.print("Grupo: ");
		String grupo = scan.nextLine();
		
		Validador.validarStringNaoVazia("Você forneceu uma informação vazia!", grupo);
		
		try {
			controle.cadastrarGrupo(grupo);
			System.out.println("CADASTRO REALIZADO!");
		}
		
		catch (RuntimeException exception) {
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
		
		Validador.validarStringNaoVazia("Você forneceu uma informação vazia!", matricula);
		Validador.validarStringNaoVazia("Você forneceu uma informação vazia!", grupo);
				
		try {
			controle.alocarAluno(matricula, grupo);
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
		
		Validador.validarStringNaoVazia("Você forneceu uma informação vazia!", grupo);
		
		try {
			System.out.println(controle.imprimirGrupo(grupo));
		}
		
		catch (RuntimeException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public static void registrarResposta(Controle controle, Scanner scan) {
		System.out.print(System.lineSeparator());
		System.out.print("Matrícula: ");
		String matricula = scan.nextLine();
		
		Validador.validarStringNaoVazia("Você forneceu uma informação vazia!", matricula);
		
		try {
			System.out.print(System.lineSeparator());
			controle.cadastrarRespondente(matricula);
			System.out.println("ALUNO REGISTRADO!");
		}
		
		catch (RuntimeException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public static void imprimirRespondentes(Controle controle, Scanner scan) {
		System.out.print(System.lineSeparator());
		System.out.print("Alunos:" + System.lineSeparator());
		System.out.println(controle.respondentesToString());
	}
	
}