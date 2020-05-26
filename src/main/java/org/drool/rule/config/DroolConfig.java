package org.drool.rule.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.kie.api.builder.ReleaseId;

@Configuration
public class DroolConfig {
    @Value( "${drl.file.name}" )
    private String drlFileName;

    private KieServices services = KieServices.Factory.get();

    private KieFileSystem getKieFileSystem(){
        KieFileSystem kieFileSystem = services.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(drlFileName));
        return kieFileSystem;
    }

    @Bean
    public KieContainer getKieContainer(){

        getKieRepository();
        KieBuilder kieBuilder = services.newKieBuilder(getKieFileSystem());
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        KieContainer kieContainer = services.newKieContainer(kieModule.getReleaseId());

        return kieContainer;
    }

    private KieRepository getKieRepository(){
        final KieRepository kieRepository = services.getRepository();
        kieRepository.addKieModule(new KieModule() {
            @Override
            public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });
        return kieRepository;
    }

    @Bean
    public KieSession getKieSession(){
        return getKieContainer().newKieSession();
    }
}
