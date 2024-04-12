package org.omoknoone.onionhotsayyo.letter.command.repository;

import java.util.List;

import org.omoknoone.onionhotsayyo.letter.command.aggregate.Letter;
import org.omoknoone.onionhotsayyo.member.aggregate.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LetterRepository extends JpaRepository<Letter, Integer> {

	Long countByReceiveIdAndIsChecked(String memberId, boolean isChecked);
	List<Letter> findAllByReceiveIdOrderByEventTimeDesc(Member receiver);

	List<Letter> findBySendId(String memberId);

	List<Letter> findByReceiveId(String memberId);

	List<Letter> findByReceiveIdAndIsChecked(String memberId, boolean isChecked);

}
