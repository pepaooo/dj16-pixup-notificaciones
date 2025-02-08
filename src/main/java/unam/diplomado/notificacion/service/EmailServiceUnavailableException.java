package unam.diplomado.notificacion.service;

public class EmailServiceUnavailableException extends RuntimeException {

    public EmailServiceUnavailableException() {
        super("El servidor de email no se encuentra disponible");
    }

}
