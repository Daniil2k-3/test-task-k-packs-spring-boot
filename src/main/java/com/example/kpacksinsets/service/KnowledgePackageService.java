package com.example.kpacksinsets.service;

import com.example.kpacksinsets.model.KnowledgePackage;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface KnowledgePackageService {
    KnowledgePackage add(KnowledgePackage knowledgePackage);

    List<KnowledgePackage> getAll(Pageable pageable);

    KnowledgePackage getById(Long id);

    void delete(Long id);

    KnowledgePackage getByTitle(String title);

    List<KnowledgePackage> getByDate(String date);
}
