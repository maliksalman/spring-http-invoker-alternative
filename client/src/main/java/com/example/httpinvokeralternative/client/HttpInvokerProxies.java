package com.example.httpinvokeralternative.client;

import org.example.httpinvokeralternative.library.WidgetService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

@Configuration
public class HttpInvokerProxies {

    @Bean
    public HttpInvokerProxyFactoryBean widgetService(@Value("${service-urls.widget}") String url) {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(url);
        invoker.setServiceInterface(WidgetService.class);
        return invoker;
    }
}
