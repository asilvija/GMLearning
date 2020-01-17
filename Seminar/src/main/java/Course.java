import java.util.Date;

public class Course {

    private final String _number;
    private final String _name;
    private final String _description;
    private final Date _startDate;

    public Course(String number, String name, String description, Date startDate) {
        _number = number;
        _name = name;
        _description = description;
        _startDate = startDate;
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

    public Date getStartDate() {
        return _startDate;
    }
}
