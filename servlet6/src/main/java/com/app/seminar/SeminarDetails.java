package com.app.seminar;

public class SeminarDetails {
    private static String _courseName = "";

    public SeminarDetails(String courseName) {
        _courseName = courseName;
    }

    public static void main(String[] args) {
        System.out.println(_courseName);
        try {
            new Store().readFromCsvFile(_courseName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Seminar prepareSeminarData() {
        return new Store().readFromCsvFile(_courseName);
    }

    public String renderCsv() {
        return prepareSeminarData().renderCsv();
    }

    public String renderHtml() {
        return prepareSeminarData().renderHtmlLayout();
    }

    public String renderRaw() {
        return prepareSeminarData().renderRaw();
    }
}
