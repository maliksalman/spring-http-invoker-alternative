package org.example.httpinvokeralternative.library;

import java.util.List;

public interface WidgetService {

    List<Widget> listWidgets();
    long createWidget(String name, int width, int height);
}
