import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectRandomPresentator implements Action {
    private final String _fileName;

    public SelectRandomPresentator(String fileName) {
        _fileName = fileName;
    }

    @Override
    public void exec() {
        List<Person> _participiants = new Store(_fileName).readParticipiantList();

        selectRandomPresentator(_participiants);
    }

    private void selectRandomPresentator(List<Person> _participiants) {
        Random randomGenerator = new Random();
        ArrayList<Person> presentParticipiant = new ArrayList<>();
        for (Person person : _participiants) {
            if (!person.isAbsent()) {
                presentParticipiant.add(person);
            }
        }
        int index = randomGenerator.nextInt(presentParticipiant.size());
        Person randomPresentator = presentParticipiant.get(index);
        System.out.println("random Presentor " + randomPresentator.getFullName() + "\n");
    }
}
