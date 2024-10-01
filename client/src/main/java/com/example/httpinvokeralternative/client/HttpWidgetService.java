package com.example.httpinvokeralternative.client;

import org.example.httpinvokeralternative.library.Widget;
import org.example.httpinvokeralternative.library.WidgetService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

public interface HttpWidgetService extends WidgetService {

    @GetExchange
    List<Widget> listWidgets();

    @PostExchange
    long createWidget(@RequestParam("name") String name,
                      @RequestParam("width") int width,
                      @RequestParam("height") int height);
}
