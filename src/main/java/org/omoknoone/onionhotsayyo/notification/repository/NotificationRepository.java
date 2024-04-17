package org.omoknoone.onionhotsayyo.notification.repository;

import org.omoknoone.onionhotsayyo.notification.aggregate.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {

}
