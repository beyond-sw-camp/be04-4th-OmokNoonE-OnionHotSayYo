package org.omoknoone.nationality.repository;

import org.omoknoone.nationality.aggregate.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationalityRepository extends JpaRepository<Nationality, String> {
}
