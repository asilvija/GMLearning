import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuSelection {
    private final String _fileName = "participiantsList.csv";

    public void getMenuSelection() {
        showMenuOptions();
        int menuSelection = 0;
        final Scanner in = new Scanner(System.in);
        try {
            do {
                menuSelection = in.nextInt();
                switch (menuSelection) {
                case 1:
                    new AddPersonToList(in, _fileName).exec();
                    break;
                case 2:
                    new RemovePersonFromList(in, _fileName).exec();
                    break;
                case 3:
                    new SelectRandomPresentator(_fileName).exec();
                    break;
                default:
                    break;
                }
            } while (menuSelection > 0 && menuSelection < 4);
        } catch (InputMismatchException e) {
            System.out.println("End..");
        }
        in.close();
    }

    public List<Person> viewParticipantList() {
        ArrayList<Person> _participiants = new Store(_fileName).readParticipiantList();

        System.out.println("Participiants list:\n");
        for (Person person : _participiants) {
            if (!person.isAbsent()) {
                System.out.println(
                    person.getIndex() + " " + person.getFullName() + " " + " is absent " + person.isAbsent());
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
