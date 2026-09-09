package com.example.NotificationService.service;

import com.example.NotificationService.entities.Configuration;

public interface ConfigurationService {
    public Configuration findProperty(String topic, int id_tipo);
}
