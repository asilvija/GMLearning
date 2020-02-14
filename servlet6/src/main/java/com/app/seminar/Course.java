package com.app.seminar;

public class Course {

//    private final String _id;
    private final String _id;
    private final String _name;
    private final String _description;
    private final String _start;

    public Course(String id, String name, String description, String courseDate) {
        _id = id;
        _name = name;
        _description = description;
        _start = formatDate(courseDate);
    }

    private String formatDate(String courseDate) {
        return courseDate.toString();
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

    public String getId() {
        return _id;
    }
}
