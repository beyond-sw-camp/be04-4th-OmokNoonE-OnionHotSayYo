package org.omoknoone.onionhotsayyo.post.command.repository;

import org.omoknoone.onionhotsayyo.post.command.aggregate.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    // 지역 이름으로 Location 조회
    Location findByLocation(String location);
}
