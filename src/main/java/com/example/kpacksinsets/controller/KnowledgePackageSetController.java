package com.example.kpacksinsets.controller;

import com.example.kpacksinsets.dto.request.KnowledgePackageSetRequestDto;
import com.example.kpacksinsets.dto.response.KnowledgePackageResponseDto;
import com.example.kpacksinsets.dto.response.KnowledgePackageSetResponseDto;
import com.example.kpacksinsets.service.KnowledgePackageSetService;
import com.example.kpacksinsets.service.mapper.KnowledgePackageDtoMapper;
import com.example.kpacksinsets.service.mapper.KnowledgePackageSetDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KnowledgePackageSetController {
    private static final String PAGE = "0";
    private static final String SIZE = "20";
    private static final String SORT = "title";
    private final KnowledgePackageSetService knowledgePackageSetService;
    private final KnowledgePackageSetDtoMapper knowledgePackageSetDtoMapper;
    private final KnowledgePackageDtoMapper knowledgePackageDtoMapper;

    public KnowledgePackageSetController(KnowledgePackageSetService knowledgePackageSetService,
                                         KnowledgePackageSetDtoMapper
                                                 knowledgePackageSetDtoMapper,
                                         KnowledgePackageDtoMapper knowledgePackageDtoMapper) {
        this.knowledgePackageSetService = knowledgePackageSetService;
        this.knowledgePackageSetDtoMapper = knowledgePackageSetDtoMapper;
        this.knowledgePackageDtoMapper = knowledgePackageDtoMapper;
    }

    @PostMapping("/sets")
    public KnowledgePackageSetResponseDto add(@Valid @RequestBody KnowledgePackageSetRequestDto
                                                          requestDto) {
        return knowledgePackageSetDtoMapper.toDto(knowledgePackageSetService
                .add(knowledgePackageSetDtoMapper.toModel(requestDto)));
    }

    @GetMapping("/sets")
    public List<KnowledgePackageSetResponseDto> getAll(@RequestParam(defaultValue = SIZE) int size,
                                                       @RequestParam(defaultValue = PAGE) int page,
                                                       @RequestParam(defaultValue = SORT)
                                                           String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return knowledgePackageSetService.getAll(pageable)
                .stream()
                .map(knowledgePackageSetDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/set/{id}")
    public List<KnowledgePackageResponseDto> get(@PathVariable Long id) {
        return knowledgePackageSetService.get(id).getKnowledgePackages()
                .stream()
                .map(knowledgePackageDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/sets/by-title")
    public KnowledgePackageSetResponseDto getByTitle(@RequestParam String title) {
        return knowledgePackageSetDtoMapper.toDto(knowledgePackageSetService.get(title));
    }

    @DeleteMapping("sets/{id}")
    public void delete(@PathVariable Long id) {
        knowledgePackageSetService.delete(id);
    }
}
