package org.omoknoone.onionhotsayyo.member.repository;

import org.omoknoone.onionhotsayyo.member.aggregate.Auth;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<Auth, String> {
}
