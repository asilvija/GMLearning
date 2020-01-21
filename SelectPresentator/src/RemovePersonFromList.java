import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RemovePersonFromList implements Action {

    private Scanner _in;
    private final String _fileName;
    private final MenuSelection _menuSelection;
    private final Store _store;

    public RemovePersonFromList(Scanner in, String fileName, String date) {
        setIn(in);
        _fileName = fileName;
        _store = new Store(_fileName);
        _menuSelection = new MenuSelection(date);
    }

    @Override
    public void exec() {
        getMenuSelection().viewParticipantList();
        System.out.println(
            "\nChoose the index of the person you want to exclude from the participiants list!(press any key to quit)");
        int index = 0;
        List<Person> _participiants = _store.readParticipiantList();
        try {
            do {
                _participiants = new Store(_fileName).readParticipiantList();
                _in = new Scanner(System.in);
                index = _in.nextInt();

                setPersonAbsent(index, _participiants);
                new Store(_fileName).writeCsvFile(_participiants);
                getMenuSelection().viewParticipantList();

            } while (index > 0 && index < _participiants.size());
        } catch (InputMismatchException e) {

        }
    }

    private void setPersonAbsent(int index, List<Person> _participiants) {
        for (Person person : _participiants) {
            if (person.getKey() == index) {
                person.setKey(0);
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

    public MenuSelection getMenuSelection() {
        return _menuSelection;
    }

}
