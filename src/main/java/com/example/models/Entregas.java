package com.example.models;
// Declaração do pacote onde esta classe está localizada, que neste caso é "models" 

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// Importa anotações do Jakarta Persistence API (JPA), que é usada para mapear classes Java para tabelas em banco de dados.

@Entity
// Indica que essa classe é uma entidade JPA, ou seja, será mapeada para uma tabela no banco.

@Table(name = "Entregas")
// Especifica que a tabela correspondente no banco de dados se chama "Entregas".

public class Entregas {
    @Id
    // Indica que o atributo 'id' é a chave primária da tabela.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Especifica que o valor do 'id' será gerado automaticamente pelo banco (auto incremento).

    private long id; 
    // Identificador único da entrega.

    private String categoria; 
    // Categoria da entrega (ex: "alimentação", "eletrônicos", etc).

    private Long frotaId; 
    // Chave estrangeira que relaciona a entrega a uma frota específica.

    @Column(nullable = false)
    // Especifica que a coluna 'dataDeSaidaDeEntrega' não pode ser nula no banco.

    private Date dataDeSaidaDeEntrega; 
    // Data em que a entrega saiu para ser realizada.

    private int volume; 
    // Volume da carga na entrega, pode ser uma medida como metros cúbicos, por exemplo.

    // Getters e Setters para acessar e modificar os atributos da classe:

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getDataDeSaidaDeEntrega() {
        return dataDeSaidaDeEntrega;
    }

    public void setDataDeSaidaDeEntrega(Date dataDeSaidaDeEntrega) {
        this.dataDeSaidaDeEntrega = dataDeSaidaDeEntrega;
        System.out.println("Ola"); // Imprime "Ola" no console toda vez que essa data é alterada (provavelmente para testes).
    }

    public Long getFrotaId() {
        return frotaId;
    }

    public void setFrotaId(Long frotaId) {
        this.frotaId = frotaId;
    }
}
