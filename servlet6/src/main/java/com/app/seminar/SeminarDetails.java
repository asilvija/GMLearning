package com.app.seminar;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SeminarDetails {
    private String _courseName = "";
    private final ArrayList<String> _courses = new ArrayList<String>();

    public SeminarDetails(String courseName) {
        _courseName = courseName;
    }

    public SeminarDetails() {
    }

    private Seminar prepareSeminarData() {
        return new Store().readFromCsvFile(_courseName);
    }

    private ArrayList<Seminar> prepareSeminarsData() {
        ArrayList<Seminar> results = new ArrayList<Seminar>();
        for (String courseName : _courses) {
            results.add(new Store().readFromCsvFile(courseName));
        }
        return results;
    }

    public String renderCsv() {
        return prepareSeminarData().renderCsv();
    }

    public String renderHtml() {
        return prepareSeminarData().renderHtmlLayout();
    }

    private String showHtmlLayout(String content) {
        return html5(
            head(
                meta(attr("charset -> utf-8")),
                meta(attr("http-equiv -> X-UA-Compatible", "content -> IE=edge")),
                meta(attr("name -> viewport", "content -> width=device-width, initial-scale=1")),

                link(attr("href -> ../css/bootstrap.min.css", "rel -> stylesheet"))),
            body(
                content)).render();

    }

    public String renderHtmlSeminarList() {
        findCsvFiles();
        return showHtmlLayout(generateHtmlSeminarList());
    }

    private String generateHtmlSeminarList() {
        String result = "";
        ArrayList<Seminar> seminarList = prepareSeminarsData();

        for (Seminar seminar : seminarList) {
            result += seminar.generateHtmlLayout();
        }
        return result;
    }

    private void findCsvFiles() {
        try {
            DirectoryStream<Path> results = Files.newDirectoryStream(Paths.get("./"));
            for (Path fileName : results) {
                if (fileName.toString().contains(".csv")) {
                    _courses.add(fileName.toString());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String renderRaw() {
        return prepareSeminarData().renderRaw();
    }
}
