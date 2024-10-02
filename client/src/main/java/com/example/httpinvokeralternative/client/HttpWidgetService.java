package com.example.httpinvokeralternative.client;

import org.example.httpinvokeralternative.library.Widget;
import org.example.httpinvokeralternative.library.WidgetService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class HttpWidgetService implements WidgetService {

    private final RestTemplate restTemplate;
    private final String baseUrl;

    public HttpWidgetService(@Value("${service-urls.widget}") String baseUrl) {
        this.baseUrl = baseUrl;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<Widget> listWidgets() {
        ParameterizedTypeReference<List<Widget>> typeRef = new ParameterizedTypeReference<List<Widget>>() {};
        return restTemplate
                .exchange(baseUrl, HttpMethod.GET, new HttpEntity<>(null), typeRef)
                .getBody();
    }

    @Override
    public long createWidget(String name, int width, int height) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl);
        uriBuilder.queryParam("name", name);
        uriBuilder.queryParam("width", width);
        uriBuilder.queryParam("height", height);

        return restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.POST, new HttpEntity<>(null), Long.class)
                .getBody();
    }
}
