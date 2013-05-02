package net.physalis.javaviews;

import net.physalis.javaviews.web.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.EnumSet;

public class MyWebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext context) {
        root(context);
        web(context);
        urlRewriteFilter(context);
    }


    private void root(ServletContext context) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);
        context.addListener(new ContextLoaderListener(rootContext));
    }

    private void web(ServletContext context) {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebConfig.class);

        ServletRegistration.Dynamic servlet =
                context.addServlet("webServlet", new DispatcherServlet(webContext));
        servlet.addMapping("/app/*");
    }

    private void urlRewriteFilter(ServletContext context) {
        FilterRegistration.Dynamic filter = context.addFilter("UrlRewriteFilter", new UrlRewriteFilter());
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), false, "/*");
    }
}
