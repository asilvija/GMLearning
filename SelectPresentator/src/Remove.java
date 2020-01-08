import java.util.ArrayList;
import java.util.Scanner;

public class Remove implements Action {
    private Scanner _in;
    private final ArrayList<Person> _participiants;
    private final String _fileName;

    public Remove(Scanner in, ArrayList<Person> participiants, String fileName) {
        _in = in;
        _participiants = participiants;
        _fileName = fileName;
    }

    @Override
    public void exec() {

        new MenuSelection().viewParticipantList();

        System.out.println("\nChoose the index of the person you want to exclude from the participiants list!");
        _in = new Scanner(System.in);
        int index = _in.nextInt();
        System.out.println("index to find..." + index);
        for (Person person : _participiants) {

            System.out.println("participiants..." + person.getFullName() + " " + person.getIndex() + " is absent "
                + person.isAbsent());

            if (person.getIndex() == index) {
                // person.setIndex(0);
                person.setAbsent(true);
                new MenuSelection().viewParticipantList();
            }
        }
        String[] csvColumnNames = { "firstName", "lastName", "isAbsent" };
        new MenuSelection().showMenuOptions();
        new WriteCsvFile(_fileName).writeOnFile(csvColumnNames, _participiants);
    }

    public ArrayList<Person> getParticipiants() {
        return _participiants;
    }

    public String getFileName() {
        return _fileName;
    }

}
