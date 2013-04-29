package net.physalis.javaviews.web.velocity;

import net.physalis.javaviews.web.SafeHtml;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.velocity.app.event.ReferenceInsertionEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyRefrenceInsertionEventHandler implements ReferenceInsertionEventHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyRefrenceInsertionEventHandler.class);

    @Override
    public Object referenceInsert(String reference, Object value) {
        LOGGER.trace("reference: {}, value {}", reference, value);
        if (value == null) {
            return null;
        } else if (reference.endsWith("NoEscape") || reference.endsWith("NoEscape}")) {
            // $screen_content is used by VelocityLayoutView
            return value;
        } else if (reference.equals("$screen_content") || reference.equals("${screen_content}")) {
            // $screen_content is used by VelocityLayoutView
            return value;
        } else if (value instanceof SafeHtml) {
            return ((SafeHtml) value).getSafeHtmlValue();
        } else {
            return StringEscapeUtils.escapeHtml4(value.toString());
        }
    }
}
