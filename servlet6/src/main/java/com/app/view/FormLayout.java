package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.manliogit.javatags.element.Element;

public class FormLayout {
    
    private final String _title;
    private String _info = "";
    private final ArrayList<HashMap<String, String>> _data;

    public FormLayout(String title, ArrayList<HashMap<String, String>> list) {
        _title = title;
        _data = list;
    }
    
    public FormLayout withInfo(String info) {
        _info = info;
        return this;
    }

    public Element buildHtml() {
        return html5(
            meta(attr("lang -> en")),
            head(
                meta(attr("charset -> utf-8")),
                meta(attr("http-equiv -> X-UA-Compatible", "content -> IE=edge")),
                meta(attr("name -> viewport", "content -> width=device-width, initial-scale=1")),
                title(_title),
                text("<!-- Bootstrap core CSS -->"),
                link(attr("href -> /css/bootstrap.min.css", "rel -> stylesheet"))),
            body(
                div(attr("class -> container"),
                    div(attr("class -> row"),
                        div(attr("class -> col-6 offset-2"),
                            h1(attr("class -> page-header text-center"),
                                text("Course Creation")),
                            form(
                                attr("class -> needs-validation", "role -> form", "method -> post",
                                    "action -> create"),
                                createFormFields(),
                                div(attr("class -> form-group"),
                                    label(attr("for -> location", "class -> col-2")),
                                    div(
                                        input(
                                            attr("type -> submit", "class -> btn btn-primary", "id -> submit",
                                                "name -> submit",
                                                "value -> Send"))))
                            ),
                            text(_info))))),
            script(attr("src -> ../js/jquery.min.js")),
            script(attr("src -> ../js/bootstrap.min.js")));
    }

    private Element createFormFields() {
        Element form = group();
      
        for (HashMap<String, String> entry : _data) {
            for (String label : entry.keySet()) {
                String name = entry.get(label);
                form.add(div(attr("class -> form-group"),
                    label(attr("for -> name", "class -> col-3 control-label"),
                        text(label)),
                    div(attr("class -> col-12"),
                        input(
                            attr("type -> text", 
                                 "class -> form-control", "id -> " + name + "",
                                 "name -> " + name + "",
                                 "placeholder -> " + label + "", "required")))));
            }
        }
        return form;
    }
}
