package com.example.NotificationService.repository;

import com.example.NotificationService.entities.MailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailTemplateRepository extends JpaRepository<MailTemplate, Integer> {
    MailTemplate findMailTemplateById(int id);
}
