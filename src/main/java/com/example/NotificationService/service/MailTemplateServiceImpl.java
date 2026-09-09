package com.example.NotificationService.service;

import com.example.NotificationService.entities.MailTemplate;
import com.example.NotificationService.repository.MailTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailTemplateServiceImpl implements MailTemplateService {
    public final MailTemplateRepository repository;

    @Override
    public MailTemplate findMailTemplate(int id) {
        return repository.findMailTemplateById(id);
    }
}
