package org.omoknoone.onionhotsayyo.post.command.repository;

import org.omoknoone.onionhotsayyo.post.command.aggregate.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
