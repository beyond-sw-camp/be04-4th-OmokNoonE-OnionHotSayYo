package org.omoknoone.onionhotsayyo.nationality.repository;

import org.omoknoone.onionhotsayyo.nationality.aggregate.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationalityRepository extends JpaRepository<Nationality, String> {
}
