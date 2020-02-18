package com;

import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;

import com.app.controller.Controller;
import com.app.controller.NotFoundController;
import com.app.seminar.controller.CourseCreationController;
import com.app.seminar.controller.CourseListController;

public class SeminarFactory {

    public List<Controller> create() {
        return new ArrayList<Controller>(
            asList(
                new CourseCreationController(),
                new CourseListController(),
                new NotFoundController()
            )
        );
    }
}
