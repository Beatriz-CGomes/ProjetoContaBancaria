package conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int opcao;

		while (true) {
			System.out.println("----------------------------");
			System.out.println("");
			System.out.println("         BANCO DA BEA        ");
			System.out.println("");
			System.out.println("----------------------------");
			System.out.println("    1 - Criar Conta");
			System.out.println("    2 - Listar todas as Contas");
			System.out.println("    3 - Buscar Conta por Número ");
			System.out.println("    4 - Atualizar Dados da conta");
			System.out.println("    5 - Apagar Conta");
			System.out.println("    6 - Sacar");
			System.out.println("    7 - Depositar");
			System.out.println("    8 - Transferir Valores Entre Contas");
			System.out.println("    9 - Sair ");
			System.out.println("");
			System.out.println("----------------------------");
			System.out.println("\tEntre com a opção desejada: ");
			System.out.println();
			System.out.println("            ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("    1 -  Criar Conta\n\n");
				break;

			case 2:
				System.out.println("    2 - Listar todas as Contas/n/n");
				break;
			case 3:
				System.out.println("    3 - Buscar Conta por Número/n/n ");
				break;
			case 4:
				System.out.println("    4 - Atualizar Dados da Conta/n/n ");
				break;
			case 5:
				System.out.println("    5 - Apagar Conta\n\n");
				break;
			case 6:
				System.out.println("    6 - Sacar\n\n");
				break;
			case 7:
				System.out.println("    7 - Depositar\n\n");
				break;
			case 8:
				System.out.println("    8 - Transferir Valores Entre Contas\n\n");
				break;
			case 9:
				System.out.println("\nBanco Bea -- O Seu Futuro Começa Aqui!");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Opção Invalida!");
				break;

			} // fim switch 

		} // fim while
	} // fim
}
