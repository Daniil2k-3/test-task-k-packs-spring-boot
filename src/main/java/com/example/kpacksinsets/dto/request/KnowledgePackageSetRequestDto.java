package com.example.kpacksinsets.dto.request;

import java.util.Set;
import lombok.Data;

@Data
public class KnowledgePackageSetRequestDto {
    private String title;
    private Set<Long> knowledgePackageIds;
}
