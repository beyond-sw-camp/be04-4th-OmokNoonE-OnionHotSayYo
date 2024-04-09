package org.omoknoone.onionhotsayyo.bookmark.command.repository;

import org.omoknoone.onionhotsayyo.bookmark.command.aggregate.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {
}
