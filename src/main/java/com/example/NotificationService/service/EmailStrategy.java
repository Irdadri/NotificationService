package com.example.NotificationService.service;

import com.example.NotificationService.dto.KafkaMessage;
import com.example.NotificationService.entities.Configuration;
import com.example.NotificationService.entities.MailTemplate;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

@Log
@RequiredArgsConstructor
@Component
public class EmailStrategy implements NotificationService {

    public final ConfigurationService configurationService;
    public final MailTemplateService mailTemplateService;
    public final TemplateEngine emailTemplateEngine;
    Locale locale;

    final String username = "side.adri.121300@gmail.com";
    final String password = "bvtg myqs yruw dhup";

    public static final int EMAIL_CODE = 1;


    @Override
    public void notify(String topic, KafkaMessage kafkaMessage) {

        Configuration configuration = configurationService.findProperty(topic, EMAIL_CODE);
        String[] values = configuration.getValues().split(";");
        String[] properties = configuration.getProperties().split(";");

        Properties prop = new Properties();


        if (values.length == properties.length) {
            for (int i = 0; i < values.length; i++) {
                prop.put(properties[i], values[i]);
            }
        }


        Session session = Session.getInstance(
                prop,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                }
        );

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("side.adri.121300@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("adriana.lucia.121300@gmail.com")
            );
            /*
                 message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(prenotazioneProperties.get("email");
            );
             */

            MailTemplate mailTemplate = mailTemplateService.findMailTemplate(EMAIL_CODE);

            final Context ctx = new Context(locale);
            //ctx.setVariable("name", kafkaMessage.getPrenotazioneDTO().getNomeUtente());
            Map<String, String> prenotazioneProperties = kafkaMessage.getProperties();
            ctx.setVariable("name", prenotazioneProperties.get("nome utente"));

            LocalDateTime dataInizio = LocalDateTime.parse(prenotazioneProperties.get("dataInizio"));
            ctx.setVariable("subscriptionDate", dataInizio);

            ctx.setVariable("citta", prenotazioneProperties.get("citta"));
            ctx.setVariable("indirizzo", prenotazioneProperties.get("indirizzo"));
            ctx.setVariable("nStanza", prenotazioneProperties.get("nStanza"));

            final String htmlContent = this.emailTemplateEngine.process(mailTemplate.getBody(), ctx);

            message.setSubject(mailTemplate.getSubject());
            message.setContent(htmlContent, "text/html; charset=UTF-8");
            Transport.send(message);


            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}




            /*
            <!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <head>
   <title>Prenotazione effettuata</title>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  <body>
    <p th:text="#{greeting(${name})}">
    Congratulazioni
</p>

<p>
    La tua prenotazione per il
    <span th:text="${#dates.format(subscriptionDate, 'dd-MM-yyyy')}">
        28-12-2012
    </span>
</p>

<p>Con i seguenti dati:</p>

<ul>
    <li>
        Città:
        <span th:text="${città}">Reading</span>
    </li>
    <li>
        Indirizzo:
        <span th:text="${indirizzo}">Via Roma 10</span>
    </li>
    <li>
        Numero stanza:
        <span th:text="${nStanza}">101</span>
    </li>
</ul>

<p>
    Regards,<br/>
    <em>Me</em>
</p>

</body> </html>

             */
