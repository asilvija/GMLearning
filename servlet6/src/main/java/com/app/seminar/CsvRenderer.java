package com.app.seminar;

import java.util.List;

public class CsvRenderer implements Renderer {
    private final List<List<String>> _data;

    private final String _fieldSeparator = ";";
    private final static String _textDelimiter = "\"";

    @Override
    public String render() {
        String result = "";

        for (List<String> line : _data) {
            for (String value : line) {
                result += getTextDelimiter() + value + getTextDelimiter() + getFieldSeparator();
            }
            result += "\n";
        }
        return result;
    }

    public CsvRenderer(List<List<String>> data) {
        _data = data;
    }

    public String getFieldSeparator() {
        return _fieldSeparator;
    }

    public String getTextDelimiter() {
        return _textDelimiter;
    }

    public static String removeTextDelimiter(String text) {
        return text.replace(_textDelimiter, "");
    }
}
