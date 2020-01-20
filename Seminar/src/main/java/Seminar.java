import static java.util.Arrays.*;

import java.io.FileWriter;
import java.io.IOException;
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

    public String getStartDate() {
        return _course.getStartDate();
    }

    public Course getCourse() {
        return _course;
    }

    public String getNumber() {
        return getCourse().getNumber();
    }

    public String printHtml() {
        return renderHtml();

    }

    public String renderHtml() {

        List<HtmlRenderer> studentList = new ArrayList<HtmlRenderer>();

        for (Student student : getStudentList()) {
            studentList.add(new HtmlRenderer().li(student.getName() + " " + student.getLastName()));
        }

        return new HtmlRenderer().html(
            new HtmlRenderer().head(
                new HtmlRenderer().title(getName())),
            new HtmlRenderer().body(
                new HtmlRenderer().div("Nome Corso:" + getName()),
                new HtmlRenderer().ul(
                    new HtmlRenderer().li(getDescription()),
                    new HtmlRenderer().li(getStartDate().toString()),
                    new HtmlRenderer().li(getLocation()),
                    new HtmlRenderer().li(String.valueOf(getSeatsLeft()))),
                new HtmlRenderer().div("Partecipanti:"),
                new HtmlRenderer().ul(studentList.toArray(new HtmlRenderer[] {}))))
            .render();
    }

    public String renderCsv() {

        List<List<String>> data = new ArrayList<List<String>>();

        data.add(asList(
            getNumber(),
            getName(),
            getDescription(),
            getLocation(),
            String.valueOf(getSeatsLeft()),
            String.valueOf(getStartDate())));

        for (Student student : _students) {
            data.add(asList(student.getName(), student.getLastName()));
        }

        String result = new CsvRenderer(data).render();
        writeOnFile(result, getName());
        return result;
    }

    private void writeOnFile(String seminarInfo, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName + ".csv");
            fw.write(seminarInfo);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
