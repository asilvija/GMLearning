import static java.util.Arrays.*;
import static org.apache.commons.io.FileUtils.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

public class TestStore {
    private static final String FILE_NAME = "/tmp/participiantsList.csv";

    @Before
    public void init() {
        FileUtils.deleteQuietly(new File(FILE_NAME));
    }

    @Test
    public void storeWritesPersonListOnFile() throws Exception {
        FileUtils.writeLines(new File(FILE_NAME), asList("firstName,lastName,isAbsent", "Anna,Marone,false"));

   
        assertThat(participants().get(0), containsString("firstName,lastName,isAbsent"));
        assertThat(participants().get(1), containsString("Anna,Marone"));
    }

    @Test
    public void storeReadsPersonListFromFile() throws Exception {
        FileUtils.writeLines(new File(FILE_NAME), asList("name,lastname,absent", "Anna,Marone,false"));

        List<Person> readParticipiants = new Store(FILE_NAME).readParticipiantList();

        assertThat(readParticipiants, hasSize(1));
        assertThat(readParticipiants.get(0).isAbsent(), is(false));
        assertThat(readParticipiants.get(0).getFirstName(), is("Anna"));
    }

    private List<String> participants() {
        try {
            return readLines(new File(FILE_NAME), StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
