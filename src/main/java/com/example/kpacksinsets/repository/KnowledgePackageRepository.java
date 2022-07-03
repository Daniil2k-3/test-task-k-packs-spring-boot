package com.example.kpacksinsets.repository;

import com.example.kpacksinsets.model.KnowledgePackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgePackageRepository extends JpaRepository<KnowledgePackage, Long> {
}
