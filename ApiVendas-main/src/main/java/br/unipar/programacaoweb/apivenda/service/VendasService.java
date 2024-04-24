package br.unipar.programacaoweb.apivenda.service;

import br.unipar.programacaoweb.apivenda.model.Vendas;
import br.unipar.programacaoweb.apivenda.repository.VendasRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class VendasService {

    @Inject
    private VendasRepository vendasRepository;

    public void cadastrarVendas(Vendas vendas) throws Exception {
        vendasRepository.cadastrarVendas(vendas);
    }

    public List<Vendas> getVendas() {
        return vendasRepository.getVendas();
    }

    public void updateVendas(Vendas vendas)throws Exception{
        vendasRepository.updateVendas(vendas);
    }

    public void deleteVendas(Integer id)throws Exception{
        vendasRepository.deleteVendas(id);

    }


}
