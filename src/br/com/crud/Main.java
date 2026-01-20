package br.com.crud;

import br.com.crud.service.ProdutoService;
import br.com.crud.service.VendaService;

import java.util.Scanner;

//BOOTCAMP
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProdutoService produtoService = new ProdutoService();
        VendaService vendaService = new VendaService(produtoService);

        int opcao;

        do {
            System.out.println("""
                    
                    ===== SISTEMA DE VENDAS =====
                    1 - Cadastrar produto
                    2 - Listar produtos
                    3 - Realizar venda
                    4 - Listar vendas
                    0 - Sair
                    """);

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            switch (opcao) {

                case 1 -> {
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Preço do produto: ");
                    double preco = scanner.nextDouble();

                    System.out.print("Estoque inicial: ");
                    int estoque = scanner.nextInt();

                    produtoService.criarProduto(nome, preco, estoque);
                }

                case 2 -> produtoService.listarProdutos();

                case 3 -> {
                    System.out.print("ID do produto: ");
                    int idProduto = scanner.nextInt();

                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    vendaService.realizarVenda(idProduto, quantidade);
                }

                case 4 -> vendaService.listarVendas();

                case 0 -> System.out.println("Encerrando o sistema...");

                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
