package org.omoknoone.onionhotsayyo.notification.command.repository;

import org.omoknoone.onionhotsayyo.notification.command.aggregate.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {

}
