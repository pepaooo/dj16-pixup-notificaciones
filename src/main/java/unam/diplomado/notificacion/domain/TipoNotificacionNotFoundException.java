package unam.diplomado.notificacion.domain;

public class TipoNotificacionNotFoundException extends RuntimeException{

    public TipoNotificacionNotFoundException(String descripcion) {
        super("No se encontró el tipo de notificacion para el evento " + descripcion);
    }
}
