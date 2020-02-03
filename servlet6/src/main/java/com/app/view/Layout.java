package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import com.github.manliogit.javatags.element.Element;

public class Layout {
    public Element buildHtml() {
        return html5(
            meta(attr("lang -> en")),
            head(
                meta(attr("charset -> utf-8")),
                meta(attr("http-equiv -> X-UA-Compatible", "content -> IE=edge")),
                meta(attr("name -> viewport", "content -> width=device-width, initial-scale=1")),
                title(
                    "Seminar"),
                text("<!-- Bootstrap core CSS -->"),
                link(attr("href -> ../css/bootstrap.min.css", "rel -> stylesheet"))),
            body(
                div(attr("class -> container"),
                    div(attr("class -> row"),
                        div(attr("class -> col-md-6 col-md-offset-3"),
                            h1(attr("class -> page-header text-center"),
                                text("Contact Form Example")),
                            form(
                                attr("class -> form-horizontal", "role -> form", "method -> post",
                                    "action -> create"),
                                div(attr("class -> form-group"),
                                    label(attr("for -> name", "class -> col-sm-3 control-label"),
                                        text("Course Name")),
                                    div(attr("class -> col-sm-9"),
                                        input(
                                            attr("type -> text", "class -> form-control", "id -> name",
                                                "name -> name",
                                                "placeholder -> Course Name")))),

                                div(attr("class -> form-group"),
                                    label(attr("for -> location", "class -> col-sm-3 control-label"),
                                        text("Location")),
                                    div(attr("class -> col-sm-9"),
                                        input(
                                            attr("type -> text", "class -> form-control", "id -> location",
                                                "name -> location",
                                                "placeholder -> Location")))),
                                div(attr("class -> form-group"),
                                    label(attr("for -> location", "class -> col-sm-2-offset-2")),
                                    div(attr("class -> col-sm-10"),
                                        input(
                                            attr("type -> submit", "class -> btn btn-primary", "id -> submit",
                                                "name -> submit",
                                                "value -> Send")))))

                        )))),
            script(attr("src -> ../js/jquery.min.js")),
            script(attr("src -> ../js/bootstrap.min.js")));
    }

}
