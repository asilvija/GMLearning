import static java.util.Arrays.*;
import static org.apache.commons.io.FileUtils.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import renderer.CsvRenderer;

public class TestAddPersonToList {
    private static final String FILE_NAME = "participiantsList_30.12.2020.csv";

    @Before
    public void init() {
        FileUtils.deleteQuietly(new File(FILE_NAME));
    }

    @Test
    public void execAddPersonToList() {

        String values = "\nAnna Marone\nq\n5";

        ByteArrayInputStream input = new ByteArrayInputStream(values.getBytes());
        AddPersonToList addPersonToList = new AddPersonToList(input, FILE_NAME);
        addPersonToList.exec();

        assertThat(participants(), hasSize(2));
        assertThat(participants().get(1), containsString("Anna"));
    }

    @Test
    public void renderCsv() {
        // prepare
        List<Person> participiants = Arrays.asList(new Person(1, Arrays.asList("Anna", "Marone", "false")),
            new Person(1, Arrays.asList("Marco", "Demarchi", "false")));
        List<List<String>> data = new ArrayList<>();
        data.add(asList("firstName", "lastName", "isAbsent"));
        for (Person person : participiants) {
            data.add(asList(person.getFirstName(), person.getLastName(), String.valueOf(person.isAbsent())));
        }

        // act
        String result = new CsvRenderer(data).render();

        // assert
        assertThat(result, containsString("firstName,lastName,isAbsent,\nAnna,Marone,false"));
    }

    private List<String> participants() {
        try {
            return readLines(new File(FILE_NAME), StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
