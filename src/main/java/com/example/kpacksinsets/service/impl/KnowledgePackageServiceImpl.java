package com.example.kpacksinsets.service.impl;

import com.example.kpacksinsets.model.KnowledgePackage;
import com.example.kpacksinsets.repository.KnowledgePackageRepository;
import com.example.kpacksinsets.service.KnowledgePackageService;
import java.util.List;
import org.springframework.data.domain.Pageable;
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
    public List<KnowledgePackage> getAll(Pageable pageable) {
        return knowledgePackageRepository.findAll(pageable).toList();
    }

    @Override
    public KnowledgePackage getById(Long id) {
        return knowledgePackageRepository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        knowledgePackageRepository.deleteById(id);
    }

    @Override
    public KnowledgePackage getByTitle(String title) {
        return knowledgePackageRepository.getKnowledgePackageByTitle(title);
    }

    @Override
    public List<KnowledgePackage> getByDate(String date) {
        return knowledgePackageRepository.getAllByCreationTime(date);
    }
}
