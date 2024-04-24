package br.unipar.programacaoweb.apivenda.controller;

import br.unipar.programacaoweb.apivenda.model.ItensVenda;
import br.unipar.programacaoweb.apivenda.service.ItensVendaService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/itensVenda")

public class ItensVendaController {

    @Inject
    private ItensVendaService itensVendaService;

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarItensVenda(ItensVenda itensVenda) {
        try {
            itensVendaService.cadastrarItensVenda(itensVenda);
            return Response.status(201).entity("Item de venda cadastrado").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getItensVenda() {
        try {
            return Response.ok(itensVendaService.getItensVenda())
                    .build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
