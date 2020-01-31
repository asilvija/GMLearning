package com.app.seminar;
import java.util.List;

public class RawRenderer implements Renderer {
    private final List<List<String>> _data;

    public String render() {
        String result = "";

        for (List<String> line : _data) {
            for (String value : line) {
                result += value + " ";
            }
            result += "\n";
        }
        return result;
    }

    public RawRenderer(List<List<String>> data) {
        _data = data;
    }
}
