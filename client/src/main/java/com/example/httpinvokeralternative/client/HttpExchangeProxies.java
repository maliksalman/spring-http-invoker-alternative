package com.example.httpinvokeralternative.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpExchangeProxies {

    @Bean
    public HttpWidgetService httpWidgetService(@Value("${service-urls.widget}") String url) {
        return HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(RestClient.create(url))).build()
                .createClient(HttpWidgetService.class);
    }
}
