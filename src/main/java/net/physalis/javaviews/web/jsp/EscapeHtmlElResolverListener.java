package net.physalis.javaviews.web.jsp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.jsp.JspFactory;

@WebListener
public class EscapeHtmlElResolverListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JspFactory
                .getDefaultFactory()
                .getJspApplicationContext(sce.getServletContext())
                .addELResolver(new EscapeHtmlElResolver());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
