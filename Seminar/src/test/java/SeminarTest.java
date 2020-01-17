import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class SeminarTest {
    Date courseDate;

    public SeminarTest() {
        try {
            courseDate = new SimpleDateFormat("dd/MM/yyyy").parse("28/03/2020");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void checkSeminar() {

        Course course1 = new Course("1", "English", "A1", courseDate);
        Course course2 = new Course("1", "Deutsch", "B1", courseDate);
        Course course3 = new Course("1", "Espagnolo", "C1", courseDate);

        Seminar english = new Seminar("Lugano", 10, course1);
        Seminar deutsch = new Seminar("Lugano", 12, course2);
        Seminar espagnolo = new Seminar("Lugano", 8, course3);

        Student student1 = new Student("Anna", "Marchi");
        Student student2 = new Student("Marco", "Ruggieri");
        Student student3 = new Student("Ivan", "Bernasconi");
        Student student4 = new Student("Raf", "Bosch");
        Student student5 = new Student("Pillar", "Moura");
        Student student6 = new Student("Rosane", "Miguel");

        english.addStudent(student1);
        english.addStudent(student2);
        deutsch.addStudent(student3);

        espagnolo.addStudent(student4);
        espagnolo.addStudent(student5);
        espagnolo.addStudent(student6);

        assertThat(english.getSeatsLeft(), is(8));
        assertThat(deutsch.getName(), is("Deutsch"));
        assertThat(espagnolo.getDescription(), is("C1"));
        assertThat(espagnolo.getLocation(), is("Lugano"));
        assertThat(espagnolo.getStudentList(), hasSize(3));

        assertThat(english.getStudentList(), containsInAnyOrder(student1, student2));
        assertThat(deutsch.getStudentList(), containsInAnyOrder(student3));

        assertThat(english.getCourse(), is(course1));
        assertThat(deutsch.getCourse(), is(course2));
    }

    @Test
    public void checkCourse() {
        Course course = new Course("1", "English", "A1", courseDate);

        assertThat(course.getName(), is("English"));
        assertThat(course.getNumber(), is("1"));
        assertThat(course.getDescription(), is("A1"));
    }

    @Test
    public void checkStudent() {
        Student student = new Student("Anna", "Marchi");
        assertThat(student.getName(), is("Anna"));
        assertThat(student.getLastName(), is("Marchi"));
        assertThat(student.getFullName(), is("Anna Marchi"));
    }

    @Test
    public void checkPrintCsv() throws Exception {
        Seminar seminar = new Seminar("Lugano", 10, new Course("1", "English", "A1", courseDate));

        seminar.addStudent(new Student("Anna", "Marchi"));
        seminar.addStudent(new Student("Marco", "Ruggieri"));
        seminar.printCsv();

        BufferedReader _input = new BufferedReader(new FileReader("English.csv"));

        String attributes[] = _input.readLine().split(";");
        assertThat(attributes[0], is("\"1\""));
        assertThat(attributes[1], is("\"English\""));
        assertThat(attributes[2], is("\"A1\""));
        assertThat(attributes[3], is("\"Lugano\""));
        assertThat(attributes[4], is("\"8\""));
        _input.close();
    }
}
