package org.omoknoone.onionhotsayyo.bookmark.command.service;

import org.omoknoone.onionhotsayyo.bookmark.command.dto.BookmarkDTO;

public interface BookmarkService {
	void addBookmark(BookmarkDTO bookmarkDTO);

	void removeBookmark(BookmarkDTO bookmarkDTO);
}
