package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		// Conta
		Conta c1 = new Conta(1, 123, 1, "Adriana", 1000.0f);
		c1.visualizar();
		c1.sacar(1200.f);
		c1.visualizar();
		c1.depositar(500.0f);
		c1.visualizar();

		// Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(2, 123, 1, "Mariana", 15000.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(1200.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();

		// Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Victor", 10000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1300.0f);
		cp1.visualizar();
		cp1.depositar(1200.0f);
		cp1.visualizar();
		Scanner sc = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND);

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
			System.out.println("             " + Cores.TEXT_RESET);
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    1 -  Criar Conta\n\n");
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    2 - Listar todas as Contas/n/n");
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    3 - Buscar Conta por Número/n/n ");
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    4 - Atualizar Dados da Conta/n/n ");
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    5 - Apagar Conta\n\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    6 - Sacar\n\n");
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    7 - Depositar\n\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    8 - Transferir Valores Entre Contas\n\n");
				break;
			case 9:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco Bea -- O Seu Futuro Começa Aqui!");
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
