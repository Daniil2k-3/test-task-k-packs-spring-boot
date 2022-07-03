package com.example.kpacksinsets.controller;

import com.example.kpacksinsets.dto.request.KnowledgePackageRequestDto;
import com.example.kpacksinsets.dto.response.KnowledgePackageResponseDto;
import com.example.kpacksinsets.service.KnowledgePackageService;
import com.example.kpacksinsets.service.mapper.KnowledgePackageDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kpacks")
public class KnowledgePackController {
    private final KnowledgePackageService knowledgePackageService;
    private final KnowledgePackageDtoMapper knowledgePackageDtoMapper;

    public KnowledgePackController(KnowledgePackageService knowledgePackageService,
                                   KnowledgePackageDtoMapper knowledgePackageDtoMapper) {
        this.knowledgePackageService = knowledgePackageService;
        this.knowledgePackageDtoMapper = knowledgePackageDtoMapper;
    }

    @PostMapping
    public KnowledgePackageResponseDto add(@Valid @RequestBody KnowledgePackageRequestDto
                                                       knowledgePackage) {
        return knowledgePackageDtoMapper.toDto(knowledgePackageService
                .add(knowledgePackageDtoMapper.toModel(knowledgePackage)));
    }

    @GetMapping
    public List<KnowledgePackageResponseDto> getAll() {
        return knowledgePackageService.getAll()
                .stream()
                .map(knowledgePackageDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
