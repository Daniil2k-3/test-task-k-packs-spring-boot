package com.example.kpacksinsets.service;

import com.example.kpacksinsets.model.KnowledgePackage;
import java.util.List;

public interface KnowledgePackageService {
    KnowledgePackage add(KnowledgePackage knowledgePackage);

    List<KnowledgePackage> getAll();

    KnowledgePackage getById(Long id);

    void delete(Long id);
}
