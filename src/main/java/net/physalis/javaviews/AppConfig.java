package net.physalis.javaviews;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(
        basePackages = {
                "net.physalis.javaviews.domain",
                "net.physalis.javaviews.infrastructure",
        })
@PropertySource("classpath:/app.properties")
public class AppConfig {
}
