package ru.aston.service;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService (JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendCreatedAccountEmail(String email) {
        SimpleMailMessage createMessage = getBaseMessage(email);
        createMessage.setSubject("Account created");
        createMessage.setText("Hello. Your account has been created!");
        try {
            javaMailSender.send(createMessage);
        } catch (MailException e) {
            throw new EmailDeliveryException(
                    "Failed to send 'Account created' email.", e
            );
        }
    }

    @Override
    public void sendDeletedAccountEmail(String email) {
        SimpleMailMessage deleteMessage = getBaseMessage(email);
        deleteMessage.setSubject("Account deleted");
        deleteMessage.setText("Hello. Your account has been deleted!");
        try {
            javaMailSender.send(deleteMessage);
        } catch (MailException e) {
            throw new EmailDeliveryException(
                    "Failed to send 'Delete account' email.", e
            );
        }
    }

    private static SimpleMailMessage getBaseMessage(String email) {
        SimpleMailMessage baseMessage = new SimpleMailMessage();
        baseMessage.setFrom("noreply@naragas.ru");
        baseMessage.setTo(email);
        return baseMessage;
    }
}