package unam.diplomado.pixup.usuario.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.usuario.domain.TipoDomicilio;

import java.util.Collection;
import java.util.Optional;

@Singleton
public class JpaTipoDomicilioRepository implements TipoDomicilioRepository {

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Collection<TipoDomicilio> findAll() {
        TypedQuery<TipoDomicilio> query = entityManager.createQuery("select td from TipoDomicilio td", TipoDomicilio.class);
        return query.getResultList();
    }

    @Override
    public Optional<TipoDomicilio> findById(Integer id) {
        TipoDomicilio query = entityManager.find(TipoDomicilio.class, id);
//        return Optional.ofNullable(query);
        if (query != null) {
            return Optional.of(query);
        } else {
            return Optional.empty();
        }
    }

}
