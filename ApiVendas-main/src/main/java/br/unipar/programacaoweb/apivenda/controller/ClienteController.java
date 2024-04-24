package br.unipar.programacaoweb.apivenda.controller;

import br.unipar.programacaoweb.apivenda.model.Cliente;
import br.unipar.programacaoweb.apivenda.service.ClienteService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")

public class ClienteController {

    @Inject
    private ClienteService clienteService;

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarCliente(Cliente cliente) {
        try {
            clienteService.cadastrarCliente(cliente);
            return Response.status(201).entity("Cliente cadastrado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getClientes() {
        try {
            return Response.ok(clienteService.getCliente())
                    .build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCliente(Cliente cliente) {
        try {
            clienteService.updateCliente(cliente);
            return Response.status(Response.Status.CREATED)
                    .entity("Cliente atualizado com sucesso")
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
    public Response deleteCliente(Cliente cliente) {
        try {
            clienteService.deleteCliente(cliente.getId());
            return Response.status(Response.Status.OK)
                    .entity("Cliente deletad")
                    .build();
        } catch (Exception ex) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity(ex.getMessage())
                    .build();
        }
    }

}
