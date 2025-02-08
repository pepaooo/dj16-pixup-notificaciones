package unam.diplomado.notificacion.service;

import jakarta.ejb.Local;

@Local
public interface EmailService {

    void enviarEmail(String email, String titulo, String mensaje);

}
