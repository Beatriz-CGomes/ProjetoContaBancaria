package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repositor.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listasContas = new ArrayList<Conta>();

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollections(numero);

		if (conta != null)
			conta.visualizar();
		else
			System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
	}

	@Override
	public void listarTodos() {
		for (var conta : listasContas) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listasContas.add(conta);
		System.out.println("\nA Conta número: " + conta.getNumero() + " foi criada com sucesso");

	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollections(conta.getNumero());

		if (buscaConta != null) {
			listasContas.set(listasContas.indexOf(buscaConta), conta);
			System.out.println("\nA Conta número: " + conta.getNumero() + " foi criado com sucesso");
		} else {
			System.out.println("\nA Conta número: " + conta.getNumero() + " não foi encontrada! ");
		}

	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollections(numero);

		if (conta != null) {
			if (listasContas.remove(conta) == true)
				System.out.println("\nA Conta numero: " + numero + " foi deletada com sucesso");
		} else {
			System.out.println("\nA conta numero " + numero + " não foi encontrada! ");
		}
	}

	@Override
	public void sacar(int numero, float valor) {
		var buscaConta = buscarNaCollections(numero);

		if (buscaConta != null) {

			if (listasContas.get(listasContas.indexOf(buscaConta)).sacar(valor) == true)
				System.out.println("\nO Saque na Conta numero " + numero + " foi efetuado com sucesso");
		} else
			System.out.println("\nA Conta numero " + numero + " não foi encontrada!");

	}

	@Override
	public void depositar(int numero, float valor) {
		var buscaConta = buscarNaCollections(numero);

		if (buscaConta != null) {
			var indiceConta = listasContas.indexOf(buscaConta);
			listasContas.get(indiceConta).depositar(valor);
			System.out.println("\nO Depósito na Conta numero " + numero + " foi efetuado com sucesso!");
		} else
			System.out.println("\nA Conta numero " + numero + " não foi encontrada! ");
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var buscaContaOrigem = buscarNaCollections(numeroOrigem);
		var buscaContaDestino = buscarNaCollections(numeroDestino);

		if (buscaContaOrigem != null && buscaContaDestino != null) {

			if (listasContas.get(listasContas.indexOf(buscaContaOrigem)).sacar(valor) == true) {
				listasContas.get(listasContas.indexOf(buscaContaDestino)).depositar(valor);
				System.out.println("\nA Transferencia foi efetuada com sucesso!!");
			}
		}
	}

	public int gerarNumero() {
		return listasContas.size() + 1;
	}

	public Conta buscarNaCollections(int numero) {
		for (var conta : listasContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}

		return null;
	}

	public int retornaTipo(int numero) {
		for (var conta : listasContas) {
			if (conta.getNumero() == numero) {
				return conta.getTipo();
			}
		}
		return 0;
	}
}
