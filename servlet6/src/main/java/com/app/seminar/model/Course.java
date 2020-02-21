package com.app.seminar.model;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.github.manliogit.javatags.element.Element;

public class Course implements Entity{
    
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String LOCATION = "location";
    public static final String TOTAL_SEATS = "totalSeats";
    public static final String START = "start";
    
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
    
    public Course(Map<String, String> params) {
        this(
            params.get(ID).equals("") ? null : Integer.parseInt(params.get(ID)),
            params.get(NAME), 
            params.get(DESCRIPTION), 
            params.get(LOCATION), 
            Integer.valueOf(params.get(TOTAL_SEATS)), 
            params.get(START)
         );
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
    
    public Element renderHtmlLayout() {
        return group().add(
        tr(
            th(getId().toString()),
            th(getName()),
            th(getLocation()),
            th(getTotalSeats().toString()),
            th(getStartDate())
         ));
    }
    
    public static Element renderRow(Entity entity) {
        Course c = (Course)entity; 
        return tr(
                td(text(c.getId().toString())),
                th(attr("scope -> row"), a(attr("href -> /course/" + c.getId()),text(c.getName()))),
                td(text(c.getLocation())),
                td(text(c.getTotalSeats().toString())),
                td(text(c.getStartDate()))
//                ,
//                td(a(attr("href -> " + DeleteCourse.ROUTE + "/" + c.getId()),"delete"))
            );
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
