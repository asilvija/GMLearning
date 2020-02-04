package com.app.seminar;

public class Student {
    private final String _firstName;
    private final String _lastName;

    public Student(String firstName, String lastName) {
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
}