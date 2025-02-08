package unam.diplomado.notificacion.service;

import jakarta.ejb.Local;
import unam.diplomado.notificacion.domain.Notificacion;

@Local
public interface NotificationService {

    Notificacion enviarNotificacionAltaUsuario(Integer idUsuario, String email);

}
