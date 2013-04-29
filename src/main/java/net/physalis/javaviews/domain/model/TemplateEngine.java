package net.physalis.javaviews.domain.model;

public enum TemplateEngine {
    JSP("jsp", "JSP"),
    Velocity("velocity", "Velocity"),
    FreeMarker("freemarker", "FreeMarker"),
    Handlebars("handlebars", "Handlebars"),
    Scalate("scalate", "Scalate") {
        @Override
        public String viewName(String viewName) {
            return getId() + "@layout:" + viewName;
        }
    }

    ;

    public static TemplateEngine findById(String id) {
        for (TemplateEngine e : values()) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    private TemplateEngine(java.lang.String id, java.lang.String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    /** "EngineName" to avoid conflict with name() */
    public String getEngineName() {
        return name;
    }

    public String viewName(String viewName) {
        return id + "@" + viewName;
    }


    private String id;
    private String name;
}
