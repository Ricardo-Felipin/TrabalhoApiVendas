package br.unipar.programacaoweb.apivenda.repository;

import br.unipar.programacaoweb.apivenda.model.Produto;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

import java.util.List;

@Stateless

public class ProdutoRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;
    private UserTransaction utx;

    public void cadastrarProduto(Produto produto) throws Exception {
        try {
            em.persist(produto);
        } catch (Exception ex) {
            throw new Exception("Estante não pode ser cadastrado");
        }
    }

    public List<Produto> getProdutos() {
        String jpql = "SELECT l FROM Produto l";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public void updateProduto(Produto produto) {
        try {
            Produto produtoAtualizado = em.find(Produto.class, produto.getId());
            if (produtoAtualizado != null) {
                produtoAtualizado.setDescricao(produto.getDescricao());
                produtoAtualizado.setValor_unitario(produto.getValor_unitario());
                em.merge(produtoAtualizado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduto(Integer id) {
        try {
            Produto produto = em.find(Produto.class, id);
            if (produto != null) {
                em.remove(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
