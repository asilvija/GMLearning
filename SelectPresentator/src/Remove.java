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
        System.out.println("Choose the index of the person you want to exclude from the participiants list!");

        for (Person person : _participiants) {
            System.out.println(person.getIndex() + " " + person.getFullName());
        }
        int index = 0;
        do {
            _in = new Scanner(System.in);
            index = _in.nextInt();

            for (Person person : _participiants) {
                if ((person.getIndex()) == index) {
                    System.out.println("found participiant=" + person.getFullName());
                }
            }
        } while (index > 0 && index < _participiants.size());
    }

    public ArrayList<Person> getParticipiants() {
        return _participiants;
    }

    public String getFileName() {
        return _fileName;
    }

}
