import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
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
                
                switch (menuSelection) {
                    case 1:
                        addPresonToList(in);
                        break;
                    case 2:
                        removePersonFromList(in);
                        break;
                    case 3:
                        selectRandomPresentator();
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
                System.out.println(person.getIndex() + " " + person.getFullName() + " " + person.getIndex()
                    + " is absent " + person.isAbsent());
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

    public void addPresonToList(Scanner in) {
        String fullName;
        ArrayList<Person> _participiants = new Store(_fileName).readParticipiantList();
        do {
            in = new Scanner(System.in);
            System.out.println("Insert participiant full name (Press q to exit):");
            fullName = in.nextLine();
            if (!fullName.equals("q")) {
                String[] result = fullName.split(" ");
                String firstName = result[0];
                String lastName = "";
                if (result.length > 1) {
                    lastName = result[1];
                }
                Person person = new Person(_participiants.size() + 1, firstName, lastName, false);
                _participiants.add(person);
            }
        } while (!fullName.equals("q"));
        String[] csvColumnNames = { "firstName", "lastName", "isAbsent" };
        new Store(_fileName).writeParticipiantList(csvColumnNames, _participiants);
        new MenuSelection().showMenuOptions();
    }

    public void removePersonFromList(Scanner in) {
        new MenuSelection().viewParticipantList();

        System.out.println("\nChoose the index of the person you want to exclude from the participiants list!");
        int index = 0;
        ArrayList<Person> _participiants = new Store(_fileName).readParticipiantList();
        try {
            do {
                _participiants = new Store(_fileName).readParticipiantList();
                in = new Scanner(System.in);
                index = in.nextInt();

                for (Person person : _participiants) {
                    if (person.getIndex() == index) {
                        person.setIndex(0);
                        person.setAbsent(true);
                    }
                }
                String[] csvColumnNames = { "firstName", "lastName", "isAbsent" };
                new Store(_fileName).writeParticipiantList(csvColumnNames, _participiants);
                new MenuSelection().viewParticipantList();

            } while (index > 0 && index < _participiants.size());
        } catch (InputMismatchException e) {
            new MenuSelection().showMenuOptions();
        }
        new MenuSelection().showMenuOptions();
    }

    public void selectRandomPresentator() {
        ArrayList<Person> _participiants = new Store(_fileName).readParticipiantList();
        Random randomGenerator = new Random();
        ArrayList<Person> presentParticipiant = new ArrayList<>();
        for (Person person : _participiants) {
            if (!person.isAbsent()) {
                presentParticipiant.add(person);
            }
        }
        int index = randomGenerator.nextInt(presentParticipiant.size());
        Person randomPresentator = presentParticipiant.get(index);
        System.out.println("random Presentor " + randomPresentator.getFullName() + "\n");
        new MenuSelection().showMenuOptions();
    }
}
