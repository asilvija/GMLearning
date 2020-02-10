package com.app.controller;

import java.util.HashMap;

import com.app.seminar.Course;
import com.app.seminar.Seminar;
import com.app.seminar.Store;
import com.app.view.CustomFormLayout;
import com.app.view.HtmlPage;

public class SeminarCreationController implements Controller {
    
    private final String _path = "/course/create";

    @Override
    public boolean handles(String route) {
        return _path.equals(route);
    }

    @Override
    public void execute(Context context) throws Exception {
        context.response().setContentType("text/html");
        context.response().setCharacterEncoding("UTF-8");
        
//        FormLayout form = new FormLayout("Seminar", formFields());
        if (context.isPost()) {           
            Seminar seminar = new Seminar(
                context.request().getParameter("location"), 
                Integer.parseInt(context.request().getParameter("totalseats")),
                new Course("23", context.request().getParameter("name"), 
                           "A1", context.request().getParameter("startdate")));
            
            new Store().writeOnFile(seminar.renderCsv(), context.request().getParameter("name"));
            context.response().sendRedirect("/course");
//            form.withInfo(context.request().getParameter("name") + " is created!");
        }

        
        CustomFormLayout customFormLayout = new CustomFormLayout();
        customFormLayout.insertRow();
        customFormLayout.defaultInputField("name", "Name", "Name", "required", new HashMap<String, String>(){{
            put("invalid-feedback", "Please insert name.");
        }});
        customFormLayout.datePickerInputField("startdate", "Start Date", "required", new HashMap<String, String>(){{
            put("invalid-feedback", "Please insert start date.");
        }});
        customFormLayout.defaultInputField("location", "Location", "Location", "required", new HashMap<String, String>(){{
            put("invalid-feedback", "Please insert Location.");
        }});
        customFormLayout.numericInputField("totalseats", "Total Seats", "Total Seats",null, "1", null, "required",new HashMap<String, String>(){{
            put("invalid-feedback", "Please insert seats.");
        }});
        customFormLayout.numericInputField("number", "Number", "Number", "0","1", null, "", new HashMap<String, String>(){{
            put("numfeed", "Please insert num < total seats");
        }});
        customFormLayout.addSubmitButton("submit");

        context.response().getWriter().write(new HtmlPage(customFormLayout).render());
    }

}
