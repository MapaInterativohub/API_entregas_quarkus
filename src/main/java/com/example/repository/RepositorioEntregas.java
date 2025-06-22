package com.example.repository;

import com.example.models.Entregas;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RepositorioEntregas implements PanacheRepository<Entregas>{
 
}
