package com.app.seminar.controller;

import static com.app.seminar.model.Course.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.Context;
import com.app.controller.Controller;
import com.app.seminar.model.Course;
import com.app.seminar.model.mapper.CourseMapper;
import com.app.seminar.view.Component;
import com.app.seminar.view.FeedBack;
import com.app.seminar.view.Form;
import com.app.seminar.view.Html;
import com.app.seminar.view.Layout;

public class CourseUpdateController implements Controller {
    @Override
    public boolean handles(String route) {
      return Pattern.matches("^(/course/)[\\d]+$", route) || Pattern.matches("^(/course/update)$", route);
    }

    @Override
    public void execute(Context context) throws Exception {
        
        if (context.post()) {    
            final Course course = new Course(context.requestMap());
            new CourseMapper(context.connection()).save(course);
            context.response().sendRedirect("/");
 
        } else {
            String courseId = context.requestUri().replaceAll("\\D", "");
            final Course course = new CourseMapper(context.connection()).findById(courseId);
            
            Map<String, Component> map = new HashMap<String, Component>(){{
                put(Course.ID , new Component(course.getId().toString()));
                put(Course.NAME , new Component(course.getName()));
                put(Course.LOCATION , new Component(course.getLocation()));
                put(Course.START , new Component(course.getStartDate()));
                put(Course.TOTAL_SEATS , new Component(course.getTotalSeats().toString()));
            }};
            
            FeedBack feedBack = new FeedBack(map);
            List<String> components = Arrays.asList(NAME, START, LOCATION, TOTAL_SEATS, ID);
            Html form = new Form(feedBack,"", components, "id");
            context.response().getWriter().write(new Layout("update course", form).build().render());
        }
    }
}
