package com.app.controller;

public class MainController implements Controller {
    private final String _path;
//    private final String _type;

    public MainController(String path) {
        _path = "/course/" + path;
//        _type = path;
    }

    @Override
    public boolean handles(String route) {
        return _path.equals(route);
    }

    @Override
    public void execute(Context context) throws Exception {
        context.response().setContentType("text/html");
        context.response().setCharacterEncoding("UTF-8");
//        context.response().getWriter().write(new SeminarDetails().render(_type));
    }
}
