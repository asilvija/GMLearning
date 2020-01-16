import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Seminar {

    private final int _totalSeats;
    private final String _location;
    private final Course _course;
    private final List<Student> _students;

    public Seminar(String location, int totalSeats, Course course) {
        _students = new ArrayList<Student>();
        _location = location;
        _totalSeats = totalSeats;
        _course = course;
    }

    public void addStudent(Student student) {
        _students.add(student);
    }

    public String getName() {
        return _course.getName();
    }

    public String getDescription() {
        return _course.getDescription();
    }

    public String getLocation() {
        return _location;
    }

    public int getSeatsLeft() {
        return _totalSeats - _students.size();
    }

    public Collection<Student> getStudentList() {
        return _students;
    }

    public Course getCourse() {
        return _course;
    }

    public String getNumber() {
        return getCourse().getNumber();
    }

    public String printPlain() {
        return new PrintPlain().print(this);
    }

    public String printHtml() {
        return new PrintHtml().print(this);
    }

    public String printCsv() {
        return new PrintCsv().print(this);
    }
}
