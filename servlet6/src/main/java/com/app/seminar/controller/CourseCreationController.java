package com.app.seminar.controller;

import static com.app.seminar.model.Course.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.Context;
import com.app.controller.Controller;
import com.app.seminar.model.Course;
import com.app.seminar.model.mapper.CourseMapper;
import com.app.seminar.view.FeedBack;
import com.app.seminar.view.Form;
import com.app.seminar.view.Html;
import com.app.seminar.view.Layout;

public class CourseCreationController implements Controller {
    
    private final String _path = "/course/create";

    @Override
    public boolean handles(String route) {
        return _path.equals(route);
    }

    @Override
    public void execute(Context context) throws Exception {
        context.response().setContentType("text/html");
        context.response().setCharacterEncoding("UTF-8");
        
        if (context.post()) { 
            final Course course = new Course(context.requestMap());
            new CourseMapper(context.connection()).save(course);
            context.response().sendRedirect("/");
        } else {       
            viewForm(context);
        }
    }

    private void viewForm(Context context) throws IOException {

        FeedBack feedBack = new FeedBack();
        List<String> components = Arrays.asList(NAME, START, LOCATION, TOTAL_SEATS, ID);
        Html form = new Form(feedBack,"create", components, "id");
        context.response().getWriter().write(new Layout("create course", form).build().render());
    }
}
