package xyz.simek.microservices.notification;

import org.springframework.stereotype.Service;
import xyz.simek.microservices.clients.fraud.NotificationRequest;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void sendNotification(NotificationRequest notificationRequest) {

        Notification notification = Notification.builder()
                .message(notificationRequest.message())
                .sender("Jan")
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .sentAt(LocalDateTime.now())
                .build();

        notificationRepository.save(notification);
    }
}
