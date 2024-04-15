package org.omoknoone.onionhotsayyo.bookmark.controller;

import org.omoknoone.onionhotsayyo.bookmark.dto.BookmarkDTO;
import org.omoknoone.onionhotsayyo.bookmark.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

	private final BookmarkService bookmarkService;

	@Autowired
	public BookmarkController(BookmarkService bookmarkService) {
		this.bookmarkService = bookmarkService;
	}

	// 북마크 추가
	@PostMapping("/create")
	public void addBookmark(@RequestBody BookmarkDTO bookmarkDTO) {
		bookmarkService.addBookmark(bookmarkDTO);
	}

	// 북마크 취소
	@DeleteMapping("/remove")
	public void removeBookmark(@RequestBody BookmarkDTO bookmarkDTO) {
		bookmarkService.removeBookmark(bookmarkDTO);
	}
}
