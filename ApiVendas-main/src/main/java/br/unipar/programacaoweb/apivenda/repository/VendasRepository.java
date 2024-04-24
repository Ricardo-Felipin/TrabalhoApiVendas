package br.unipar.programacaoweb.apivenda.repository;

import br.unipar.programacaoweb.apivenda.model.Vendas;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

import java.util.List;

@Stateless

public class VendasRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;
    private UserTransaction utx;

    public void cadastrarVendas(Vendas vendas) throws Exception {
        try {
            em.persist(vendas);
        } catch (Exception ex) {
            throw new Exception("Cadastro incorreto");
        }
    }

    public List<Vendas> getVendas() {
        String jpql = "SELECT l FROM Vendas l";
        return em.createQuery(jpql, Vendas.class).getResultList();
    }

    public void updateVendas(Vendas vendas) {
        try {
            Vendas vendasAtualizado = em.find(Vendas.class, vendas.getId());
            if (vendasAtualizado != null) {
                vendasAtualizado.setObservacoes(vendas.getObservacoes());
                vendasAtualizado.setTotal(vendas.getTotal());
                em.merge(vendasAtualizado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteVendas(Integer id) {
        try {
            Vendas vendas = em.find(Vendas.class, id);
            if (vendas != null) {
                em.remove(vendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
