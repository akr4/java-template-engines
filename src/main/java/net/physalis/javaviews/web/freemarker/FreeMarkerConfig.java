package net.physalis.javaviews.web.freemarker;

import com.google.common.io.CharStreams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.SpringTemplateLoader;
import org.springframework.web.context.support.ServletContextResourceLoader;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

@Configuration
public class FreeMarkerConfig {

    @Autowired
    private ServletContext servletContext;

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() throws IOException {
        FreeMarkerConfigurer c = new FreeMarkerConfigurer();
        c.setPreTemplateLoaders(new SpringTemplateLoader(new ServletContextResourceLoader(servletContext), "/WEB-INF/freemarker/") {
            @Override
            public Reader getReader(Object templateSource, String encoding) throws IOException {
                String s = CharStreams.toString(super.getReader(templateSource, encoding));
                return new StringReader("<#escape x as x?html>" + s + "</#escape>");
            }
        });
        // TODO: auto import layout.ftl
        return c;
    }

    @Bean
    public org.springframework.web.servlet.ViewResolver freemarkerViewResolver() {
        FreeMarkerViewResolver r = new FreeMarkerViewResolver();
        r.setPrefix("");
        r.setSuffix(".ftl");
        r.setContentType("text/html; charset=utf-8");
        r.setCache(true);
        r.setOrder(99);
        return r;
    }
}
