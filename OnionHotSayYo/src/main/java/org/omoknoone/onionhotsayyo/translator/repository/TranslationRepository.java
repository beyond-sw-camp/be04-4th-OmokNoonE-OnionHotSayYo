package org.omoknoone.onionhotsayyo.translator.repository;

import org.omoknoone.onionhotsayyo.translator.aggregate.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TranslationRepository extends JpaRepository<Translation, String> {

    @Query(value = """
        select a
        from Translation a
        where a.language = :targetLang
        and a.postId in :excludePostIds
    """)
    List<Translation> findAllByPostIdAndLanguage(List<Integer> excludePostIds, String targetLang);
}
