package com.app.controller;

import com.app.seminar.SeminarDetails;

public class CsvController implements Controller {
    private final String _path;

    public CsvController() {
        _path = "/course/csv";
    }

    @Override
    public boolean handles(String route) {
        return _path.equals(route);
    }

    @Override
    public void execute(Context context) throws Exception {
//        context.response().setContentType("text/csv");
        context.response().setCharacterEncoding("UTF-8");
        context.response().getWriter().write(new SeminarDetails().renderCsv());
    }

}
