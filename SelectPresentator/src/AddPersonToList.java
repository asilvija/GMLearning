import java.util.ArrayList;
import java.util.Scanner;

public class AddPersonToList implements Action {

    private Scanner _in;
    private final ArrayList<Person> _participiants;
    private final String _fileName;

    public AddPersonToList(Scanner in, ArrayList<Person> participiants, String fileName) {
        _in = in;
        _participiants = participiants;
        _fileName = fileName;
    }

    @Override
    public void exec() {
        // TODO
        String fullName;
        do {
            _in = new Scanner(System.in);
            System.out.println("Insert participiant full name (Press q to exit):");
            fullName = _in.nextLine();
            if (!fullName.equals("q")) {
                String[] result = fullName.split(" ");
                String firstName = result[0];
                String lastName = "";
                if (result.length > 1) {
                    lastName = result[1];
                }
                Person person = new Person(firstName, lastName, false);
                _participiants.add(person);
//                new MenuSelection().viewParticipantList();
            }
        } while (!fullName.equals("q"));
        String[] csvColumnNames = {"firstName","lastName","isAbsent"};
        new WriteCsvFile(_fileName).writeOnFile(csvColumnNames, _participiants);
        new MenuSelection().showMenuOptions();
    }
}
