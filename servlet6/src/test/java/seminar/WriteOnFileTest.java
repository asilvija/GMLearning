package seminar;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Test;

import com.app.seminar.model.Course;
import com.app.seminar.model.Student;

public class WriteOnFileTest {

    @Test
    public void checkPrintCsv() throws Exception {
        Course course = new Course(1, "English", "A1", "", 2, "20.03.2019");
        course.addStudent(new Student(1, "Anna", "Marchi"));
        course.addStudent(new Student(1, "Marco", "Ruggieri"));
        course.formatCsv();
        BufferedReader _input = new BufferedReader(new FileReader("English.csv"));
        String attributes[] = _input.readLine().split(";");
        assertThat(attributes[0], is("1"));
        assertThat(attributes[1], is("English"));
        assertThat(attributes[2], is("A1"));
        assertThat(attributes[3], is("Lugano"));
        assertThat(attributes[4], is("3"));
        _input.close();
    }
}
