package com.example.NotificationService.service;


import com.example.NotificationService.dto.KafkaMessage;
import org.springframework.stereotype.Component;

@Component
public interface NotificationService {

    public void notify(String topic, KafkaMessage kafkaMessage);
}
