package com.example.controllers;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.tags.Tag; // Anotação para documentação no Swagger
import org.eclipse.microprofile.rest.client.inject.RestClient; // Anotação para injetar clientes REST

import com.example.client.FrotaClient; // Cliente REST que se comunica com a API de frotas
import com.example.dto.FrotaDTO; // DTO que representa dados de uma frota retornados pela outra API
import com.example.models.Entregas; // Entidade Entregas que será manipulada aqui
import com.example.repository.RepositorioEntregas; // Repositório da entidade Entregas (acesso ao banco)

import jakarta.inject.Inject; // Injeção de dependências
import jakarta.transaction.Transactional; // Para garantir transações ao salvar no banco
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/api/entregas") // Caminho base do endpoint
@Produces(MediaType.APPLICATION_JSON) // As respostas serão no formato JSON
@Consumes(MediaType.APPLICATION_JSON) // As requisições devem conter JSON
@Tag(name = "Entregas", description = "Operações para gerenciamento de Entregas") // Descrição para o Swagger
public class ControleDeEntregas {


    @Inject
    RepositorioEntregas repositorioentregas;
    // Injeta o repositório responsável por salvar, buscar e listar entregas


    @Inject
    @RestClient
    FrotaClient frotaClient;
    // Injeta o cliente REST que acessa a API de frotas, permitindo consultar veículos disponíveis


    @GET
    public List<Entregas> listarEntregas() {
        // Retorna a lista de todas as entregas cadastradas
        return repositorioentregas.listAll();
    }


    @POST
    @Transactional
    public Response criarEntregas(Entregas entrega) {

        try {
            // Busca as frotas que estão disponíveis atualmente, consultando a outra API
            List<FrotaDTO> frotasDisponiveis = frotaClient.listarFrotasDisponiveis();


            for (FrotaDTO frota : frotasDisponiveis) {
                // Para cada frota disponível, verifica se já existe uma entrega cadastrada
                // para esse mesmo veículo na mesma data
                boolean ocupado = repositorioentregas
                    .list("frotaId = ?1 and dataDeSaidaDeEntrega = ?2", frota.id, entrega.getDataDeSaidaDeEntrega())
                    .size() > 0;


                    if (!ocupado) {
                    // Se a frota estiver livre naquela data, associa à entrega e persiste no banco
                    entrega.setFrotaId(frota.id);
                    repositorioentregas.persist(entrega);
                    return Response.status(201).entity("Entrega agendada com sucesso.").build();
                }
            }


            // Se nenhum veículo estiver disponível para a data informada, retorna erro de conflito
            return Response.status(409).entity("Nenhum veículo disponível para a data informada.").build();


            } catch (Exception e) {
            // Caso ocorra qualquer erro inesperado, retorna erro interno do servidor
            return Response.serverError().entity("Erro ao agendar entrega: " + e.getMessage()).build();
        }
    }
}

