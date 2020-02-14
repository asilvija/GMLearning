package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import com.github.manliogit.javatags.element.Element;

public class HtmlPage implements Element {
    private final Element _element;
    private final String _title = "Title";

    public HtmlPage (Element element) {
        _element = element;
        
    }
    
    @Override
    public String render() {
        return html5(
            meta(attr("lang -> en")),
            head(
                meta(attr("charset -> utf-8")),
                meta(attr("http-equiv -> X-UA-Compatible", "content -> IE=edge")),
                meta(attr("name -> viewport", "content -> width=device-width, initial-scale=1")),
                title(_title ),
                text("<!-- Bootstrap core CSS -->"),
                link(attr("href -> /css/bootstrap.min-4.0.0.css", "rel -> stylesheet")),
                link(attr("href -> /css/bootstrap-datetimepicker.min.css", "rel -> stylesheet")),
                link(attr("href -> /css/form-validation.css", "rel -> stylesheet"))
            ),
            body(
                div(attr("class -> container"),
                    div(attr("class -> row"),
                        div(attr("class -> col-6 offset-2"),
                            h1(attr("class -> page-header text-center"),
                                text("Course Creation")
                            ),_element
                        )
                     )
                )
            )
            ,
            script(attr("src -> /js/jquery.min.js")),
            script(attr("src -> /js/bootstrap.min-4.0.0.js")),
            script(attr("src -> /js/form-validation.js")),
            script(attr("src -> https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.12.0/moment.js")),
            script(attr("src -> /js/bootstrap-datetimepicker.min.js"))
        ).render();
    }

    @Override
    public Element add(Element element) {
        return this;
    }

}
