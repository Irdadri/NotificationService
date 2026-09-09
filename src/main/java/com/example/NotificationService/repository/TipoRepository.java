package com.example.NotificationService.repository;

import com.example.NotificationService.entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, Integer> {
    Tipo findTipoById(int id);
}
