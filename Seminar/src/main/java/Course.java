public class Course {

    private final String _number;
    private final String _name;
    private final String _description;
    private final String _startDate;

    public Course(String number, String name, String description, String courseDate) {
        _number = number;
        _name = name;
        _description = description;
        _startDate = formatDate(courseDate);
    }

    private String formatDate(String courseDate) {
        return courseDate;
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

    public String getStartDate() {
        return _startDate;
    }
}
