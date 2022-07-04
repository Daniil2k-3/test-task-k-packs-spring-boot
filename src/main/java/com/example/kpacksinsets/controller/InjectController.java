package com.example.kpacksinsets.controller;

import com.example.kpacksinsets.model.KnowledgePackage;
import com.example.kpacksinsets.model.KnowledgePackageSet;
import com.example.kpacksinsets.service.KnowledgePackageService;
import com.example.kpacksinsets.service.KnowledgePackageSetService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectController {
    private final KnowledgePackageService knowledgePackageService;
    private final KnowledgePackageSetService knowledgePackageSetService;

    public InjectController(KnowledgePackageService knowledgePackageService,
                            KnowledgePackageSetService knowledgePackageSetService) {
        this.knowledgePackageService = knowledgePackageService;
        this.knowledgePackageSetService = knowledgePackageSetService;
    }

    @GetMapping
    public void inject() {
        KnowledgePackage knowledgePackage1 = new KnowledgePackage();
        knowledgePackage1.setTitle("K-pack1");
        knowledgePackage1.setDescription("Description of package");
        knowledgePackage1.setCreationTime("01.01.2022");
        knowledgePackageService.add(knowledgePackage1);

        KnowledgePackage knowledgePackage2 = new KnowledgePackage();
        knowledgePackage2.setTitle("K-pack2");
        knowledgePackage2.setDescription("Description of package");
        knowledgePackage2.setCreationTime("01.01.2022");
        knowledgePackageService.add(knowledgePackage2);

        KnowledgePackage knowledgePackage3 = new KnowledgePackage();
        knowledgePackage3.setTitle("K-pack3");
        knowledgePackage3.setDescription("Description of package");
        knowledgePackage3.setCreationTime("01.01.2022");
        knowledgePackageService.add(knowledgePackage3);

        KnowledgePackageSet knowledgePackageSet = new KnowledgePackageSet();
        knowledgePackageSet.setTitle("Set");
        Set<KnowledgePackage> set = new HashSet<>();
        set.add(knowledgePackage1);
        set.add(knowledgePackage2);
        set.add(knowledgePackage3);
        knowledgePackageSet.setKnowledgePackages(set);
        knowledgePackageSetService.add(knowledgePackageSet);

        KnowledgePackage knowledgePackage4 = new KnowledgePackage();
        knowledgePackage4.setTitle("X-pack");
        knowledgePackage4.setDescription("Description");
        knowledgePackage4.setCreationTime("03.01.2022");
        knowledgePackageService.add(knowledgePackage4);
        KnowledgePackage knowledgePackage5 = new KnowledgePackage();
        knowledgePackage5.setTitle("F-pack");
        knowledgePackage5.setDescription("Description");
        knowledgePackage5.setCreationTime("05.02.2022");
        knowledgePackageService.add(knowledgePackage5);

        KnowledgePackageSet knowledgePackageSet2 = new KnowledgePackageSet();
        knowledgePackageSet2.setTitle("A Set 2");
        Set<KnowledgePackage> set2 = new HashSet<>();
        set2.add(knowledgePackage3);
        set2.add(knowledgePackage4);
        set2.add(knowledgePackage5);
        knowledgePackageSet2.setKnowledgePackages(set2);
        knowledgePackageSetService.add(knowledgePackageSet2);
    }
}
