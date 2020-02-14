package com.app.seminar;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;
import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.manliogit.javatags.element.Element;

public class Seminar {

    private final int _totalSeats;
    private final String _location;
    private final Course _course;
    private final List<Student> _students;
    private final String _fileName = "";

    public Seminar(String location, int totalSeats, Course course) {
        _students = new ArrayList<Student>();
        _location = location;
        _totalSeats = totalSeats;
        _course = course;
    }

    public void addStudent(Student student) {
        _students.add(student);
    }

    public String getName() {
        return _course.getName();
    }

    public String getDescription() {
        return _course.getDescription();
    }
    
    public String getId() {
        return _course.getId();
    }

    public String getLocation() {
        return _location;
    }

    public int getSeatsLeft() {
        return _totalSeats - _students.size();
    }
    
    public String getTotalSeats() {
        return Integer.toString(_totalSeats);
    }


    public Collection<Student> getStudentList() {
        return _students;
    }

    public String getStartDate() {
        return _course.getStartDate();
    }

    public Course getCourse() {
        return _course;
    }

    public String renderRaw() {

        List<List<String>> data = new ArrayList<List<String>>();
        data.add(asList(
            getId(),
            getName(),
            getDescription(),
            getLocation(),
            String.valueOf(getSeatsLeft()),
            String.valueOf(getStartDate())));

        for (Student student : _students) {
            data.add(asList(student.getName(), student.getLastName()));
        }
        return new RawRenderer(data).render();
    }

    public String renderCsv() {
        List<List<String>> data = new ArrayList<List<String>>();

        data.add(asList(
            getId(),
            getName(),
            getDescription(),
            getLocation(),
            String.valueOf(getSeatsLeft()),
            String.valueOf(getStartDate())));

        for (Student student : _students) {
            data.add(asList(student.getName(), student.getLastName()));
        }
        
        return new CsvRenderer(data).render();
    }

    public Element renderHtmlLayout() {
        return group().add(tr(
            th(getId()),
            th(getName()),
            th(getLocation()),
            th(getTotalSeats()),
            th(getStartDate())
         ));
    }
        
//    private String getStudentData() {
//        String studentinfo = "";
//        for (Student student : getStudentList()) {
//            studentinfo += li(student.getName() + " " + student.getLastName()).render();
//        }
//        return studentinfo;
//    }

    public String getFileName() {
        return _fileName;
    }
}
