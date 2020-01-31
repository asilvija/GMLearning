import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import utils.FakeRandomizer;

public class TestSelectRandomPresentator {

    @Test
    public void checkRandomizer() throws Exception {

        List<Person> participiants = Arrays.asList(new Person(1, Arrays.asList("Anna", "Marone", "false")),
            new Person(1, Arrays.asList("Marco", "Demarchi", "false")));

        int index = new FakeRandomizer(1).getRandomNumber(participiants.size());

        assertThat(index, is(1));
        assertThat(participiants.get(index).getFirstName(), is("Marco"));
    }
}
