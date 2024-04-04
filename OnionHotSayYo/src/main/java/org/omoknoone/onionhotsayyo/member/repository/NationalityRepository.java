package org.omoknoone.onionhotsayyo.member.repository;

import org.omoknoone.onionhotsayyo.member.aggregate.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationalityRepository extends JpaRepository<Nationality, String> {
}
