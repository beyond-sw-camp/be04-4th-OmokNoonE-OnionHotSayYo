package org.omoknoone.onionhotsayyo.member.repository;

import org.omoknoone.onionhotsayyo.member.aggregate.Auth;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<Auth, String> {
}
