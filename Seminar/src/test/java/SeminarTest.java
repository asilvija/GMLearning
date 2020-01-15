import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SeminarTest {

    @Test
    public void checkSeminar() throws Exception {
        Course course1 = new Course("1", "English", "A1");
        Course course2 = new Course("1", "Deutsch", "B1");
        Course course3 = new Course("1", "Espagnolo", "C1");

        Student student1 = new Student("Anna", "Marchi");
        Student student2 = new Student("Marco", "Ruggieri");
        Student student3 = new Student("Ivan", "Bernasconi");
        Student student4 = new Student("Raf", "Bosch");
        Student student5 = new Student("Pillar", "Moura");
        Student student6 = new Student("Rosane", "Miguel");

        Enrollment enrollment1 = new Enrollment(student1);
        Enrollment enrollment2 = new Enrollment(student2);
        Enrollment enrollment3 = new Enrollment(student3);
        Enrollment enrollment4 = new Enrollment(student4);
        Enrollment enrollment5 = new Enrollment(student5);
        Enrollment enrollment6 = new Enrollment(student6);

        Seminar english = new Seminar("Lugano", 10, course1);
        Seminar deutsch = new Seminar("Lugano", 12, course2);
        Seminar espagnolo = new Seminar("Lugano", 8, course3);

        english.addEnrollment(enrollment1);
        english.addEnrollment(enrollment2);
        deutsch.addEnrollment(enrollment3);

        espagnolo.addEnrollment(enrollment4);
        espagnolo.addEnrollment(enrollment5);
        espagnolo.addEnrollment(enrollment6);

        assertThat(course1.getName(), is("English"));
        assertThat(course1.getNumber(), is("1"));
        assertThat(course1.getDescription(), is("A1"));
        assertThat(student1.getFullName(), is("Anna Marchi"));
        assertThat(student2.getFullName(), is("Marco Ruggieri"));
        assertThat(student3.getFullName(), is("Ivan Bernasconi"));
        assertThat(student4.getFullName(), is("Raf Bosch"));
        assertThat(student5.getFullName(), is("Pillar Moura"));
        assertThat(student6.getFullName(), is("Rosane Miguel"));
        assertThat(enrollment1.getInfo(), is("Anna Marchi"));

        assertThat(english.getSeatsLeft(), is(8));
        assertThat(deutsch.getName(), is("Deutsch"));
        assertThat(espagnolo.getDescription(), is("C1"));
        assertThat(espagnolo.getLocation(), is("Lugano"));
        assertThat(espagnolo.getStudentList(), hasSize(3));
        assertThat(english.getStudentList(), containsInAnyOrder(enrollment1, enrollment2));
        assertThat(deutsch.getStudentList(), containsInAnyOrder(enrollment3));

    }
}
