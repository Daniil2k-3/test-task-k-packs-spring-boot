package com.example.kpacksinsets.service.impl;

import com.example.kpacksinsets.model.KnowledgePackageSet;
import com.example.kpacksinsets.repository.KnowledgePackageSetRepository;
import com.example.kpacksinsets.service.KnowledgePackageSetService;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KnowledgePackageSetServiceImpl implements KnowledgePackageSetService {
    private final KnowledgePackageSetRepository knowledgePackageSetRepository;

    public KnowledgePackageSetServiceImpl(KnowledgePackageSetRepository
                                                  knowledgePackageSetRepository) {
        this.knowledgePackageSetRepository = knowledgePackageSetRepository;
    }

    @Override
    public KnowledgePackageSet add(KnowledgePackageSet knowledgePackageSet) {
        return knowledgePackageSetRepository.save(knowledgePackageSet);
    }

    @Override
    public KnowledgePackageSet get(Long id) {
        return knowledgePackageSetRepository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        knowledgePackageSetRepository.deleteById(id);
    }

    @Override
    public List<KnowledgePackageSet> getAll(Pageable pageable) {
        return knowledgePackageSetRepository.findAll(pageable).toList();
    }
}
