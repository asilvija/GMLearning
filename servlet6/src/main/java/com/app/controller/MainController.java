package com.app.controller;

import com.app.view.Layout;

public class MainController implements Controller {
    private final String _path ="/course/create";

    @Override
    public boolean handles(String route) {
        return _path.equals(route);
    }

    @Override
    public void execute(Context context) throws Exception {
        context.response().setContentType("text/html");
        context.response().setCharacterEncoding("UTF-8");
        context.response().getWriter().write(new Layout().buildHtml().render());
    }
}
