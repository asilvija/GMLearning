import java.util.List;

public class Person {
    private int _index;
    private String _firstName = "";
    private String _lastName = "";
    private boolean _isAbsent = false;

    public Person(int index, List<String> attributes) {
        _index = index;
        if (attributes.size() == 3) {
            _firstName = attributes.get(0);
            _lastName = attributes.get(1);
            setAbsent(Boolean.parseBoolean(attributes.get(2)));
        }
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