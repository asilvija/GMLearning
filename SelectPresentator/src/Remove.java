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

          MenuSelection.viewPartecipantList();
//        do {
   
            System.out.println("\nChoose the index of the person you want to exclude from the participiants list!");
            _in = new Scanner(System.in);
            int index = _in.nextInt();
            
            for (Person person : _participiants) {
                if (person.getIndex() == index) {
                    person.setAbsent(true);
                    System.out.println("found participiant=" + person.getFullName() + " " + person.getIndex());
                }
            }
 
//        } while (index > 0 && index < _participiants.size() + 1 );
        WriteCsvFile.writeOnFile(_fileName, _participiants);
        MenuSelection.showMenuOptions();
    }

    public ArrayList<Person> getParticipiants() {
        return _participiants;
    }

    public String getFileName() {
        return _fileName;
    }

}
