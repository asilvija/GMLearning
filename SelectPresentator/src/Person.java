public class Person {
    private int _index;
    private String _firstName;
    private String _lastName;
    private boolean _isAbsent= false;
    
    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }
    public String getFullName() {
        return _firstName + " " + _lastName;
    }
    public Person (String firstName, String lastName, Boolean isAbsent) {
        _firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        _lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        _isAbsent = isAbsent;
    }

    public boolean isAbsent() {
        return _isAbsent;
    }

    public void setAbsent(boolean isAbsent) {
        _isAbsent = isAbsent;
    }

    public int getIndex() {
        return _index;
    }

    public void setIndex(int index) {
        _index = index;
    }
}