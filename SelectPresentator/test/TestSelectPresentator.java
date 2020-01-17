import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestSelectPresentator {

    @Test
    public void checkPerson() {
        List<String> attributes = new ArrayList<>(Arrays.asList("Anna", "Marone"));
        attributes.add("false");
        Person person = new Person(1, attributes);
        ArrayList<Person> _participiants = new ArrayList<>();
        _participiants.add(person);
        String[] csvColumnNames = { "firstName", "lastName", "isAbsent" };
        new Store("participiantsList.csv").writeParticipiantList(csvColumnNames, _participiants);
        _participiants = new Store("participiantsList.csv").readParticipiantList();
        
        assertThat(_participiants, hasSize(1));

        assertThat(person.isAbsent(), is(false));
        
        person.setAbsent(true);
        
        assertThat(person.isAbsent(), is(true));
        assertThat(person.getFirstName(), is("Anna"));
        assertThat(person.getLastName(), is("Marone"));
        assertThat(person.getIndex(), is(1));
        person.setIndex(2);
        assertThat(2, is(person.getIndex()));
        assertThat(person.getFullName(), is("Anna Marone"));
    }

    @Test
    public void checkFile() {

        BufferedReader csvReader = null;
        try {
            csvReader = new BufferedReader(new FileReader("participiantsList.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("No file found..");
        }

        try {
            String attributes[] = csvReader.readLine().split(",");
            assertThat(attributes[0], is("firstName"));
            assertThat(attributes[1], is("lastName"));
            assertThat(attributes[2], is("isAbsent"));
            csvReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void writeOnFile() {
        try {
            FileWriter fw = new FileWriter("participiantsList.csv");
            fw.write("firstName,lastName,isAbsent");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void menuSelection() {
        new MenuSelection().viewParticipantList();

    }
}
