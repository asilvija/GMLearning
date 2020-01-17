import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AddPersonToList implements Action {

    private Scanner _in;
    private final String _fileName;

    public AddPersonToList(Scanner in, String fileName) {
        _in = in;
        _fileName = fileName;
    }

    @Override
    public void exec() {
        String fullName;
        ArrayList<Person> _participiants = new Store(_fileName).readParticipiantList();
        do {
            _in = new Scanner(System.in);
            System.out.println("Insert participiant full name (Press q to exit):");
            fullName = _in.nextLine();
            if (!fullName.equals("q")) {
                addPersonToList(fullName, _participiants);
            }
        } while (!fullName.equals("q"));
        
        String[] csvColumnNames = { "firstName", "lastName", "isAbsent" };
        new Store(_fileName).writeParticipiantList(csvColumnNames, _participiants);
        new MenuSelection().showMenuOptions();
    }

    private void addPersonToList(String fullName, ArrayList<Person> _participiants) {
        String[] result = fullName.split(" ");
        List<String> attributes = new ArrayList<>(Arrays.asList(result));
        attributes.add("false");

        Person person = new Person(_participiants.size() + 1, attributes);
        _participiants.add(person);
    }
}
