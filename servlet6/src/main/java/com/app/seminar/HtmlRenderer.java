package com.app.seminar;
import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;


public class HtmlRenderer implements Renderer {
    private String _tagName;
    private String _value ="";
    private final List<HtmlRenderer> _children = new ArrayList<HtmlRenderer>();
    
    public String render1() {
        
        return "";
    }
    @Override
    public String render() {
        if (getTagName().equals("link")) {
            
            String result = "<" + getTagName() + " " + _value;
            for (HtmlRenderer tag : _children) {
                result += tag.render();
            }
            return result += ">";
            
        } else {
            String result = "<" + getTagName() + ">" + _value;
            for (HtmlRenderer tag : _children) {
                result += tag.render();
            }
            return result += "</" + getTagName() + ">";
        }
    }

    public HtmlRenderer html(HtmlRenderer... content) {
        return withTags("html", content);
    }

    public HtmlRenderer head(HtmlRenderer... content) {
        return withTags("head", content);
    }

    public HtmlRenderer body(HtmlRenderer... content) {
        return withTags("body", content);
    }

    public HtmlRenderer ul(HtmlRenderer... content) {
        return withTags("ul", content);

    }

    public HtmlRenderer title(String text) {
        return withText("title", text);
    }
    
    public HtmlRenderer link(String text) {
        return withText("link", text);
    }

    public HtmlRenderer li(String text) {
        return withText("li", text);
    }

    public HtmlRenderer div(String text) {
        return withText("div", text);
    }

    private HtmlRenderer withText(String name, String text) {
        setTagName(name);  
        setValue(text);

        return this;
    }

    private HtmlRenderer withTags(String name, HtmlRenderer... content) {
        setTagName(name);
        _children.addAll(asList(content));
        return this;
    }

    private String getTagName() {
        return _tagName;
    }

    private void setTagName(String tagName) {
        _tagName = tagName;
    }

    private void setValue(String value) {
        _value = value;
    }
}
