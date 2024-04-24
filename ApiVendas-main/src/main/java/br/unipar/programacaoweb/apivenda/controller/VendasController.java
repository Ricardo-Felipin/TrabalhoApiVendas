package br.unipar.programacaoweb.apivenda.controller;

import br.unipar.programacaoweb.apivenda.model.Vendas;

import br.unipar.programacaoweb.apivenda.service.VendasService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/vendas")
public class VendasController {

    @Inject
    private VendasService vendasService;

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarVendas(Vendas vendas) {
        try {
            vendasService.cadastrarVendas(vendas);
            return Response.status(201).entity("Venda cadastrada com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getVendas() {
        try {
            return Response.ok(vendasService.getVendas())
                    .build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatevendas(Vendas vendas) {
        try {
            vendasService.updateVendas(vendas);
            return Response.status(Response.Status.CREATED)
                    .entity("Vendas atualizadas com sucesso")
                    .build();
        } catch (Exception ex) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity(ex.getMessage())
                    .build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletevendas(Vendas vendas) {
        try {
            vendasService.deleteVendas(vendas.getId());
            return Response.status(Response.Status.OK)
                    .entity("Vendas deletdas")
                    .build();
        } catch (Exception ex) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity(ex.getMessage())
                    .build();
        }
    }

}
