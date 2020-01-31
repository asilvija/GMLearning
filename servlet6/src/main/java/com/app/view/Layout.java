package com.app.view;

import com.github.manliogit.javatags.element.Element;
import static com.github.manliogit.javatags.lang.HtmlHelper.*;

public class Layout {

    public Element buildHtml() {
		return 
			html5(
		        head(
		          meta(attr("charset -> utf-8")),
		          meta(attr("http-equiv -> X-UA-Compatible","content -> IE=edge")),
		          meta(attr("name -> viewport","content -> width=device-width, initial-scale=1")),
		          title(
		            "helloWorld!"
		          ),
		          text("<!-- Bootstrap core CSS -->")
		          ,link(attr("href -> ../css/bootstrap.min.css","rel -> stylesheet"))
		        ),
		        body(
		          div(attr("class -> container"),
		            div(attr("class -> jumbotron"),
		              h1(
		                "Hello World 123!"
		              ),
		              p(attr("class -> lead"),
		                text("Hello world!")
		              ),
		              p(
		                a(attr("class -> btn btn-lg btn-success","href -> #","role -> button"),
		                  text("Sign up today")
		                )
		              )
		            )
		          )
		        )
		      );
	}

}
