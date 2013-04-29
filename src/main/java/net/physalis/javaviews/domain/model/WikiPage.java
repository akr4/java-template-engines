package net.physalis.javaviews.domain.model;

public class WikiPage {

    public WikiPage(String title, WikiText wikiText) {
        this.title = title;
        this.wikiText = wikiText;
    }

    public String getTitle() {
        return title;
    }

    public WikiText getWikiText() {
        return wikiText;
    }

    @Override
    public String toString() {
        return "WikiPage(" + title + ", " + wikiText + ")";
    }

    private final String title;
    private final WikiText wikiText;
}
