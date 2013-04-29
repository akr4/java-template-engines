package net.physalis.javaviews.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class SelectTemplateViewResolver implements ViewResolver, Ordered {

    @Override
    public View resolveViewName(String templateEngineIdAndViewName, Locale locale) throws Exception {
        String templateEngineId = extractTemplateName(templateEngineIdAndViewName);
        String viewName = extractViewName(templateEngineIdAndViewName);

        LOGGER.trace("template: {}, view: {}, locale: {}", templateEngineId, viewName, locale);

        ViewResolver viewResolver = applicationContext.getBean(beanName(templateEngineId), ViewResolver.class);
        return viewResolver.resolveViewName(viewName, locale);
    }


    private static final Logger LOGGER = LoggerFactory.getLogger(SelectTemplateViewResolver.class);

    @Autowired
    private ApplicationContext applicationContext;

    private String beanName(String templateEngineId) {
        return templateEngineId + "ViewResolver";
    }

    private String extractTemplateName(String templateAndViewName) {
        return templateAndViewName.split("@")[0];
    }

    private String extractViewName(String templateAndViewName) {
        return templateAndViewName.split("@")[1];
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
