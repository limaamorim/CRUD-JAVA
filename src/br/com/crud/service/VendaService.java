package br.com.crud.service;

import br.com.crud.model.Produto;
import br.com.crud.model.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaService {

    private List<Venda> vendas = new ArrayList<>();
    private int contadorId = 1;
    private ProdutoService produtoService;

    public VendaService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public void realizarVenda(int produtoId, int quantidade) {

        Produto produto = produtoService.buscarPorId(produtoId);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        boolean estoqueBaixado =
                produtoService.baixarEstoque(produtoId, quantidade);

        if (!estoqueBaixado) {
            return;
        }

        Venda venda = new Venda(contadorId++, produto, quantidade);
        vendas.add(venda);

        System.out.println("Venda realizada!");
        System.out.println("Total: R$ " + venda.getTotal());
    }

    public void listarVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda realizada.");
            return;
        }

        for (Venda v : vendas) {
            System.out.println(
                    "Venda ID: " + v.getId() +
                            " | Produto: " + v.getProduto().getNome() +
                            " | Quantidade: " + v.getQuantidade() +
                            " | Total: R$ " + v.getTotal()
            );
        }
    }
}
