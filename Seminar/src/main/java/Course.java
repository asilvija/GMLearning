import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Course {

    private final String _number;
    private final String _name;
    private final String _description;
    private final String _startDate;

    public Course(String number, String name, String description, String courseDate) {
        _number = number;
        _name = name;
        _description = description;

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date _courseDate;
        try {
            _courseDate = new SimpleDateFormat("dd.MM.yyyy").parse(courseDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        _startDate = formatter.format(_courseDate);
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
