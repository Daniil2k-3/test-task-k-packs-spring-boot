package com.example.kpacksinsets.service;

import com.example.kpacksinsets.model.KnowledgePackageSet;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface KnowledgePackageSetService {
    KnowledgePackageSet add(KnowledgePackageSet knowledgePackageSet);

    KnowledgePackageSet get(Long id);

    void delete(Long id);

    List<KnowledgePackageSet> getAll(Pageable pageable);
}
