import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SelectRandomPresentator implements Action {
    private final Scanner _in;
    private final ArrayList<Person> _participiants;
    private final String _fileName;
    
    public SelectRandomPresentator(Scanner in, ArrayList<Person> participiants, String fileName) {
        _in = in;
        _participiants = participiants;
        _fileName = fileName;
    }
    @Override
    public void exec() {
        Random  randomGenerator = new Random();
        ArrayList<Person> presentParticipiant = new ArrayList<>();
        for (Person person : _participiants) {
            if (!person.isAbsent()) {
                presentParticipiant.add(person);
            }
        }
        int index = randomGenerator.nextInt(presentParticipiant.size());
        Person randomPresentator = presentParticipiant.get(index);   
        System.out.println("random Presentor "+ randomPresentator.getFullName() + "\n");
        MenuSelection.showMenuOptions();
    }
    public Scanner getIn() {
        return _in;
    }
    public ArrayList<Person> getParticipiants() {
        return _participiants;
    }
    public String getFileName() {
        return _fileName;
    }

}
