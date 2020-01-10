import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuSelection {
    private final String _fileName = "participiantsList.csv";

    public void menuSelection() {
        showMenuOptions();
        int menuSelection = 0;
        final Scanner in = new Scanner(System.in);
        try {
            do {
                menuSelection = in.nextInt();
                Map<Integer, Action> map = new HashMap<Integer, Action>() {
                    {
                        put(1, new AddPersonToList(in, _fileName));
                        put(2, new Remove(in,_fileName));
                        put(3, new SelectRandomPresentator(in, _fileName));
                    }
                };
                map.get(menuSelection).exec();
            } while (menuSelection > 0 && menuSelection < 4);
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
        in.close();
    }

    public List<Person> viewParticipantList() {
        ArrayList<Person> _participiants = new ReadCsvFile(_fileName).readFile();

        System.out.println("Participiants list:\n");
        for (Person person : _participiants) {
            if (!person.isAbsent()) {
                System.out.println(person.getIndex() + " " + person.getFullName() + " " + person.getIndex() + " is absent " + person.isAbsent());
            }
        }
        return _participiants;
    }

    public void showMenuOptions() {
        viewParticipantList();
        System.out.println("---------------------------------------------");
        System.out.print(
            "Select one of the options(Press any other key for exit):\n\n"
                + "1. Add person to the participians list\n"
                + "2. Remove person from the participiants list\n"
                + "3. Choose random presentator\n");
        System.out.println("---------------------------------------------");
    }
}
