package com.app.seminar.model;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;
import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;

import com.app.seminar.view.CsvRenderer;
import com.github.manliogit.javatags.element.Element;

public class Course {
    private final Integer _id;
    private final String _name;
    private final String _description;
    private final Integer _totalSeats;
    private final String _location;
    private final String _start;
    private final List<Student> _students = new ArrayList<Student>();

    public Course(Integer id, String name, String description, String location, Integer totalSeats, String courseDate) {
        _id = id;
        _name = name;
        _description = description;
        _location = location;
        _totalSeats = totalSeats;
        _start = courseDate;
    }

    public String getName() {
        return _name;
    }

    public String getDescription() {
        return _description;
    }

    public String getStartDate() {
        return _start;
    }

    public Integer getId() {
        return _id;
    }

    public String getLocation() {
        return _location;
    }

    public String formatCsv() {
        List<List<String>> data = new ArrayList<List<String>>();
        data.add(
            asList(
                getId().toString(),
                getName(),
                getDescription(),
                getLocation(),
                String.valueOf(getTotalSeats()),
                getStartDate()
             )
        );

        for (Student student : _students) {
            data.add(asList(student.getName(), student.getLastName()));
        }
        return new CsvRenderer(data).render();
    }
    
    public Element renderHtmlLayout() {
        return group().add(tr(
            th(getId().toString()),
            th(getName()),
            th(getLocation()),
            th(getTotalSeats().toString()),
            th(getStartDate())
         ));
    }
    
    public void addStudent(Student student) {
        _students.add(student);
    }
    
    public Integer getTotalSeats() {
        return _totalSeats;
    }
    public Integer getSeatsLeft(){
        return getTotalSeats() - _students.size();
    }
}
