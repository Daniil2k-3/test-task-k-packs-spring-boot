package com.example.kpacksinsets.dto.response;

import java.util.Set;

public class KnowledgePackageSetResponseDto {
    private Long id;
    private String title;
    private Set<Long> knowledgePackageIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Long> getKnowledgePackageIds() {
        return knowledgePackageIds;
    }

    public void setKnowledgePackageIds(Set<Long> knowledgePackageIds) {
        this.knowledgePackageIds = knowledgePackageIds;
    }
}
