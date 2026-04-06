package com.example.EnvioCorreo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public String enviarCorreo(
            @RequestParam String correo,
            @RequestParam String nombre,
            @RequestParam String mensaje) {

        try {
            emailService.enviarCorreo(correo, nombre, mensaje);
            return "Correo enviado correctamente";
        } catch (Exception e) {
            return "Error al enviar correo: " + e.getMessage();
        }
    }
}