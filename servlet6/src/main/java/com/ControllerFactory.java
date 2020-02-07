package com;

import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;

import com.app.controller.Controller;
import com.app.controller.NotFoundController;
import com.app.controller.SeminarCreationController;
import com.app.controller.SeminarViewController;

public class ControllerFactory {

    public List<Controller> create() {
        return new ArrayList<Controller>(
            asList(
//                new CsvController(),
//                new RawController(),
                new SeminarCreationController(),
                new SeminarViewController(),
                new NotFoundController()
            )
        );
    }
}
