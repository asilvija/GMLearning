import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuSelection {
    static final String fileName = "participiantsList.csv";
    static ArrayList<Person> participiants = ReadCsvFile.readFile(fileName);
    public static List<Person> viewPartecipantList() {
        
        System.out.println("Participiants list:\n");
        for (Person person : participiants) {
            System.out.println(person.getIndex() + " " + person.getFullName());
        }
        return participiants;
    }

    public static void addPersonToList(Scanner scan) {
        // TODO
        // add participants to meeting
        String fullName;
        do {
            scan = new Scanner(System.in);
            System.out.println("Insert participiant full name (Press q to exit):");
            fullName = scan.nextLine();
            if (!fullName.equals("q")) {
                // insert participant to the list  
//                write_on_file(name, "participiants.txt", "");
//
//                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                Date date = new Date(System.currentTimeMillis());
//                String current_date = formatter.format(date);
//
//                delete_name_from_file(name, "log.txt", current_date);
              
                String [] result =fullName.split(" ");
                String firstName = result[0];
                String lastName = "";
                if (result.length > 1) {
                    lastName = result[1];
                }
                System.out.println("firstName= " + firstName + " last name=" + lastName);
                Person person = new Person(participiants.size() + 1,firstName, lastName, false);
                participiants.add(person);
                
            }
        } while (!fullName.equals("q"));
        
        WriteCsvFile.writeOnFile(fileName, participiants);
        
        for (Person person : participiants) {
            System.out.println(person.getIndex() + " " + person.getFullName());
        }
        showMenuOptions();
    }

    public static void removeParticipantFromList() {
        // TODO remove participiant from list
    }

    public void selectRandomPresentator() {
        // TODO
        // random chooser of the presentator
    }

    public static void showMenuOptions() {
        System.out.println("---------------------------------------------");
        System.out.print(
            "Select one of the options(Press any other key for exit):\n\n"
          + "1. Add person to the participians list\n"
          + "2. Remove person from the participiants list\n"
          + "3. Choose random presentator\n");
        System.out.println("---------------------------------------------");
    }

    public static void menuSelection() {
        viewPartecipantList();
        showMenuOptions();
        int menuSelection = 0;
        final Scanner in = new Scanner(System.in);
        try {
            do {
                menuSelection = in.nextInt();

                Map<Integer, Action> map = new HashMap<Integer, Action>() {{
                    put(1, new AddPersonToList(in, participiants, fileName));
                    put(2, new Remove(in, participiants, fileName));
                    put(3, new SelectRandomPresentator());
                }};
                
                map.get(menuSelection).exec();
                
//                switch (menuSelection) {
//                case 1:
//                    // add participant
//                    System.out.println("addPersonToList");
//                    addPersonToList(in);
//                    break;
//                case 2:
//                    // remove participant
//                    System.out.println("removeParticipantFromList");
//                    removeParticipantFromList();
//                    break;
//                case 3:
//                    // choose random participant
//                    System.out.println("selectRandomPresentator");
//                    break;
//                default:
//                    break;
//                }
            } while (menuSelection > 0 && menuSelection < 4);
        } catch (InputMismatchException e) {
            // exit
        }
        in.close();
    }
}
