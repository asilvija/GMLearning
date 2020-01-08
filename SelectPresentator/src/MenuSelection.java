import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuSelection {
    static final String fileName = "participiantsList.csv";
    static private ArrayList<Person> participiants = ReadCsvFile.readFile(fileName);
    public static List<Person> viewPartecipantList() {
        
        System.out.println("Participiants list:\n");
        int index = 0;
        for (Person person : participiants) {
            if (!person.isAbsent()) {
                index ++;
                person.setIndex(index);
                System.out.println(index + " " + person.getFullName());
            }
        }
        return participiants;
    }

    public static void showMenuOptions() {
        viewPartecipantList();
        System.out.println("---------------------------------------------");
        System.out.print(
            "Select one of the options(Press any other key for exit):\n\n"
          + "1. Add person to the participians list\n"
          + "2. Remove person from the participiants list\n"
          + "3. Choose random presentator\n");
        System.out.println("---------------------------------------------");
    }

    public static void menuSelection() {
        showMenuOptions();
        int menuSelection = 0;
        final Scanner in = new Scanner(System.in);
        try {
            do {
                menuSelection = in.nextInt();
                Map<Integer, Action> map = new HashMap<Integer, Action>() {{
                    put(1, new AddPersonToList(in, participiants, fileName));
                    put(2, new Remove(in, participiants, fileName));
                    put(3, new SelectRandomPresentator(in, participiants, fileName));
                }};   
                map.get(menuSelection).exec();
            } while (menuSelection > 0 && menuSelection < 4);
        } catch (InputMismatchException e) {
            // exit
        }
        in.close();
    }
}
