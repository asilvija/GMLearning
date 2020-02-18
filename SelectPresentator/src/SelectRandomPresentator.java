import java.util.ArrayList;
import java.util.List;

import utils.NumberRandomizer;

public class SelectRandomPresentator implements Action {
    private final String _fileName;

    public SelectRandomPresentator(String fileName) {
        _fileName = fileName;
    }

    @Override
    public void exec() throws Exception {
        List<Person> _participiants = new Store(_fileName).readParticipiantList();

        selectRandomPresentator(_participiants);
    }

    private void selectRandomPresentator(List<Person> _participiants) {

        ArrayList<Person> presentParticipiant = getParticipaintList(_participiants);

        int index = new NumberRandomizer().getRandomNumber(presentParticipiant.size());
        Person randomPresentator = presentParticipiant.get(index);
        System.out.println("random Presentor " + randomPresentator.getFullName() + "\n");
    }

    private ArrayList<Person> getParticipaintList(List<Person> _participiants) {
        ArrayList<Person> presentParticipiant = new ArrayList<>();
        for (Person person : _participiants) {
            if (!person.isAbsent()) {
                presentParticipiant.add(person);
            }
        }
        return presentParticipiant;
    }
}
