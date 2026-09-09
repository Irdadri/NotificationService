package com.example.NotificationService.repository;

import com.example.NotificationService.entities.Configuration;
import com.example.NotificationService.entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> {
    Configuration findConfigurationByTopicAndTipo(String topic, Tipo tipo);
}
