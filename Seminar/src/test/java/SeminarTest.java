import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SeminarTest {
    String courseDate = "28.03.2020";

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
}
