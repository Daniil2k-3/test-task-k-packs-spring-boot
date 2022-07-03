package com.example.kpacksinsets.service.impl;

import com.example.kpacksinsets.model.KnowledgePackage;
import com.example.kpacksinsets.repository.KnowledgePackageRepository;
import com.example.kpacksinsets.service.KnowledgePackageService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class KnowledgePackageServiceImpl implements KnowledgePackageService {
    private final KnowledgePackageRepository knowledgePackageRepository;

    public KnowledgePackageServiceImpl(KnowledgePackageRepository knowledgePackageRepository) {
        this.knowledgePackageRepository = knowledgePackageRepository;
    }

    @Override
    public KnowledgePackage add(KnowledgePackage knowledgePackage) {
        return knowledgePackageRepository.save(knowledgePackage);
    }

    @Override
    public List<KnowledgePackage> getAll() {
        return knowledgePackageRepository.findAll();
    }

    @Override
    public KnowledgePackage getById(Long id) {
        return knowledgePackageRepository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        knowledgePackageRepository.deleteById(id);
    }
}
