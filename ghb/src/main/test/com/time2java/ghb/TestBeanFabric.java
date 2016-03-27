package com.time2java.ghb;

import com.time2java.ghb.template.TemplateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by time2die on 20.03.16.
 */
@Configuration
public class TestBeanFabric {
    @Bean
    public TemplateService templateService() {
        return new TemplateService();
    }
}
