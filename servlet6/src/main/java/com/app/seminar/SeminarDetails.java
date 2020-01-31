package com.app.seminar;

public class SeminarDetails {

    private static Seminar prepareSeminarData() {
        String courseDate = "28.03.2020";
        Seminar english = new Seminar("Lugano", 10, new Course("1", "English", "A1", courseDate));

        english.addStudent(new Student("Anna", "Marchi"));
        english.addStudent(new Student("Marco", "Ruggieri"));

        return english;
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
