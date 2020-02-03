package com.app.controller;

import com.app.seminar.SeminarDetails;

public class RawController implements Controller {

    @Override
    public boolean handles(String route) {
        return route.contains("/raw");
    }

    @Override
    public void execute(Context context) throws Exception {
        context.response().setCharacterEncoding("UTF-8");
        context.response().getWriter().write(new SeminarDetails(courseNameFromUri(context)).renderRaw());
    }

    private String courseNameFromUri(Context context) {
        String uri = context.request().getRequestURI();
        String courseName = uri;
        courseName = uri.substring(uri.indexOf("/") + 1, uri.lastIndexOf("/"));
        courseName = courseName.substring(0, 1).toUpperCase() + courseName.substring(1);
        return courseName;
    }
}
