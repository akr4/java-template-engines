package net.physalis.javaviews.web;

import net.physalis.javaviews.domain.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private final WikiPage WIKI_PAGE = new WikiPage(
            "<strong>Tokyo</strong>",
            new WikiText("<strong>Tokyo</strong> is the capital of Japan.")
    );

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView(TemplateEngine.Velocity.viewName("view/index"));
        mav.addObject("templateEngines", TemplateEngine.values());
        return mav;
    }


    @RequestMapping("/{templateEngineId}")
    public Object templateEngine(@PathVariable String templateEngineId) {
        TemplateEngine templateEngine = TemplateEngine.findById(templateEngineId);
        if (templateEngine == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        ModelAndView mav = new ModelAndView(templateEngine.viewName("view/main"));
        mav.addObject("navibarItemId", templateEngine.getId());
        mav.addObject("templateEngines", TemplateEngine.values());
        mav.addObject("wikiPage", WIKI_PAGE);
        return mav;
    }
}
