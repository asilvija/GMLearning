public class Person {
    private int _index;
    private final String _firstName;
    private final String _lastName;
    private boolean _isAbsent = false;

    public Person(int index, String firstName, String lastName, Boolean isAbsent) {
        _index = index;
        _firstName = firstName;
        _lastName = lastName;
        _isAbsent = isAbsent;
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public String getFullName() {
        return _firstName + " " + _lastName;
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