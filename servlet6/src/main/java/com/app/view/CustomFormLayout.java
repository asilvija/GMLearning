package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.util.Map;

import com.github.manliogit.javatags.element.Element;

public class CustomFormLayout implements Element {
    private final Element _content = group();

    @Override
    public CustomFormLayout add(Element element) {

        _content.add(element);
        return this;
    }

    @Override
    public String render() {
        return form(
            attr(
                "class -> needs-validation",
                "method -> post",
                "action -> create",
                "role -> form"
                , "novalidate"
                ),
            _content).render();
    }

    public Element insertRow() {
        add(div(attr("class -> row")));
        return this;
    }

    public Element defaultInputField(String name, String label, String placeholder, String required, String maxLength, Map<String, String> feedback) {
        add(
            div(attr("class -> form-group"),
                label(
                    attr(
                        "for -> " + name + "",
                        "class -> col-3 control-label"),
                    text(label)),
                div(attr("class -> col-12"),
                    input(
                        attr("type -> text", required)
                            .add("class", "form-control")
                            .add("id", name)
                            .add("name", name)
                            .add("placeholder", placeholder)
                            .add("maxlength", maxLength)
                            ),
                    feedBack(feedback)
                    )));
        return this;
    }

    public Element numericInputField(String name, String label, String placeholder, String value, String min,
        String max, String required, Map<String, String> feedback) {
        add(
            div(attr("class -> form-group"),
                label(
                    attr(
                        "for -> " + name + "",
                        "class -> col-3 control-label"),
                    text(label)),
                div(attr("class -> col-12"),
                    input(
                        attr("type -> number",
                            required)
                                .add("class", "form-control")
                                .add("id", name)
                                .add("name", name)
                                .add("placeholder", placeholder)
                                .add("min", min)
                                .add("max", max)
                                .add("value", value)),
                    feedBack(feedback)
                )

            ));
        return this;
    }
    
    private Element feedBack(Map<String, String> feedback) {
       Element group = group();
       for (Map.Entry<String, String> entry : feedback.entrySet()) {
           group.add( 
               div(attr("class ->" + entry.getKey() + ""),
                   text(entry.getValue())
               )
           );
       }
       return group;
    }

    public Element datePickerInputField(String name, String label, String required, Map<String, String> feedback) {
        add(
            div(attr("class -> form-group"),
                label(attr("for -> " + name + "",
                    "class -> col-3 control-label"),
                    text(label)),
                div(attr("class ->col-12 input-group date"),
                    input(
                        attr("type -> text",
                            required)
                                .add("class", "form-control")
                                .add("id", "datetimepicker")
                                .add("name", name)
                                .add("placeholder", "Pick Date")
                                .add("data-date-format", "MM.DD.YYYY")
                    ), feedBack(feedback)
                )));
        return this;
    }

    public Element addSubmitButton(String name) {
        add(div(attr("class -> form-group"),
            label(attr("class -> col-2")),
            div(
                input(
                    attr("type -> submit")
                        .add("class", "btn btn-primary")
                        .add("id", name)
                        .add("name", name)
                        .add("value", "Send")))));
        return this;
    }
    
    public Element withInvalidFeedback(String feedback) {
        return 
            div(
                attr("class -> invalid-feedback"),
                text(feedback)
            );
    }
}
