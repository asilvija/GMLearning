package com.app.seminar;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.github.manliogit.javatags.element.Element;

public class SeminarDetails {
    private String _courseName = "";
    private final ArrayList<String> _courses = new ArrayList<String>();

    public SeminarDetails(String courseName) {
        _courseName = courseName;
    }

    public SeminarDetails() {
    }

    private Seminar prepareSeminarData() {
        return new Store().readFromCsvFile(_courseName);
    }

    private ArrayList<Seminar> prepareSeminarsData() {
        ArrayList<Seminar> results = new ArrayList<Seminar>();
        for (String courseName : _courses) {
            results.add(new Store().readFromCsvFile(courseName));
        }
        return results;
    }

    public String renderCsv() {
        return prepareSeminarData().renderCsv();
    }

    public Element renderHtml() {
        return prepareSeminarData().renderHtmlLayout();
    }

    private String showHtmlLayout(Element content) {
        return 
        html5(
            head(
                meta(attr("charset -> utf-8")),
                meta(attr("http-equiv -> X-UA-Compatible", "content -> IE=edge")),
                meta(attr("name -> viewport", "content -> width=device-width, initial-scale=1")),
                title("courses"),
                link(attr("href -> /css/bootstrap.min.css", "rel -> stylesheet")),
                link(attr("href -> /css/custom.css", "rel -> stylesheet"))   
            ),
//            script(attr("src -> https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js")),
//            script(attr("src -> https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js")),
            script(attr("src -> /js/jquery.min.js")),
            script(attr("src -> /js/bootstrap.min.js")),

            body(
                div(attr("class -> navbar navbar-default navbar-fixed-top"),
                    div(attr("class -> container"),
                        div(attr("class -> navbar-header"),
                            a(attr("href -> /", "class -> navbar-brand"), "Seminar"),
                            button(
                                attr("class -> navbar-toggle", 
                                     "type -> button", 
                                     "data-toggle -> collapse", 
                                     "data-target -> #navbar-main"
                                 ),
                                span(attr("class -> icon-bar")),
                                span(attr("class -> icon-bar")),
                                span(attr("class -> icon-bar"))
                              )
                        ),
                        div(attr("class-> navbar-collapse collapse", "id -> navbar-main"),
                            ul(attr("class -> nav navbar-nav navbar-right"),
                                li(attr("class -> dropdown"),
                                    a(attr(
                                        "class -> dropdown-toggle", 
                                        "data-toggle -> dropdown",
                                        "href -> #",
                                        "id -> download",
                                        "aria-expanded -> false"
                                       ),
                                       "Account"
                                      
                                    ),
                                    ul(attr(
                                        "class -> dropdown-menu",
                                        "aria-labelledby -> download"
                                        ),
                                        li(
                                           a(attr("href -> /"), "settings")
                                        ),
                                        li(
                                            attr("class -> divider")
                                        ),
                                        li(a(attr("href -> /"), "logout"))
                                     )
                                )
                            )
                        )
                    )
                ),
                div(attr("class -> container"),
                    div(attr(
                        "id -> banner", 
                        "class ->page-header"
                        ),
                        div(attr("class -> row"),
                          div(attr(
                              "class -> col-lg-8 col-md-7 col-sm-6")
                          ),
                          h1("Seminar"),
                          p(attr("class -> lead"),"Manage your courses")
                        ),
                        div(attr("class -> row"),
                            div(attr("class -> col-lg-2 col-md-2 col-sm-3"),
                                div(attr("class -> list-group table-of-contents"),
                                    a(attr("class -> list-group-item", "href -> /course"),
                                        "List"
                                    ),
                                    a(attr(
                                        "class ->  list-group-item", 
                                        "href -> /course/create"
                                      ), "Create"
                                    )
                                )
                            ),
                            div(attr("class -> col-lg-8 col-md-8 col-sm-9"),
                                table(attr("class -> table table-striped"),
                                    thead(
                                        tr(
                                            th("id"),
                                            th("name"),
                                            th("location"),
                                            th("totalSeats"),
                                            th("start")
                                        ), content
                                    )
                                )
                            )
                        )
                    ),
                    footer(
                       div(attr("class -> row"),
                         div(attr("class -> col-lg-12"),
                             p(
                                 a(attr("href -> http://bootswatch.com/cerulean"))
                             ),
                             p(text("Code released under the"),
                                 a(attr("href -> https://github.com/thomaspark/bootswatch/blob/gh-pages/LICENSE"),
                                     "MIT Licence")
                             ),
                             p("GmTechnologies")
                          )
                       )
                    )
                )                
            )
        ).render();

    }

    public String renderHtmlSeminarList() {
        findCsvFiles();
        return showHtmlLayout(generateHtmlSeminarList());
    }

    private Element generateHtmlSeminarList() {
        Element group = group();
        for (Seminar seminar : prepareSeminarsData()) {
            group.add(seminar.renderHtmlLayout());  
        }
        return group;
    }

    private void findCsvFiles() {
        try {
            DirectoryStream<Path> results = Files.newDirectoryStream(Paths.get("./"));
            for (Path fileName : results) {
                if (fileName.toString().contains(".csv")) {
                    _courses.add(fileName.toString());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String renderRaw() {
        return prepareSeminarData().renderRaw();
    }
}
