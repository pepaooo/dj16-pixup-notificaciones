package unam.diplomado.pixup.usuario.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.usuario.domain.Usuario;

import java.util.List;
import java.util.Optional;

@Singleton
public class JpaUsuarioRepository implements UsuarioRepository {

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Usuario> findByEmail(String email) {
        TypedQuery<Usuario> query = entityManager.createQuery("select u from Usuario u where u.email = :email", Usuario.class);
        query.setParameter("email", email);
        List<Usuario> usuarios = query.getResultList();
        return usuarios.isEmpty() ? Optional.empty() : Optional.of(usuarios.get(0));
    }

}
