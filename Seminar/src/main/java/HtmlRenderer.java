import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;

public class HtmlRenderer implements Renderer {
    private String _tagName;
    private String _value="";

    private final List<HtmlRenderer> _children = new ArrayList<HtmlRenderer>();

    public HtmlRenderer() {
    }

    public String render() {
        String result = "";
        result += "<" + getTagName() + ">";

        result += _value;

        for (HtmlRenderer tag : _children) {
            result += tag.render();
        }

        return result += "</" + getTagName() + ">";
    }

    public HtmlRenderer html(HtmlRenderer... content) {
        return withTags("html", content);
    }

    public HtmlRenderer head(HtmlRenderer content) {
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

    public String getTagName() {
        return _tagName;
    }

    public void setTagName(String tagName) {
        _tagName = tagName;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String value) {
        _value = value;
    }

}
