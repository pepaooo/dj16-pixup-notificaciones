package unam.diplomado.notificacion.repository;

import unam.diplomado.notificacion.domain.TipoNotificacion;

import java.util.Optional;

public interface TipoNotificacionRepository {

    public Optional<TipoNotificacion> findByDescripcion(String descripcion);

}
