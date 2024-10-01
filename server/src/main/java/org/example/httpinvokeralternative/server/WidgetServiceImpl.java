package org.example.httpinvokeralternative.server;

import org.example.httpinvokeralternative.library.Widget;
import org.example.httpinvokeralternative.library.WidgetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WidgetServiceImpl implements WidgetService {

    private static final Logger logger = LoggerFactory.getLogger(WidgetServiceImpl.class);

    private Map<Long, Widget> widgets = new HashMap<>();
    private long nextId;

    @Override
    public List<Widget> listWidgets() {
        return new ArrayList<>(widgets.values());
    }

    @Override
    public long createWidget(String name, int width, int height) {

        Widget w = new Widget(nextId,
                name,
                width,
                height);

        widgets.put(Long.valueOf(w.id()), w);
        logger.info("Widget created: Id={}, Name={}", w.id(), w.name());

        return nextId++;
    }
}
