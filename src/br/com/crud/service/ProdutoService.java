package br.com.crud.service;

import br.com.crud.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();
    private int contadorId = 1;

    // CREATE
    public void criarProduto(String nome, double preco, int estoque) {
        Produto produto = new Produto(contadorId++, nome, preco, estoque);
        produtos.add(produto);
        System.out.println("Produto cadastrado com estoque!");
    }

    // READ
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println(
                    "ID: " + p.getId() +
                            " | Nome: " + p.getNome() +
                            " | Preço: " + p.getPreco() +
                            " | Estoque: " + p.getEstoque()
            );
        }
    }

    // Buscar produto
    public Produto buscarPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Validar e baixar estoque
    public boolean baixarEstoque(int id, int quantidade) {
        Produto produto = buscarPorId(id);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return false;
        }

        if (produto.getEstoque() < quantidade) {
            System.out.println("Estoque insuficiente.");
            return false;
        }

        produto.baixarEstoque(quantidade);
        return true;
    }
}
