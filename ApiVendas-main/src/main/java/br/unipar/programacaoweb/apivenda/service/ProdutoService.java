package br.unipar.programacaoweb.apivenda.service;


import br.unipar.programacaoweb.apivenda.model.Produto;
import br.unipar.programacaoweb.apivenda.repository.ProdutoRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless

public class ProdutoService {

    @Inject
    private ProdutoRepository produtoRepository;

    public void cadastrarProduto(Produto produto) throws Exception {
        produtoRepository.cadastrarProduto(produto);
    }

    public List<Produto> getProduto() {
        return produtoRepository.getProdutos();
    }

    public void updateProduto(Produto produto) throws Exception{
        produtoRepository.updateProduto(produto);
    }

    public void deleteProduto(Integer id){
        produtoRepository.deleteProduto(id);
    }

}
