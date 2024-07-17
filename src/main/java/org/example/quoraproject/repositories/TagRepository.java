package org.example.quoraproject.repositories;

import org.example.quoraproject.models.Question;
import org.example.quoraproject.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
