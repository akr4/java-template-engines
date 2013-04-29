package net.physalis.javaviews.web.jsp;

import net.physalis.javaviews.web.SafeHtml;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.PageContext;
import java.beans.FeatureDescriptor;
import java.util.Enumeration;
import java.util.Iterator;

public class EscapeHtmlElResolver extends ELResolver {

    public static final String NO_ESCAPE_KEY = EscapeHtmlElResolver.class.getName() + ".noescape";

    @Override
    public Object getValue(ELContext context, Object base, Object property) {
        JspContext jspContext = (JspContext) context.getContext(JspContext.class);
        Boolean noescape = (Boolean) jspContext.findAttribute(NO_ESCAPE_KEY);
        if ((noescape != null && noescape)) {
            return null;
        }

        if (processing.get()) {
            return null;
        }

        try {
            processing.set(true);
            LOGGER.trace("base({}), property({})", base, property);
            Object value = context.getELResolver().getValue(context, base, property);

            if (value instanceof String) {
                String escaped = escape((String) value);
                LOGGER.trace("escape {}", escaped);
                return escaped;
            } else if (value instanceof SafeHtml) {
                String html = ((SafeHtml) value).getSafeHtmlValue();
                LOGGER.trace("safe html {}", html);
                context.setPropertyResolved(true);
                return html;
            } else {
                LOGGER.trace("property({}) = ({})", property, value);
                return value;
            }
        } finally {
            processing.set(false);
        }
    }

    @Override
    public Class<?> getType(ELContext context, Object base, Object property) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setValue(ELContext context, Object base, Object property, Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isReadOnly(ELContext context, Object base, Object property) {
        return true;
    }

    @Override
    public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Class<?> getCommonPropertyType(ELContext context, Object base) {
        throw new UnsupportedOperationException();
    }


    private static final Logger LOGGER = LoggerFactory.getLogger(EscapeHtmlElResolver.class);

    private ThreadLocal<Boolean> processing = new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };

    private String escape(String s) {
        return StringEscapeUtils.escapeHtml4(s);
    }
}
