package org.example.quoraproject.repositories;

import org.example.quoraproject.models.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("SELECT q FROM Question q JOIN q.tags t WHERE t.id IN :tagIds")
    Page<Question> findQuestionsByTags(Set<Long> tagIds, Pageable pageable);
}