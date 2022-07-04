package com.example.kpacksinsets.service.mapper;

import com.example.kpacksinsets.dto.request.KnowledgePackageRequestDto;
import com.example.kpacksinsets.dto.response.KnowledgePackageResponseDto;
import com.example.kpacksinsets.model.KnowledgePackage;
import com.example.kpacksinsets.service.KnowledgePackageService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackageDtoMapper {
    private final KnowledgePackageService knowledgePackageService;

    public KnowledgePackageDtoMapper(KnowledgePackageService knowledgePackageService) {
        this.knowledgePackageService = knowledgePackageService;
    }

    public KnowledgePackageResponseDto toDto(KnowledgePackage knowledgePackage) {
        KnowledgePackageResponseDto knowledgePackageResponseDto =
                new KnowledgePackageResponseDto();
        knowledgePackageResponseDto.setId(knowledgePackage.getId());
        knowledgePackageResponseDto.setTitle(knowledgePackage.getTitle());
        knowledgePackageResponseDto.setDescription(knowledgePackage.getDescription());
        knowledgePackageResponseDto.setCreationTime(knowledgePackage.getCreationTime());
        return knowledgePackageResponseDto;
    }

    public KnowledgePackage toModel(KnowledgePackageRequestDto requestDto) {
        KnowledgePackage knowledgePackage = new KnowledgePackage();
        knowledgePackage.setTitle(requestDto.getTitle());
        knowledgePackage.setDescription(requestDto.getDescription());
        knowledgePackage.setCreationTime(provideDate());
        return knowledgePackageService.add(knowledgePackage);
    }

    private String provideDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.now().format(dateTimeFormatter);
    }
}
