package com.example.kpacksinsets.controller;

import com.example.kpacksinsets.dto.request.KnowledgePackageSetRequestDto;
import com.example.kpacksinsets.dto.response.KnowledgePackageSetResponseDto;
import com.example.kpacksinsets.service.KnowledgePackageService;
import com.example.kpacksinsets.service.KnowledgePackageSetService;
import com.example.kpacksinsets.service.mapper.KnowledgePackageSetDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class KnowledgePackageSetController {
    private final KnowledgePackageSetService knowledgePackageSetService;
    private final KnowledgePackageSetDtoMapper knowledgePackageSetDtoMapper;
    private final KnowledgePackageService knowledgePackageService;

    public KnowledgePackageSetController(KnowledgePackageSetService knowledgePackageSetService,
                                         KnowledgePackageSetDtoMapper
                                                 knowledgePackageSetDtoMapper,
                                         KnowledgePackageService knowledgePackageService) {
        this.knowledgePackageSetService = knowledgePackageSetService;
        this.knowledgePackageSetDtoMapper = knowledgePackageSetDtoMapper;
        this.knowledgePackageService = knowledgePackageService;
    }

    @PostMapping("/sets")
    public KnowledgePackageSetResponseDto add(@Valid @RequestBody KnowledgePackageSetRequestDto requestDto) {
        return knowledgePackageSetDtoMapper.toDto(knowledgePackageSetService
                .add(knowledgePackageSetDtoMapper.toModel(requestDto)));
    }

    @GetMapping("/sets")
    public List<KnowledgePackageSetResponseDto> getAll() {
        return knowledgePackageSetService.getAll()
                .stream()
                .map(knowledgePackageSetDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/set/{id}")
    public KnowledgePackageSetResponseDto get(@PathVariable Long id) {
        return knowledgePackageSetDtoMapper.toDto(knowledgePackageSetService.get(id));
    }
}
