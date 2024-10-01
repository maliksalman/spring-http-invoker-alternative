package com.example.httpinvokeralternative.client;

import org.example.httpinvokeralternative.library.Widget;
import org.example.httpinvokeralternative.library.WidgetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableScheduling
public class Application  {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private WidgetService widgetService;

    public Application(WidgetService widgetService) {
        this.widgetService = widgetService;
    }

    @Scheduled(fixedDelay = 5_000)
    public void doWork() {

        String newWidgetName = UUID.randomUUID().toString();
        logger.info("Creating new widget: Name={}", newWidgetName);
        long id = widgetService.createWidget(newWidgetName,
                100,
                100);

        List<Widget> widgets = widgetService.listWidgets();
        Set<Long> ids = widgets.stream()
                .map(w -> w.id())
                .collect(Collectors.toSet());

        logger.info("All widgets: Ids={}", StringUtils.arrayToCommaDelimitedString(ids.toArray()));
    }
}
