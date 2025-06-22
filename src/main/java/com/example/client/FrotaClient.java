package com.example.client; // Define o pacote onde o cliente REST está localizado

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.example.dto.DisponibilidadeDTO;
import com.example.dto.FrotaDTO;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
// Importa as anotações JAX-RS usadas para mapear os endpoints HTTP


@RegisterRestClient(configKey = "frota-api")
// Essa anotação registra a interface como cliente REST com base em uma chave definida no application.properties
// Exemplo de configuração no application.properties:
// frota-api/mp-rest/url=http://localhost:8081

@Path("/api/frotas")
// Define a rota base comum para todos os endpoints mapeados nesta interface.
// Ela corresponde ao controller da API de Frotas: @Path("/api/frotas")
public interface FrotaClient {


        @GET
    @Path("/disponibilidade") // apenas o endpoint
    // Realiza uma chamada GET para /api/frotas/disponibilidade
    // Utilizado para verificar se há veículos e motoristas disponíveis na frota
    DisponibilidadeDTO verificarDisponibilidade();


    @GET
    @Path("/disponiveis")
    // Realiza uma chamada GET para /api/frotas/disponiveis
    // Retorna a lista de frotas que estão com veículo, motorista e status disponíveis
    List<FrotaDTO> listarFrotasDisponiveis(); 
}

