package com.pedro.buscacep.management;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.pedro.buscacep.exceptions.CepException;
import com.pedro.buscacep.model.Cep;
import com.pedro.buscacep.model.History;
import com.pedro.buscacep.services.CepService;
import com.pedro.buscacep.util.HistoryWriter;

public class Menu {

	private static HistoryWriter util = new HistoryWriter();
	private static CepService service = new CepService();

	public static void show() throws IOException, InterruptedException {

		

		System.out.println("");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Selecione uma opção:");
		System.out.println("1. Buscar Cep");
		System.out.println("2. Listar Histórico");
		System.out.println("3. Sair");
		System.out.println("");

		int opcao = scanner.nextInt();

		switch (opcao) {
		case 1:
			searchCep(scanner);
			break;
		case 2:
			historyList();
			break;
		case 3:
			sair();
			break;
		default:
			erro();
			break;
		}

		scanner.close();
		util.close();
	}

	private static void erro() throws IOException, InterruptedException {

		System.out.println("Opção inválida. Tente novamente.");
		show();
	}

	private static void sair() throws IOException {

		System.out.println("Guardando historico...");
		System.out.println("Saindo...");
	}

	private static void searchCep(Scanner scn) throws IOException, InterruptedException {

		try {

			System.out.println("");
			System.out.println("Digite o cep desejado:");

			String codeCep = scn.next();
			Cep cep;
			cep = service.getCep(codeCep.replaceAll("[^\\d]", ""));

			util.addHistory(new History(LocalDateTime.now(), cep.getCepFormatado()));
			System.out.println(cep.info());

		} catch (CepException e) {
			System.out.println(e.getMessage());
		} finally {
			show();
		}

	}

	private static void historyList() throws IOException, InterruptedException {

		System.out.println("Histórico Buscas.");
		System.out.println("");
		util.listHistory();

		show();
	}

}
