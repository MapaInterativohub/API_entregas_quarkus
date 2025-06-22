package com.example.dto;

// Classe utilizada para transferir dados sobre a disponibilidade de frotas
// entre a API de Frotas e a API de Entregas
public class DisponibilidadeDTO {

    // Indica se há pelo menos um veículo disponível no sistema de frotas
    public boolean veiculoDisponivel;

    // Indica se há pelo menos um motorista disponível no sistema de frotas
    public boolean motoristaDisponivel;

    // Construtor padrão vazio (necessário para bibliotecas de serialização, como Jackson ou JSON-B)
    public DisponibilidadeDTO() {}


    // Construtor que permite inicializar o DTO diretamente com os dois valores
    public DisponibilidadeDTO(boolean veiculoDisponivel, boolean motoristaDisponivel) {
        this.veiculoDisponivel = veiculoDisponivel;
        this.motoristaDisponivel = motoristaDisponivel;
    }


    // Método utilitário que retorna true apenas se veículo e motorista estiverem disponíveis
    // Usado para lógica simplificada em validações
    public boolean isDisponivel() {
        return veiculoDisponivel && motoristaDisponivel;
    }
}

