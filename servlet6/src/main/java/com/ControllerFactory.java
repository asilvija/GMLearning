package com;

import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;

import com.app.controller.Controller;
import com.app.controller.SeminarController;
import com.app.controller.CsvController;
import com.app.controller.HtmlController;
import com.app.controller.RawController;

public class ControllerFactory {

    public List<Controller> create() {
        return new ArrayList<Controller>(
            asList(
                new HtmlController(),
                new CsvController(),
                new RawController(),
                new SeminarController()
            )
        );
    }
}
