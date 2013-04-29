package net.physalis.javaviews.web.jsp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class JspConfig {

    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver r = new InternalResourceViewResolver();
        r.setViewClass(JstlView.class);
        r.setPrefix("/WEB-INF/jsp/");
        r.setSuffix(".jsp");
        r.setContentType("text/html; charset=utf-8");
        r.setOrder(99);
        return r;
    }

}
