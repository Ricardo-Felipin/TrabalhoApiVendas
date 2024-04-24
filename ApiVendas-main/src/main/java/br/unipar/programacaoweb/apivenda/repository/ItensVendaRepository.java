package br.unipar.programacaoweb.apivenda.repository;

import br.unipar.programacaoweb.apivenda.model.ItensVenda;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

import java.util.List;

@Stateless

public class ItensVendaRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;
    private UserTransaction utx;

    public void cadastrarItensVenda(ItensVenda itensVenda) throws Exception {
        try {
            em.persist(itensVenda);
        } catch (Exception ex) {
            throw new Exception(" Produto não cadastrado");
        }
    }

    public List<ItensVenda> getItensVenda() {
        String jpql = "SELECT l FROM ItensVenda l";
        return em.createQuery(jpql, ItensVenda.class).getResultList();
    }
}
