package net.physalis.javaviews.web.velocity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class VelocityConfig {

    @Bean
    public VelocityConfigurer velocityConfigurator() {
        VelocityConfigurer c = new VelocityConfigurer();

        Map<String, Object> map = new HashMap<>();
        map.put("input.encoding", "utf-8");
        map.put("eventhandler.referenceinsertion.class", MyRefrenceInsertionEventHandler.class.getName());
        c.setVelocityPropertiesMap(map);

        c.setResourceLoaderPath("/WEB-INF/velocity/");
        return c;
    }

    @Bean
    public ViewResolver velocityViewResolver() {
        VelocityLayoutViewResolver r = new VelocityLayoutViewResolver();
        r.setViewClass(VelocityLayoutView.class);
        r.setPrefix("");
        r.setSuffix(".vm");
        r.setContentType("text/html; charset=utf-8");
        r.setCache(false);
        r.setOrder(99);
        return r;
    }

}
