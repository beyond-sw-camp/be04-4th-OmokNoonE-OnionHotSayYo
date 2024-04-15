package org.omoknoone.notification.repository;

import org.omoknoone.notification.aggregate.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {

}
