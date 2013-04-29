package net.physalis.javaviews.web.scalate;

import org.fusesource.scalate.spring.view.ScalateViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

@Configuration
public class ScalateConfig {

    @Bean
    public ViewResolver scalateViewResolver() {
        ScalateViewResolver r = new ScalateViewResolver();
        r.setPrefix("/WEB-INF/scalate/");
        r.setSuffix(".ssp");
        r.setContentType("text/html; charset=utf-8");
        r.setOrder(99);
        return r;
    }
}
