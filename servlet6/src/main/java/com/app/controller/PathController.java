package com.app.controller;

import java.util.regex.Pattern;

import com.app.seminar.NoPageFound;

public class PathController implements Controller {

    @Override
    public boolean handles(String route) {
        
        return !Pattern.matches(".*/course$", route) &&
               !Pattern.matches(".*/course/create$", route);
    }

    @Override
    public void execute(Context context) throws Exception {
        context.response().setContentType("text/html");
        context.response().setCharacterEncoding("UTF-8");
        context.response().getWriter().write(new NoPageFound().renderHtmlLayout());
    }

}
