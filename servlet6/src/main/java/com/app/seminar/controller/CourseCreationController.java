package com.app.seminar.controller;

import java.io.IOException;
import java.util.HashMap;

import com.Context;
import com.app.controller.Controller;
import com.app.seminar.model.Course;
import com.app.seminar.model.Store;
import com.app.seminar.model.mapper.CourseMapper;
import com.app.seminar.view.FormLayout;
import com.app.seminar.view.HtmlPage;

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
            Course course = new Course(
                Integer.parseInt(context.request().getParameter("id")), 
                context.request().getParameter("name"), 
                "A1", context.request().getParameter("location"),
                Integer.parseInt(context.request().getParameter("totalseats")), 
                context.request().getParameter("startdate")
             );
            new CourseMapper(context.connection()).insert(course);
            new Store().writeOnFile(course.formatCsv(), context.request().getParameter("name"));
            context.response().sendRedirect("/course");
        } else {       
            viewForm(context);
        }
    }

    private void viewForm(Context context) throws IOException {
        FormLayout customFormLayout = new FormLayout();
        customFormLayout.insertRow();
        customFormLayout.defaultInputField("name", "Name", "Name", "required","15" ,new HashMap<String, String>(){{
            put("invalid-feedback", "Please insert name.");
            put("name", "Please insert text <= 15 chars.");
        }});
        customFormLayout.datePickerInputField("startdate", "Start Date", "required", new HashMap<String, String>(){{
            put("invalid-feedback", "Please insert start date.");
        }});
        customFormLayout.defaultInputField("location", "Location", "Location", "required", "20",new HashMap<String, String>(){{
            put("invalid-feedback", "Please insert location.");
            put("location", "Please insert text <= chars.");
        }});
        customFormLayout.numericInputField("id", "Id", "Id", null,"1", null, "required", new HashMap<String, String>(){{
            put("invalid-feedback","Please insert valid id.");
            put("id","Please insert valid id.");
        }});
        customFormLayout.numericInputField("totalseats", "Total Seats", "Total Seats",null, "1", null, "required",new HashMap<String, String>(){{
            put("invalid-feedback", "Please insert seats.");
            put("totalseats", "Please insert number < 100.");
        }});
        customFormLayout.addSubmitButton("submit");
        context.response().getWriter();
        context.response().getWriter().write(new HtmlPage(customFormLayout).render());
    }
}
