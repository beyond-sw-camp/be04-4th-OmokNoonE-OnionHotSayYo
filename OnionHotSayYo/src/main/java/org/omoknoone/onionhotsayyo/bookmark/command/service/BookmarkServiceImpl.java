package org.omoknoone.onionhotsayyo.bookmark.command.service;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.bookmark.command.aggregate.Bookmark;
import org.omoknoone.onionhotsayyo.bookmark.command.dto.BookmarkDTO;
import org.omoknoone.onionhotsayyo.bookmark.command.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkServiceImpl implements BookmarkService{

	private final BookmarkRepository bookmarkRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public BookmarkServiceImpl(BookmarkRepository bookmarkRepository, ModelMapper modelMapper) {
		this.bookmarkRepository = bookmarkRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void addBookmark(BookmarkDTO bookmarkDTO) {
		Bookmark bookmark = modelMapper.map(bookmarkDTO, Bookmark.class);
		bookmarkRepository.save(bookmark);
	}

	@Override
	public void removeBookmark(BookmarkDTO bookmarkDTO) {
		Bookmark bookmark = modelMapper.map(bookmarkDTO, Bookmark.class);
		bookmarkRepository.delete(bookmark);
	}
}
