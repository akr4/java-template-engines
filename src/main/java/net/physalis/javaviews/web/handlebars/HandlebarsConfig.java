package net.physalis.javaviews.web.handlebars;

import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

@Configuration
public class HandlebarsConfig {

    @Bean
    public ViewResolver handlebarsViewResolver() {
        HandlebarsViewResolver r = new HandlebarsViewResolver();
        r.setPrefix("/WEB-INF/handlebars/");
        r.setSuffix(".hbs");
        r.setContentType("text/html; charset=utf-8");
        r.setCache(false);
        r.setOrder(99);
        return r;
    }

}
