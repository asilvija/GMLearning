import java.util.ArrayList;

public class Seminar {
    
    private final int _totalSeats;
    private final String _location;
    private final Course _course;
    private final ArrayList<Enrollment> _enrollments;

    public Seminar(String location, int totalSeats, Course course) {
        _enrollments = new ArrayList<Enrollment>();
        _location = location;
        _totalSeats = totalSeats;
        _course = course;
    }

    public void addEnrollment(Enrollment enrollment) {
        _enrollments.add(enrollment);
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
        return _totalSeats - _enrollments.size();
    }

    public ArrayList<Enrollment> getStudentList() {
        return _enrollments;
    }
    public Course getCourse() {
        return _course;
    }
   
}
