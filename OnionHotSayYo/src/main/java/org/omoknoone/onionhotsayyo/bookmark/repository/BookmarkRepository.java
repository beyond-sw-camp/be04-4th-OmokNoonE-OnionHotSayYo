package org.omoknoone.onionhotsayyo.bookmark.repository;

import org.omoknoone.onionhotsayyo.bookmark.aggregate.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {

    // 맴버 ID에 해당하는 북마크 된 게시물 목록 조회 메소드
    List<Bookmark> findByMemberId(String memberId);
}
