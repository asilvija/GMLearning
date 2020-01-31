import static org.apache.commons.io.FileUtils.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

public class TestRemovePersonFromList {

    private static final String FILE_NAME = "participiantsList_30.12.2020.csv";

    @Before
    public void init() {
        FileUtils.deleteQuietly(new File(FILE_NAME));
    }

    @Test
    public void execRemovePersonFromList() {

        List<Person> participiants = Arrays.asList(new Person(1, Arrays.asList("Anna", "Marone", "false")));
        new Store(FILE_NAME).writeCsvFile(participiants);
        String values = "1\nq";

        ByteArrayInputStream input = new ByteArrayInputStream(values.getBytes());
        RemovePersonFromList removePerson = new RemovePersonFromList(new Scanner(input), FILE_NAME, "30.12.2020");
        removePerson.exec();

        assertThat(participants().size(), is(2));
        assertThat(participants().get(1), containsString("true"));
    }

    private List<String> participants() {
        try {
            return readLines(new File(FILE_NAME), StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
