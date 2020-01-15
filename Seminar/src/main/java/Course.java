
public class Course {

    private final String _number;
    private final String _name;
    private final String _description;

    public Course(String number, String name, String description) {
        _number = number;
        _name = name;
        _description = description;
    }

    public String getName() {
        return _name;
    }

    public String getNumber() {
        return _number;
    }

    public String getDescription() {
        return _description;
    }
}
