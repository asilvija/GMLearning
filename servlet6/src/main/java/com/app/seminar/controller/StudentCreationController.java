package com.app.seminar.controller;

import static com.app.seminar.model.Student.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.Context;
import com.app.controller.Controller;
import com.app.seminar.model.Student;
import com.app.seminar.model.mapper.StudentMapper;
import com.app.seminar.view.FeedBack;
import com.app.seminar.view.Form;
import com.app.seminar.view.Html;
import com.app.seminar.view.Layout;

public class StudentCreationController implements Controller {
    
    private final String _path = "/student/create";

    @Override
    public boolean handles(String route) {
        return _path.equals(route);
    }

    @Override
    public void execute(Context context) throws Exception {
        context.response().setContentType("text/html");
        context.response().setCharacterEncoding("UTF-8");
        
        if (context.post()) { 
            final Student student = new Student(context.requestMap());
            new StudentMapper(context.connection()).save(student);
            context.response().sendRedirect("/student");
        } else {       
            viewForm(context);
        }
    }

    private void viewForm(Context context) throws IOException {

        FeedBack feedBack = new FeedBack();
        List<String> components = Arrays.asList(FIRST_NAME, LAST_NAME, ID);
        Html form = new Form(feedBack,"create", components, "id");
        context.response().getWriter().write(new Layout("create student", form).build().render());
    }
}
