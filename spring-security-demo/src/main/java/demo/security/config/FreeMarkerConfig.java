package demo.security.config;

import demo.security.freemarker.MenuDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class FreeMarkerConfig {
    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    private MenuDirective menuDirective;

    @PostConstruct
    public void config() {
        configuration.setSharedVariable("menu", menuDirective);
    }
}
