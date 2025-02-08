package unam.diplomado.notificacion.repository;

import unam.diplomado.notificacion.domain.Notificacion;

import java.util.Optional;

public interface NotificacionRepository {

    Notificacion save(Notificacion notificacion);

}
