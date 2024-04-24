package br.unipar.programacaoweb.apivenda.repository;

import br.unipar.programacaoweb.apivenda.model.Cliente;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

import java.util.List;

@Stateless
public class ClienteRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;
    private UserTransaction utx;

    public void cadastrarCliente(Cliente cliente) throws Exception {
        try {
            em.persist(cliente);
        } catch (Exception ex) {
            throw new Exception("Cliente não pode ser cadastrado");
        }
    }

    public List<Cliente> getClientes() {
        String jpql = "SELECT l FROM Cliente l";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public void updateCliente(Cliente cliente) {
        try {
            Cliente clienteAtualizado = em.find(Cliente.class, cliente.getId());
            if (clienteAtualizado != null) {
                clienteAtualizado.setNome(cliente.getNome());
                clienteAtualizado.setTelefone(cliente.getTelefone());

                em.merge(clienteAtualizado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCliente(Integer id) {
        try {
            Cliente cliente = em.find(Cliente.class, id);
            if (cliente != null) {
                em.remove(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
