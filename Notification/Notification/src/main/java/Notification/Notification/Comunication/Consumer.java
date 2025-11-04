package Notification.Notification.Comunication;

import Notification.Notification.Services.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    NotificationService notificationService;
    @RabbitListener(queues = {"${notificationQueue.name}"})
    public void receive(@Payload String message) {
        System.out.println("=== Message received ===");
        try{
            notificationService.loggerNotification(message);
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }
}