
public class Enrollment {
    
    private final Student _student;
    public Enrollment(Student student) {
        _student = student;
    }
    public String getInfo() {
        return _student.getFullName();
    }

}
