package org.omoknoone.member.repository;

import org.omoknoone.member.aggregate.Auth;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<Auth, String> {
}
