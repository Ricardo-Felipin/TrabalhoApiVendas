package br.unipar.programacaoweb.apivenda.service;

import br.unipar.programacaoweb.apivenda.model.ItensVenda;
import br.unipar.programacaoweb.apivenda.repository.ItensVendaRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless

public class ItensVendaService {

    @Inject
    private ItensVendaRepository itensVendaRepository;

    public void cadastrarItensVenda(ItensVenda itensVenda) throws Exception {
        itensVendaRepository.cadastrarItensVenda(itensVenda);
    }

    public List<ItensVenda> getItensVenda() {
        return itensVendaRepository.getItensVenda();
    }


}
