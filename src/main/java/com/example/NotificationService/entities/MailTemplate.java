package com.example.NotificationService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mail_template")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MailTemplate {
    @Id
    private int id;

    @Lob
    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @Column(name = "subject")
    private String subject;

}
