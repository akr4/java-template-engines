package net.physalis.javaviews.domain.model;

import com.github.jknack.handlebars.Handlebars;
import net.physalis.javaviews.web.SafeHtml;

public class WikiText implements SafeHtml {

    public WikiText(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * for Velocity
     */
    public String getValueNoEscape() {
        return value;
    }

    @Override
    public String getSafeHtmlValue() {
        return value;
    }

    @Override
    public String toString() {
        // some template engines use toString() to render object without escape.
        // so it would be dengerous when return value includes html unsafe characters.
        return value;
    }

    /**
     * for Handlebars
     */
    public Handlebars.SafeString getHandlebarsSafeString() {
        return new Handlebars.SafeString(getSafeHtmlValue());
    }


    private final String value;
}
