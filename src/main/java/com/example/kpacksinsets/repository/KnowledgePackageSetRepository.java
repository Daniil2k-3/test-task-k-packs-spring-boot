package com.example.kpacksinsets.repository;

import com.example.kpacksinsets.model.KnowledgePackageSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgePackageSetRepository
        extends JpaRepository<KnowledgePackageSet, Long> {
}
