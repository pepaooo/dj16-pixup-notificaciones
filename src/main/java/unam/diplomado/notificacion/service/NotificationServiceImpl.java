package unam.diplomado.notificacion.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unam.diplomado.notificacion.domain.Notificacion;
import unam.diplomado.notificacion.domain.TipoNotificacion;
import unam.diplomado.notificacion.domain.TipoNotificacionNotFoundException;
import unam.diplomado.notificacion.repository.NotificacionRepository;
import unam.diplomado.notificacion.repository.TipoNotificacionRepository;
import unam.diplomado.pixup.usuario.domain.Usuario;
import unam.diplomado.pixup.usuario.domain.UsuarioNotFoundException;
import unam.diplomado.pixup.usuario.repository.UsuarioRepository;

import java.util.Optional;

@Stateless
public class NotificationServiceImpl implements NotificationService {

    @Inject
    private TipoNotificacionRepository tipoNotificacionRepository;

    @Inject
    private NotificacionRepository notificacionRepository;

    @Inject
    private UsuarioRepository usuarioRepository;

    @Inject
    private EmailService emailService;

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public Notificacion enviarNotificacionAltaUsuario(Integer idUsuario, String email) {
        String descTipoNotificacion = "ALTA_USUARIO";
        String emailTitulo = "Creación de cuenta " + email + " exitosa";
        String emailMensaje = "<h1>Pixup</h1><h3>El usuario " + email + " ha sido dado de alta en el sistema.</h3>";

        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isEmpty()) {
            throw new UsuarioNotFoundException(email);
        }

        Optional<TipoNotificacion> tipoNotificacion = tipoNotificacionRepository.findByDescripcion(descTipoNotificacion);
        if (tipoNotificacion.isEmpty()) {
            throw new TipoNotificacionNotFoundException(descTipoNotificacion);
        }

        Notificacion notificacion = new Notificacion();
        notificacion.setUsuario(usuario.get());
        notificacion.setTipoNotificacion(tipoNotificacion.get());
        notificacionRepository.save(notificacion);
        emailService.enviarEmail(email, emailTitulo, emailMensaje);

        return notificacion;
    }
}
