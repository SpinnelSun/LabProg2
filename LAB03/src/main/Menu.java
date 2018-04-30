package lab3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Menu utilizado no gerenciamento da Agenda de Contatos.
 * 
 * Laboratório de Programação 2 - Lab 03
 * @author Matheus Alves dos Santos - 117110503
 */

public class Menu {
	
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		while (true) {
			exibirMenu(agenda);
		}
	}

	public static void exibirMenu(Agenda agenda) {
		Scanner scan = new Scanner(System.in);
		String op;

		System.out.println("(C)adastrar Contato");
		System.out.println("(L)istar Contatos");
		System.out.println("(E)xibir Contato");
		System.out.println("(S)air\n");
		System.out.print("Opção > ");
		
		op = scan.nextLine();

		switch (op.toUpperCase()) {
			case "C":
				cadastrarContatos(agenda, scan);
				break;
				
			case "L":
				listarContatos(agenda);
				break;
				
			case "E":
				exibirContato(agenda, scan);
				break;
		
			case "S":
				System.exit(0);
				break;
				
			default:
				System.out.println("OPÇÃO INVÁLIDA!");
				break;
		}

		System.out.println("");
	}
	
	public static void cadastrarContatos(Agenda agenda, Scanner scan) {
		System.out.print("Posição: ");
		int posicao = scan.nextInt();
		scan.nextLine();
		
		if (agenda.validarPosicao(posicao)) {
	
			System.out.print("Nome: ");
			String nome = scan.nextLine();
	
			System.out.print("Sobrenome: ");
			String sobrenome = scan.nextLine();
	
			System.out.print("Telefone: ");
			String telefone = scan.nextLine();
		
			agenda.novoCadastro(posicao, nome, sobrenome, telefone);
		} else {
			System.out.println("\nPOSIÇÃO INVÁLIDA!");
		}
	}
	
	public static void listarContatos(Agenda agenda) {
		ArrayList<String> listaContatos = agenda.listagemContatos();
		
		for (String contato : listaContatos) {
			System.out.println(contato);
		}
	}

	public static void exibirContato(Agenda agenda, Scanner scan) {
		System.out.print("Contato > ");
		int posicao = scan.nextInt();
		System.out.println("");
		scan.nextLine();
		
		if (agenda.validarPosicao(posicao) && agenda.validarContato(posicao)) {
				System.out.println(agenda.exibicaoContato(posicao));
		} else {
			System.out.println("POSIÇÃO INVÁLIDA!");
		}
	}
	
}