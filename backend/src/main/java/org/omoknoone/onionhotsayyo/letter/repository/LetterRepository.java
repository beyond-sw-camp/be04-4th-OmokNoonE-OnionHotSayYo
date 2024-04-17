package org.omoknoone.onionhotsayyo.letter.repository;

import java.util.List;

import org.omoknoone.onionhotsayyo.letter.aggregate.Letter;
import org.omoknoone.onionhotsayyo.member.aggregate.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterRepository extends JpaRepository<Letter, Integer> {

	Long countByReceiveIdAndIsChecked(String memberId, boolean isChecked);
	List<Letter> findAllByReceiveIdOrderByEventTimeDesc(Member receiver);

	List<Letter> findBySendId(String memberId);

	List<Letter> findByReceiveId(String memberId);

	List<Letter> findByReceiveIdAndIsChecked(String memberId, boolean isChecked);

}
