package com.example.NotificationService.kafka;

import com.example.NotificationService.dto.KafkaMessage;
import com.example.NotificationService.service.ConfigurationService;
import com.example.NotificationService.service.EmailStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@RequiredArgsConstructor
public class KafkaNotificationSender {

    private final ConfigurationService configurationService;
    private final EmailStrategy emailStrategy;

    //oggetto da mandare attraverso Kafka
    /*
    dovrebbe mandare:
    tipo di notifica
    prenotazione DTO:
    nome del topic?
     */
    @KafkaListener(topics = "notification", groupId = "myGroup")
    public void listener(KafkaMessage kafkaMessage){

        switch (kafkaMessage.getTipoNotifica()) {
            case "EMAIL":
                emailStrategy.notify("notification", kafkaMessage);
                break;
            case "SMS":
                //
            case "POPUP":
                //
            default:
                //
        }

    }
}
