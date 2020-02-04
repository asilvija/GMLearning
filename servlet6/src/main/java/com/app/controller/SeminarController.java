package com.app.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.seminar.Course;
import com.app.seminar.Seminar;
import com.app.seminar.Store;
import com.app.view.FormLayout;

public class SeminarController implements Controller {
    
    private final String _path = "/course/create";

    @Override
    public boolean handles(String route) {
        return (_path.equals(route)|| _path.equals(route));
    }

    @Override
    public void execute(Context context) throws Exception {
        context.response().setContentType("text/html");
        context.response().setCharacterEncoding("UTF-8");
        
        FormLayout form = new FormLayout("Seminar", formFields());
        if (context.isPost()) {           
            Seminar seminar = new Seminar(context.request().getParameter("location"), 12,
                new Course("23", context.request().getParameter("name"), "A1", "23/02/2020"));
            new Store().writeOnFile(seminar.renderCsv(), context.request().getParameter("name"));
            form.withInfo(context.request().getParameter("name") + " is created!");
        }
        context.response().getWriter().write(form.buildHtml().render());
    }
    
    private ArrayList<HashMap<String, String>> formFields() {
        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        
        HashMap<String, String> map = new HashMap<String, String>() {{
            put("Course Name", "name");
            put("Location", "location");
        }};

        data.add(map);
        return data;
    }
}
