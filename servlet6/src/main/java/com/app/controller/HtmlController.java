package com.app.controller;

import com.app.seminar.SeminarDetails;

public class HtmlController implements Controller {

    @Override
    public boolean handles(String route) {
        return route.contains("/html");
    }

    @Override
    public void execute(Context context) throws Exception {

        context.response().setContentType("text/html");
        context.response().setCharacterEncoding("UTF-8");
        context.response().getWriter().write(new SeminarDetails(courseNameFromUri(context)).renderHtml());
 
    }

    private String courseNameFromUri(Context context) {
        String uri = context.request().getRequestURI();
        String courseName = uri;
        courseName = uri.substring(uri.indexOf("/") + 1, uri.lastIndexOf("/"));
        courseName = courseName.substring(0, 1).toUpperCase() + courseName.substring(1);
        return courseName;
    }
}
