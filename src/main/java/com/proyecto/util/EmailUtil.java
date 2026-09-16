package com.proyecto.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

    private static final String CORREO_REMITENTE = "juansediazg4@gmail.com";
    private static final String PASSWORD_APP = "ageqibrhdyadkwjc";

    public static boolean enviarCorreoRecuperacion(String destino, String nombreUsuario, String claveRecuperada) {
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CORREO_REMITENTE, PASSWORD_APP);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(CORREO_REMITENTE));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
            message.setSubject("Recuperación de Acceso - Gestión Fútbol");
            
            String contenidoHtml = "<h3>Hola " + nombreUsuario + ",</h3>"
                    + "<p>Has solicitado la recuperación de tu acceso.</p>"
                    + "<p>Tu contraseña actual es: <b>" + claveRecuperada + "</b></p>"
                    + "<p>Por seguridad, te recomendamos iniciar sesión y modificarla cuanto antes.</p>";
                    
            message.setContent(contenidoHtml, "text/html; charset=utf-8");

            Transport.send(message);
            System.out.println("Correo enviado exitosamente a: " + destino);
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error enviando el correo: " + e.getMessage());
            return false;
        }
    }
}
