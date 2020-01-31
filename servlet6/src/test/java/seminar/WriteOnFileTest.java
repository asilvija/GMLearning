package seminar;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Test;

import com.app.seminar.Course;
import com.app.seminar.Seminar;
import com.app.seminar.Student;

public class WriteOnFileTest {

    @Test
    public void checkPrintCsv() throws Exception {
        Seminar seminar = new Seminar("Lugano", 10, new Course("1", "English", "A1", "20.03.2019"));

        seminar.addStudent(new Student("Anna", "Marchi"));
        seminar.addStudent(new Student("Marco", "Ruggieri"));
        seminar.renderCsv();

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
