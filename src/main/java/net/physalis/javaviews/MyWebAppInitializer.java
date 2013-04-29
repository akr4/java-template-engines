package net.physalis.javaviews;

import net.physalis.javaviews.web.WebConfig;
import net.physalis.javaviews.web.jsp.EscapeHtmlElResolver;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MyWebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) {
        root(container);
        web(container);
    }


    private void root(ServletContext container) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);
        container.addListener(new ContextLoaderListener(rootContext));
    }

    private void web(ServletContext container) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        ServletRegistration.Dynamic servlet =
                container.addServlet("webServlet", new DispatcherServlet(context));
        servlet.addMapping("/app/*");
    }
}
