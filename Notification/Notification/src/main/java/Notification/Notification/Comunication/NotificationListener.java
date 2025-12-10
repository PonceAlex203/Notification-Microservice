package Notification.Notification.Comunication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    private static final Logger logger = LoggerFactory.getLogger(NotificationListener.class);

    /**
     * Listens to the notification queue and processes NotificationEvent messages
     * @param pEvent the received notification event
     */
    @RabbitListener(queues = "${queue.notification}")
    public void handleNotification(NotificationEvent pEvent) {
        try {
            logger.info("===== NOTIFICACION RECIBIDA ===== Msg : {} DwId: {}",
                    pEvent.getMessage(), pEvent.getDegreeWorkId());
        } catch (Exception vExc) {
            logger.error("Error", vExc);
        }
    }
}
