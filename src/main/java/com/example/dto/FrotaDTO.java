package com.example.dto; 
// Declaração do pacote onde a classe está localizada. Organiza o código em namespaces.

public class FrotaDTO { 
    // Classe pública chamada FrotaDTO (Data Transfer Object), usada para transportar dados.

    public Long id; 
    // Identificador único da frota 

    public String modeloCaminhao; 
    // Modelo do caminhão 

    public String placa; 
    // Placa do veículo, geralmente um código alfanumérico.

    public int capacidadeDeCarga; 
    // Capacidade máxima de carga do caminhão (em kg, toneladas, etc).

    public boolean disponivel; 
    // Flag indicando se a frota está disponível para uso.

    public boolean veiculoDisponivel; 
    // Indica se o veículo está disponível especificamente.

    public boolean motoristaDisponivel; 
    // Indica se o motorista está disponível para dirigir.

    
}
