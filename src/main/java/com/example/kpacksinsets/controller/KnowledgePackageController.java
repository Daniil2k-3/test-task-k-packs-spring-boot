package com.example.kpacksinsets.controller;

import com.example.kpacksinsets.dto.request.KnowledgePackageRequestDto;
import com.example.kpacksinsets.dto.response.KnowledgePackageResponseDto;
import com.example.kpacksinsets.service.KnowledgePackageService;
import com.example.kpacksinsets.service.mapper.KnowledgePackageDtoMapper;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kpacks")
public class KnowledgePackageController {
    private static final String PAGE = "0";
    private static final String SIZE = "20";
    private static final String SORT = "title";
    private final KnowledgePackageService knowledgePackageService;
    private final KnowledgePackageDtoMapper knowledgePackageDtoMapper;

    public KnowledgePackageController(KnowledgePackageService knowledgePackageService,
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
    public List<KnowledgePackageResponseDto> getAll(@RequestParam(defaultValue = SIZE) int size,
                                                    @RequestParam(defaultValue = PAGE) int page,
                                                    @RequestParam(defaultValue = SORT)
                                                        String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return knowledgePackageService.getAll(pageable)
                .stream()
                .map(knowledgePackageDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        knowledgePackageService.delete(id);
    }

    @GetMapping("/by-title")
    public KnowledgePackageResponseDto getByTitle(@RequestParam String title) {
        return knowledgePackageDtoMapper.toDto(knowledgePackageService.getByTitle(title));
    }

    @GetMapping("/by-date")
    public List<KnowledgePackageResponseDto> getByDate(@RequestParam String date) {
        return knowledgePackageService.getByDate(date)
                .stream()
                .map(knowledgePackageDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
