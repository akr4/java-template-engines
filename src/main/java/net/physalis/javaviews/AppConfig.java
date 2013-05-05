package net.physalis.javaviews;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@ComponentScan(
        basePackages = {
                "net.physalis.javaviews.domain",
                "net.physalis.javaviews.infrastructure",
        })
@PropertySource("classpath:/app.properties")
public class AppConfig {

    @Bean
    public org.springframework.context.MessageSource messageSource() {
        ReloadableResourceBundleMessageSource mr = new ReloadableResourceBundleMessageSource();
        mr.setBasename("WEB-INF/messages");
        mr.setCacheSeconds(0);
        return mr;
    }
}
