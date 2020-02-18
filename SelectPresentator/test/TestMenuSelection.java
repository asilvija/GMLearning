import static org.apache.commons.io.FileUtils.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

public class TestMenuSelection {
    private static final String FILE_NAME = "participiantsList_30.12.2020.csv";


    @Before
    public void init() {
        FileUtils.deleteQuietly(new File(FILE_NAME));
    }
    
    @Test
    public void menuSelectionExecutesSelectedActionFromInput() throws Exception {
        String values = "1\nAnna Marone\nq\n5";
        ByteArrayInputStream input = new ByteArrayInputStream(values.getBytes());

        new MenuSelection("30.12.2020", input).exec();

        assertThat(participants(), hasSize(2));
        assertThat(participants().get(1), containsString("Anna"));
    }
    
    @Test
    public void input() {
        String values = "1\nAnna Marone\nq\n5";
        ByteArrayInputStream input = new ByteArrayInputStream(values.getBytes());
        Scanner sc = new Scanner(input);
        
        assertThat(sc.nextInt(), is(1));
        assertThat(sc.nextLine(), is(""));
        assertThat(sc.nextLine(), is("Anna Marone"));
        assertThat(sc.nextLine(), is("q"));
        assertThat(sc.nextInt(), is(5));
    }

    private List<String> participants() {
        try {
            return readLines(new File(FILE_NAME), StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
