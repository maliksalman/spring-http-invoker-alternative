package org.example.httpinvokeralternative.library;

import java.io.Serializable;

public record Widget(
        long id,
        String name,
        int width,
        int height
) implements Serializable { }
