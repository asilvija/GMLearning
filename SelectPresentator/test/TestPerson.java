import static java.util.Arrays.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestPerson {

    private final Person person = new Person(1, new ArrayList<>(asList("hello", "world", "false")));

    @Test
    public void nameCheck() {

        assertThat(person.getFirstName(), is("hello"));
        assertThat(person.getLastName(), is("world"));
        assertThat(person.getFullName(), is("hello world"));
    }

    @Test
    public void checkKey() {
        person.setKey(2);

        assertThat(person.getKey(), is(2));
    }
    @Test
    public void checkPresence() {
        
        person.setAbsent(true);
        
        assertThat(person.isAbsent(), is(true)); 
    }
}
