package com.example.kpacksinsets.service.mapper;

import com.example.kpacksinsets.dto.request.KnowledgePackageSetRequestDto;
import com.example.kpacksinsets.dto.response.KnowledgePackageSetResponseDto;
import com.example.kpacksinsets.model.KnowledgePackage;
import com.example.kpacksinsets.model.KnowledgePackageSet;
import com.example.kpacksinsets.service.KnowledgePackageService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackageSetDtoMapper {
    private final KnowledgePackageService knowledgePackageService;

    public KnowledgePackageSetDtoMapper(KnowledgePackageService knowledgePackageService) {
        this.knowledgePackageService = knowledgePackageService;
    }

    public KnowledgePackageSetResponseDto toDto(KnowledgePackageSet knowledgePackageSet) {
        KnowledgePackageSetResponseDto responseDto = new KnowledgePackageSetResponseDto();
        responseDto.setId(knowledgePackageSet.getId());
        responseDto.setTitle(knowledgePackageSet.getTitle());
        responseDto.setKnowledgePackageIds(knowledgePackageSet.getKnowledgePackages()
                .stream()
                .map(KnowledgePackage::getId)
                .collect(Collectors.toSet()));
        return responseDto;
    }

    public KnowledgePackageSet toModel(KnowledgePackageSetRequestDto requestDto) {
        KnowledgePackageSet knowledgePackageSet = new KnowledgePackageSet();
        knowledgePackageSet.setTitle(requestDto.getTitle());

        knowledgePackageSet.setKnowledgePackages(requestDto.getKnowledgePackageIds()
                .stream()
                .map(knowledgePackageService::getById)
                .collect(Collectors.toSet()));
        return knowledgePackageSet;
    }
}
