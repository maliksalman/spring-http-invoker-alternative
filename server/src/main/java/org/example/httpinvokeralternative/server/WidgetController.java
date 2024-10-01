package org.example.httpinvokeralternative.server;

import org.example.httpinvokeralternative.library.Widget;
import org.example.httpinvokeralternative.library.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/widget")
public class WidgetController {

    private final WidgetService widgetService;

    public WidgetController(WidgetService widgetService) {
        this.widgetService = widgetService;
    }

    @GetMapping
    public List<Widget> listWidgets() {
        return widgetService.listWidgets();
    }

    @PostMapping
    public long createWidget(@RequestParam("name") String name,
                             @RequestParam("width") int width,
                             @RequestParam("height") int height) {
        return widgetService.createWidget(name, width, height);
    }
}
