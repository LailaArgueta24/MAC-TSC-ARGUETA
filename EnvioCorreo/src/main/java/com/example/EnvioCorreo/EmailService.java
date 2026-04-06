package com.example.EnvioCorreo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void enviarCorreo(String correo, String nombre, String mensajeTexto) throws MessagingException {

        Context context = new Context();
        context.setVariable("nombre", nombre);
        context.setVariable("mensaje", mensajeTexto);

        String contenidoHtml = templateEngine.process("correo", context);

        MimeMessage mensaje = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje, true);

        helper.setTo(correo);
        helper.setSubject("Correo de prueba");
        helper.setText(contenidoHtml, true);

        mailSender.send(mensaje);
    }
}
