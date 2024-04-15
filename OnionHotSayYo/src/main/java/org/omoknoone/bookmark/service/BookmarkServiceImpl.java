package org.omoknoone.bookmark.service;

import org.modelmapper.ModelMapper;
import org.omoknoone.bookmark.aggregate.Bookmark;
import org.omoknoone.bookmark.dto.BookmarkDTO;
import org.omoknoone.bookmark.repository.BookmarkRepository;
import org.omoknoone.exceptions.BookmarkNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService{

	private static final Logger log = LoggerFactory.getLogger(BookmarkServiceImpl.class);
	private final BookmarkRepository bookmarkRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public BookmarkServiceImpl(BookmarkRepository bookmarkRepository, ModelMapper modelMapper) {
		this.bookmarkRepository = bookmarkRepository;
		this.modelMapper = modelMapper;
	}

	@Transactional
	@Override
	public void addBookmark(BookmarkDTO bookmarkDTO) {
		log.info("북마크 추가 시작, 회원 ID {}");
		Bookmark bookmark = modelMapper.map(bookmarkDTO, Bookmark.class);
		bookmarkRepository.save(bookmark);
	}

	@Transactional
	@Override
	public void removeBookmark(BookmarkDTO bookmarkDTO) {
		Bookmark bookmark = modelMapper.map(bookmarkDTO, Bookmark.class);
		bookmarkRepository.delete(bookmark);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Bookmark> findBookmarkSByMemberId(String memberId) {
		log.info("회원 ID {}에 대한 북마크 목록 조회 시작", memberId);

		List<Bookmark> bookmarks = bookmarkRepository.findByMemberId(memberId);
		if (bookmarks.isEmpty()) {
			log.warn("회원 ID {}에 대한 북마크 목록이 존재하지 않습니다.", memberId);
			throw new BookmarkNotFoundException("북마크 목록을 찾을 수 없습니다.");
		}
		log.info("회원 ID {}에 대한 북마크 목록 조회 완료: {}건 발견", memberId, bookmarks.size());

		return bookmarks;
	}
}
