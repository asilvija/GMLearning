package com.app.seminar.model;

import java.util.Map;

public class Student implements Entity {
    public static final String ID = "id";
    public static final String FIRST_NAME = "first name";
    public static final String LAST_NAME = "last name";
    
    private final Integer _id;
    private final String _firstName;
    private final String _lastName;

    public Student(Integer id, String firstName, String lastName) {
        _id = id;
        _firstName = firstName;
        _lastName = lastName;
    }
    
    public Student(Map<String, String> params) {
        this(
            params.get(ID).equals("") ? null : Integer.parseInt(params.get(ID)),
            params.get(FIRST_NAME),
            params.get(LAST_NAME)
         );
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
