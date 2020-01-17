import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RemovePersonFromList implements Action {
    
    private Scanner _in;
    private final String _fileName;

    public RemovePersonFromList(Scanner in, String fileName) {
        setIn(in);
        _fileName = fileName;
    }

    @Override
    public void exec() {
        new MenuSelection().viewParticipantList();

        System.out.println("\nChoose the index of the person you want to exclude from the participiants list!(press any key to quit)");
        int index = 0;
        ArrayList<Person> _participiants = new Store(_fileName).readParticipiantList();
        try {
            do {
                _participiants = new Store(_fileName).readParticipiantList();
                _in = new Scanner(System.in);
                index = _in.nextInt();

                setPersonAbsent(index, _participiants);
                String[] csvColumnNames = { "firstName","lastName","isAbsent" };
                new Store(_fileName).writeParticipiantList(csvColumnNames, _participiants);
                new MenuSelection().viewParticipantList();

            } while (index > 0 && index < _participiants.size());
        } catch (InputMismatchException e) {
            new MenuSelection().showMenuOptions();
        }
        new MenuSelection().showMenuOptions();
    }

    private void setPersonAbsent(int index, ArrayList<Person> _participiants) {
        for (Person person : _participiants) {
            if (person.getIndex() == index) {
                person.setIndex(0);
                person.setAbsent(true);
            }
        }
    }

    public Scanner getIn() {
        return _in;
    }

    public void setIn(Scanner in) {
        _in = in;
    }

}
