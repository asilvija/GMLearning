package com;

import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;

import com.app.controller.Controller;
import com.app.controller.PathController;
import com.app.controller.SeminarController;
import com.app.controller.SeminarListController;

public class ControllerFactory {

    public List<Controller> create() {
        return new ArrayList<Controller>(
            asList(
                new PathController(),
//                new CsvController(),
//                new RawController(),
                new SeminarController(),
                new SeminarListController()
            )
        );
    }
}
