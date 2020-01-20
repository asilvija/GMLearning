import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RemovePersonFromList implements Action {

    private Scanner _in;
    private final String _fileName;
    private final MenuSelection _menuSelection;
    private final Store _store;

    public RemovePersonFromList(Scanner in, String fileName, MenuSelection menuSelection) {
        setIn(in);
        _fileName = fileName;
        _menuSelection = menuSelection;
        _store = new Store(_fileName);
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
            getMenuSelection().showMenuOptions();
        }
        getMenuSelection().showMenuOptions();
    }

    private void setPersonAbsent(int index, List<Person> _participiants) {
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

    public MenuSelection getMenuSelection() {
        return _menuSelection;
    }

}
