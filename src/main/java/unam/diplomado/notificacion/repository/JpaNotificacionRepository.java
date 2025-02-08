package unam.diplomado.notificacion.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.notificacion.domain.Notificacion;

import java.util.Date;

@Singleton
public class JpaNotificacionRepository implements NotificacionRepository {

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Notificacion save(Notificacion notificacion) {
        notificacion.setFechaNotificacion(new Date(System.currentTimeMillis()));
        entityManager.persist(notificacion);
        return notificacion;
    }

}
