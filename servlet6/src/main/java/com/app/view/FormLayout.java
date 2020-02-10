package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import com.github.manliogit.javatags.element.Element;


public class FormLayout {
    
    private final String _title;
    private String _info = "";


    public FormLayout(String title) {
        _title = title;
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
                link(attr("href -> /css/bootstrap.min.css", "rel -> stylesheet")),
                link(attr("href -> /css/bootstrap-datetimepicker.min.css", "rel -> stylesheet")),
                link(attr("href -> /css/form-validation.css", "rel -> stylesheet"))
            ),
            body(
                div(attr("class -> container"),
                    div(attr("class -> row"),
                        div(attr("class -> col-6 offset-2"),
                            h1(attr("class -> page-header text-center"),
                                text("Course Creation")
                            ),
                            form(
                                attr("class -> needs-validation", "role -> form", "method -> post",
                                    "action -> create", "novalidate"),
                                customFormFields(),
                                
                                div(attr("class -> form-group"),
                                    label(attr("class -> col-2")),
                                    div(
                                        input(
                                            attr("type -> submit", "class -> btn btn-primary", "id -> submit",
                                                "name -> submit",
                                                "value -> Send"))
                                     )                                   
                                 )
                            ),
                            text(_info)
                        )
                     )
                )
            ),
            script(attr("src -> /js/jquery.min.js")),
            script(attr("src -> /js/bootstrap.min.js")),
            script(attr("src -> /js/form-validation.js")),
            script(attr("src -> https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.12.0/moment.js")),
            script(attr("src -> /js/bootstrap-datetimepicker.min.js"))
        );
    }

    private Element customFormFields() {
        Element form = group();
        form.add(
            div(attr("class -> form-group"),
                label(attr("for -> name", 
                           "class -> col-3 control-label"),
                    text("Name")
                ),
                div(attr("class -> col-12"),
                    input(
                        attr("type -> text", 
                             "class -> form-control", 
                             "id ->  name",
                             "name -> name",
                             "placeholder -> Name", 
                             "required")
                    ),
                    div(attr("class -> invalid-feedback"),
                        text("Please insert course name.")
                    )
                )
             )
            
        );
        form.add(
            div(attr("class -> form-group"),
                label(attr("for -> startdate", 
                           "class -> col-3 control-label"),
                    text("Start Date")
                ),
                div(attr("class ->col-12 input-group date"),
                    input(
                        attr("type -> text", 
                               "class -> form-control", 
                               "id -> datetimepicker",
                               "name -> startdate",
                               "placeholder -> Pick Date",
                               "data-date-format -> MM.DD.YYYY",
                               "required")
                    ),
                    div(attr("class -> invalid-feedback"),
                        text("Please insert date.")
                    )
                )
             )
         );
        
        form.add(
            div(attr("class -> form-group"),
                label(attr("for -> location", 
                           "class -> col-3 control-label"),
                    text("Location")
                ),
                div(attr("class -> col-12"),
                    input(
                        attr("type -> text", 
                             "class -> form-control", 
                             "id ->  location",
                             "name -> location",
                             "placeholder -> Location", 
                             "required")
                    ),
                    div(attr("class -> invalid-feedback"),
                        text("Please insert location."))
                )
             )
        );
        
        form.add(
            div(attr("class -> form-group"),
                label(attr("for -> seats", 
                           "class -> col-3 control-label"),
                    text("Total Seats")
                ),
                div(attr("class -> col-12"),
                    input(
                        attr("type -> number", 
                             "class -> form-control", 
                             "id ->  seats",
                             "name -> totalseats",
                             "placeholder -> Total Seats", 
                             "required", 
                             "min -> 1")
                    ),
                    div(attr("class -> invalid-feedback"),
                        text("Please insert seats number (min value 1)."))
                )
             )
        );
        
        form.add(
            div(attr("class -> form-group"),
                label(attr("for -> number", 
                           "class -> col-3 control-label"),
                    text("Number")
                ),
                div(attr("class -> col-12"),
                    input(
                        attr("type -> number", 
                             "class -> form-control", 
                             "id ->  number",
                             "name -> number",
                             "placeholder -> Number", 
                             "min -> 0",
                             "value -> 0"
                             )
                    ),
                    div(attr("id -> numfeed"),
                        text("Please insert number less than num seats."))
                )
             )
        );
        
        return form;
    }
}
