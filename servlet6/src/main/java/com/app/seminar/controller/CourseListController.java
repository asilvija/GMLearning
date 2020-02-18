package com.app.seminar.controller;

import java.util.regex.Pattern;

import com.Context;
import com.app.controller.Controller;
import com.app.seminar.model.SeminarDetails;

public class CourseListController implements Controller {
//    private final String _path = "/course";

    @Override
    public boolean handles(String route) {
        return Pattern.matches("^(/course|/)$", route);
    }

    @Override
    public void execute(Context context) throws Exception {
        context.response().setContentType("text/html");
        context.response().setCharacterEncoding("UTF-8");
        context.response().getWriter().write(new SeminarDetails().renderHtmlSeminarList());
    }
}
