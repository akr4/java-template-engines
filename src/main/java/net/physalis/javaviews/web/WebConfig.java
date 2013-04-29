package net.physalis.javaviews.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configurable
@ComponentScan
public class WebConfig extends WebMvcConfigurationSupport {

    @Bean
    public ViewResolver selectTemplateViewResolver() {
        return new SelectTemplateViewResolver();
    }

    @Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping m = super.requestMappingHandlerMapping();
        m.setRemoveSemicolonContent(false);
        m.setUseTrailingSlashMatch(false);
        return m;
    }


    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);
}
