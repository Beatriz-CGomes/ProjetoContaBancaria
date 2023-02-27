package conta;

import java.io.IOException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner sc = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		System.out.println("\nCriar contas\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc1);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);

		contas.listarTodos();

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

				System.out.println("Digite o Numero da Agencia: ");
				agencia = sc.nextInt();

				System.out.println("Digite o nome do titular: ");
				sc.skip("\\R");
				titular = sc.nextLine();

				do {
					System.out.println("(Digiteo tipo da Conta (1-CC ou 2-CP: ");
					tipo = sc.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o saldo dsa conta (R$): ");
				saldo = sc.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito R$: ");
					limite = sc.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = sc.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    2 - Listar todas as Contas/n/n");
				contas.listarTodos();
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    3 - Buscar Conta por Número/n/n ");

				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();

				contas.procurarPorNumero(numero);
				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    4 - Atualizar Dados da Conta/n/n ");

				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();

				if (contas.buscarNaCollections(numero) != null) {

					System.out.println("Digite o número da agencia: ");
					agencia = sc.nextInt();
					System.out.println("Digite o nome do titular: ");
					sc.skip("\\R?");
					titular = sc.nextLine();

					System.out.println("Digite o saldo da conta R$: ");
					saldo = sc.nextFloat();

					tipo = contas.retornaTipo(numero);

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite de Crédito R$: ");
						limite = sc.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversario da Conta: ");
						aniversario = sc.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta não encontrada");
					}
					}
				} else {
					System.out.println("\nConta não encontrada!");
				}
				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    5 - Apagar Conta\n\n");

				System.out.println("Digite o numero da conta: ");
				numero = sc.nextInt();

				contas.deletar(numero);
				keyPress();
				break;

			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    6 - Sacar\n\n");

				System.out.println("Digite o numero da conta: ");
				numero = sc.nextInt();

				do {
					System.out.println("\nDigite o saque do saque R$");
					valor = sc.nextFloat();

				} while (valor <= 0);

				contas.sacar(numero, valor);

				keyPress();
				break;

			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    7 - Depositar\n\n");

				System.out.println("Digite o numero da conta");
				numero = sc.nextInt();

				do {
					System.out.println("Digite o valor do depósito R$");
					valor = sc.nextFloat();
				} while (valor <= 0);

				contas.depositar(numero, valor);

				keyPress();
				break;

			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    8 - Transferir Valores Entre Contas\n\n");

				System.out.println("Digite o numero da Conta de Origem");
				numero = sc.nextInt();
				System.out.println("Digite o numero da Conta de Destino");
				numeroDestino = sc.nextInt();

				do {
					System.out.println("Digite o valor da Transferencia R$: ");
					valor = sc.nextFloat();
				} while (valor <= 0);

				contas.transferir(numero, numeroDestino, valor);
				keyPress();
				break;

			case 9:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco Bea -- O Seu Futuro Começa Aqui!");
				sc.close();
				System.exit(0);
				break;

			default:
				System.out.println("Opção Invalida!");
				keyPress();
				break;

			} // fim switch

		} // fim while
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione o Enter para Continuar .. ");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

} // fim
