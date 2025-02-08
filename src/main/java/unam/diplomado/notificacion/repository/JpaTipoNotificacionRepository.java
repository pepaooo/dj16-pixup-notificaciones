package unam.diplomado.notificacion.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.notificacion.domain.TipoNotificacion;

import java.util.List;
import java.util.Optional;

@Singleton
public class JpaTipoNotificacionRepository implements TipoNotificacionRepository {

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<TipoNotificacion> findByDescripcion(String descripcion) {
        TypedQuery<TipoNotificacion> query = entityManager.createQuery("select tn from TipoNotificacion tn where tn.descripcion = :descripcion", TipoNotificacion.class);
        query.setParameter("descripcion", descripcion);
        List<TipoNotificacion> queryList = query.getResultList();
        return queryList.isEmpty() ? Optional.empty() : Optional.of(queryList.get(0));
    }

}
