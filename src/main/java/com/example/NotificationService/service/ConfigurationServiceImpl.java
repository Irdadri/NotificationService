package com.example.NotificationService.service;

import com.example.NotificationService.entities.Configuration;
import com.example.NotificationService.repository.ConfigurationRepository;
import com.example.NotificationService.repository.TipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfigurationServiceImpl implements ConfigurationService {

    private final ConfigurationRepository repository;
    private final TipoRepository tipoRepository;


    @Override
    public Configuration findProperty(String topic, int id_tipo) {
        return repository.findConfigurationByTopicAndTipo(topic, tipoRepository.findTipoById(id_tipo));
    }
}
