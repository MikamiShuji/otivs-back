package ru.stemasoff.dpr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stemasoff.dpr.model.KnowledgeBaseEntity;


public interface KnowledgeBaseRepository extends JpaRepository<KnowledgeBaseEntity, String> {


}
