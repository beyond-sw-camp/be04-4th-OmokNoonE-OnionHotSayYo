package org.omoknoone.bookmark.service;

import org.omoknoone.bookmark.aggregate.Bookmark;
import org.omoknoone.bookmark.dto.BookmarkDTO;

import java.util.List;

public interface BookmarkService {
	void addBookmark(BookmarkDTO bookmarkDTO);

	void removeBookmark(BookmarkDTO bookmarkDTO);

	// 내가 북마크한 게시글 목록 조회
	List<Bookmark> findBookmarkSByMemberId(String memberId);
}
