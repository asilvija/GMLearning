import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SelectRandomPresentator implements Action {
    private final Scanner _in;
    private final String _fileName;

    public SelectRandomPresentator(Scanner in, String fileName) {
        _in = in;
        _fileName = fileName;
    }

    @Override
    public void exec() {
        ArrayList <Person> _participiants = new ReadCsvFile(_fileName).readFile();
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
        new MenuSelection().showMenuOptions();
    }

    public Scanner getIn() {
        return _in;
    }

    public String getFileName() {
        return _fileName;
    }

}
