package org.example.httpinvokeralternative.server;

import org.example.httpinvokeralternative.library.WidgetService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

@Configuration
public class HttpInvokerRegistrations {

    @Bean(name = "/widget")
    public HttpInvokerServiceExporter widgetServiceExporter(WidgetService svc) {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(svc);
        exporter.setServiceInterface(WidgetService.class);
        return exporter;
    }
}
