package unam.diplomado.pixup.usuario.repository;

import unam.diplomado.pixup.usuario.domain.Usuario;

import java.util.Optional;

public interface UsuarioRepository {

    public Optional<Usuario> findByEmail(String email);

    public Usuario save(Usuario usuario);

}
