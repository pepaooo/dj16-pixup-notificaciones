package unam.diplomado.pixup.usuario.domain;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String email) {
        super("No se encontró un usuario con el email " + email);
    }
}
