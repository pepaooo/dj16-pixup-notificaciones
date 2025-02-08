package unam.diplomado.notificacion.messaging;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.MapMessage;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import lombok.extern.java.Log;
import unam.diplomado.notificacion.domain.Notificacion;
import unam.diplomado.notificacion.service.NotificationService;

import java.util.logging.Level;

@Log
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/NotificationQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
})
public class NotificationConsumerImpl implements MessageListener {

    @Inject
    private NotificationService notificationService;

    @Override
    public void onMessage(Message message) {
        try {
            MapMessage mapMessage = (MapMessage) message;
            Integer idUsuario = mapMessage.itemExists("idUsuario") ? mapMessage.getInt("idUsuario") : 0;
            String email = mapMessage.itemExists("email") ? mapMessage.getString("email") : "";
            log.info("Mensaje recibido con idUsuario: " + idUsuario + " y email: " + email);
            Notificacion notificacion = notificationService.enviarNotificacionAltaUsuario(idUsuario, email);
            log.info("Se procesó de manera exitosa el mensaje, notificación generada: " + notificacion);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error al proceso el mensaje en el servicio NotificationService", e);
        }
    }

}
