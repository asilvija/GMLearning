package com.app.seminar.model;

public class Student {
    private final Integer _id;
    private final String _firstName;
    private final String _lastName;

    public Student(Integer id, String firstName, String lastName) {
        _id = id;
        _firstName = firstName;
        _lastName = lastName;
    }

    public String getFullName() {
        return _firstName + " " + _lastName;
    }

    public String getName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public Integer getId() {
        return _id;
    }
}
